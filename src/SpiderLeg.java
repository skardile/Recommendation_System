import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private List<String> links = new LinkedList<String>();
	private Document htmlDocument;

	/**
	 * This performs all the work. It makes an HTTP request, checks the
	 * response, and then gathers up all the links on the page. Perform a
	 * searchForWord after the successful crawl
	 * 
	 * @param url
	 *            - The URL to visit
	 * @return whether or not the crawl was successful
	 */
	public boolean crawl(String url, String path) {
		String fileName = null;
		File file = null;
		int index = -1;
		int j = 0;
		String path1 = path;
		try {
			if (!links.contains(url)) {
				Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
				Document htmlDocument = connection.get();
				this.htmlDocument = htmlDocument;
				if (connection.response().statusCode() == 200) // 200 is the
																// HTTP OK
																// status code
																// indicating
																// that
																// everything is
																// great.
				{
					System.out.println("\n**Visiting** Received web page at " + url);
				}
				if (!connection.response().contentType().contains("text/html")) {
					System.out.println("**Failure** Retrieved something other than HTML");
					return false;
				}
				for (j = url.length() - 1; j > 0; j--) {
					if (url.charAt(j) == '/') {
						index = j;
						break;
					}
				}
				System.out.println(j);

				String fName = url.substring(j + 1, url.length());

				Elements elements = htmlDocument.getAllElements();

				int i = 0;
				path = path1 + "\\" + fName + Integer.toString(i) + ".txt";
				System.out.println(path);
				file = new File(path);

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				for (Element element : elements) {

					if (element.tagName() == "p") {
						bw.write(element.text());
						bw.write(System.lineSeparator());
					} else

					if (element.tagName() == "pre") {
						bw.write("code");
						bw.write(System.lineSeparator());

						Elements spanList = element.select("span");

						for (Element sp : spanList) {

							if (sp.hasClass("lineno")) {
								bw.newLine();
							} else {
								bw.write((sp.text() + " "));
							}

						}

						bw.write(System.lineSeparator());
						bw.write("code ends");
						bw.write(System.lineSeparator());
					} else if ((element.hasClass("mw-headline") || element.tagName() == "h1")
							&& element.text() != "Navigation menu") {
						bw.close();
						path = path1 + "\\" + fName + Integer.toString(i++) + ".txt";
						file = new File(path);
						// Files.write(file, lines, Charset.forName("UTF-8"));
						fw = new FileWriter(file.getAbsoluteFile());
						bw = new BufferedWriter(fw);
						if (element.hasClass("mw-headline"))
							bw.write(url + "#" + element.id());
						else
							bw.write(url);
						bw.write(System.lineSeparator());
						bw.write(element.text());
						System.out.println("***********************");
						System.out.println(element.text());
						System.out.println("***********************");
						bw.write(System.lineSeparator());
					}

				}
				bw.close();
				Elements linksOnPage = htmlDocument.select("a[href]");
				System.out.println("Found (" + linksOnPage.size() + ") links");
				for (Element link : linksOnPage) {

					if (link.absUrl("href").contains("https://en.wikibooks.org/wiki/Java_Programming")
							&& !(link.absUrl("href").contains("#")) && !(link.absUrl("href").contains("Print_version")))
						this.links.add(link.absUrl("href"));
				}
				return true;
			}
			return false;
		} catch (IOException ioe) {
			// We were not successful in our HTTP request
			return false;
		}
	}

	/**
	 * Performs a search on the body of on the HTML document that is retrieved.
	 * This method should only be called after a successful crawl.
	 * 
	 * @param searchWord
	 *            - The word or string to look for
	 * @return whether or not the word was found
	 */
	public boolean searchForWord(String searchWord) {
		// Defensive coding. This method should only be used after a successful
		// crawl.
		if (this.htmlDocument == null) {
			System.out.println("ERROR! Call crawl() before performing analysis on the document");
			return false;
		}
		System.out.println("Searching for the word " + searchWord + "...");
		String bodyText = this.htmlDocument.body().text();
		return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	}

	public List<String> getLinks() {
		return this.links;
	}
}
