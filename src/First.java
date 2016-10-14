
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryparser.classic.ParseException;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public First() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public static String formatPost(List<String> post) {
		StringBuilder recoPost = new StringBuilder();
		for (int i = 0; i < post.size(); i++) {
			recoPost.append('\n');
			recoPost.append(i + 1 + ". " + post.get(i));
			recoPost.append('\n');
		}

		return recoPost.toString();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String button = request.getParameter("post");

		String button2 = request.getParameter("crawl");
		second sc = new second();
		SpiderTest st = new SpiderTest();
		List<String> recommendedPost = new ArrayList<String>();
		List<String> keywords = new ArrayList<String>();
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/docs");
		String fullPath1 = context.getRealPath("/keywords");

		System.out.println("New Path: " + fullPath);

		if (button2 != null) {
			st.testCrawler(fullPath);
			System.out.println("Crawling done");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		if (button != null) {
			keywords = st.keywords(button, fullPath1);
			System.out.println("Key Size:" + keywords.size());

			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < keywords.size(); i++) {
				if (i != keywords.size() - 1)
					sb.append(keywords.get(i) + ", ");
				else
					sb.append(keywords.get(i));
			}

			request.setAttribute("keywords", sb.toString());

			recommendedPost = st.index(fullPath, sb.toString());
			request.setAttribute("message1", recommendedPost);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
