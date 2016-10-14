import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {
	private static final int MAX_PAGES_TO_SEARCH = 400;
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();

	/**
	 * Our main launching point for the Spider's functionality. Internally it
	 * creates spider legs that make an HTTP request and parse the response (the
	 * web page).
	 * 
	 * @param url
	 *            - The starting point of the spider
	 * @param searchWord
	 *            - The word or string that you are searching for
	 */
	public void search(String url, String path) {
		do {
			String currentUrl;
			SpiderLeg leg = new SpiderLeg();
			if (this.pagesToVisit.isEmpty()) {
				currentUrl = url;
				this.pagesVisited.add(url);
			} else {
				currentUrl = this.nextUrl();
			}
			if (currentUrl == null)
				break;
			boolean flag = leg.crawl(currentUrl, path);
			this.pagesToVisit.addAll(leg.getLinks());
			System.out.print(pagesToVisit.size());
		} while (!pagesToVisit.isEmpty());

	}

	/**
	 * Returns the next URL to visit (in the order that they were found). We
	 * also do a check to make sure this method doesn't return a URL that has
	 * already been visited.
	 * 
	 * @return
	 */
	private String nextUrl() {
		String nextUrl;
		do {
			nextUrl = this.pagesToVisit.remove(0);
		} while (this.pagesVisited.contains(nextUrl) && !pagesToVisit.isEmpty());
		if (pagesToVisit.isEmpty())
			return null;
		if (!this.pagesVisited.contains(nextUrl)) {
			pagesVisited.add(nextUrl);
			return nextUrl;

		}
		return null;
	}
}
