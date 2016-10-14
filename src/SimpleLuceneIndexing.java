import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lucene Demo: basic similarity based content indexing
 * 
 * @author Sharonpova Current sample files fragments of wikibooks and
 *         stackoverflow.
 */

public class SimpleLuceneIndexing {

	private static void indexDirectory(IndexWriter writer, File dir) throws IOException {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				indexDirectory(writer, f); // recurse
			} else if (f.getName().endsWith(".txt")) {
				// call indexFile to add the title of the txt file to your index
				// (you can also index html)
				indexFile(writer, f);
			}
		}
	}

	private static void indexFile(IndexWriter writer, File f) throws IOException {
		System.out.println("Indexing " + f.getName());
		Document doc = new Document();
		doc.add(new TextField("filename", f.getName(), TextField.Store.YES));

		// open each file to index the content
		try {

			// SpiderTest st = new SpiderTest();
			FileInputStream is = new FileInputStream(f);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(SpiderTest.stem(line)).append("\n");
			}
			reader.close();
			doc.add(new TextField("contents", stringBuffer.toString(), TextField.Store.YES));

		} catch (Exception e) {

			System.out.println("something wrong with indexing content of the files");
		}

		writer.addDocument(doc);

	}

	public List<String> luceneIndexing(String path, String post) throws IOException, ParseException {
		List<String> recommendedPost = new ArrayList<String>();
		String filepath = new File("").getAbsolutePath();
		System.out.println(filepath);
		File dataDir = new File(path);
		// Check whether the directory to be indexed exists
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(dataDir + " does not exist or is not a directory");
		}
		Directory indexDir = new RAMDirectory();

		// Specify the analyzer for tokenizing text.
		StandardAnalyzer analyzer = new StandardAnalyzer(StopAnalyzer.ENGLISH_STOP_WORDS_SET);
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(indexDir, config);

		// call indexDirectory to add to your index
		// the names of the txt files in dataDir
		indexDirectory(writer, dataDir);
		writer.close();

		// Query string!
		String querystr = post;

		/*
		 * //This is going to be your selected posts. Scanner console = new
		 * Scanner(System.in); String querystr = "contents:"+console.nextLine();
		 * System.out.println(querystr);
		 */

		Query q = new QueryParser("contents", analyzer).parse(QueryParser.escape(querystr));
		int hitsPerPage = 10;
		IndexReader reader = null;

		TopScoreDocCollector collector = null;
		IndexSearcher searcher = null;
		reader = DirectoryReader.open(indexDir);
		searcher = new IndexSearcher(reader);
		collector = TopScoreDocCollector.create(hitsPerPage);
		searcher.search(q, collector);

		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		System.out.println("Found " + hits.length + " hits.");
		System.out.println();

		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d;
			d = searcher.doc(docId);
			System.out.println("**************************************");
			System.out.println((i + 1) + ". " + d.get("filename"));

			BufferedReader brTest = new BufferedReader(new FileReader(new File(path + "\\" + d.get("filename"))));
			recommendedPost.add(brTest.readLine());
			String s1 = brTest.readLine();
			String s2 = brTest.readLine();
			String s3 = brTest.readLine();
			System.out.println("1 " + s1);
			System.out.println("2 " + s2);
			System.out.println("3 " + s3);

			recommendedPost.add(s1);
			if (s2 != null)
				recommendedPost.add(s2);
			else if (s3 != null)
				recommendedPost.add(s3);

			System.out.println("**************************************");
		}
		reader.close();
		return recommendedPost;

	}

}