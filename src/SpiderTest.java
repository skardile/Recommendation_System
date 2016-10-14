import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.util.Version;
import org.tartarus.snowball.ext.PorterStemmer;
//import org.apache.lucene.util.packed.PackedInts.Reader;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Analyzer.TokenStreamComponents;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.LowerCaseTokenizer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class SpiderTest {
	/**
	 * This is our test. It creates a spider (which creates spider legs) and
	 * crawls the web.
	 * 
	 * @param args
	 *            - not used
	 * @throws ParseException
	 * @throws IOException
	 */

	public List<String> index(String path, String post) throws IOException {

		List<String> recommendedPost = new ArrayList<String>();
		SimpleLuceneIndexing sl = new SimpleLuceneIndexing();

		try {
			recommendedPost = sl.luceneIndexing(path, post);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return recommendedPost;

	}

	public List<String> keywords(String post, String path) {
		JavaKeywordsReader jr = new JavaKeywordsReader();
		HashMap<String, Integer> map = jr.read(path);

		List<String> keyList = getKeywords(map, stem(post));

		return keyList;
	}

	public static String stem(String s) {
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();
		PorterStemmer stem = new PorterStemmer();

		EnglishAnalyzer en_an = new EnglishAnalyzer();
		QueryParser parser = new QueryParser("your_field", en_an);

		for (String st : str) {
			stem.setCurrent(st);
			stem.stem();
			sb.append(stem.getCurrent() + " ");

		}
		return (sb.toString());
	}

	public void testCrawler(String path) {
		Spider spider = new Spider();
		spider.search("https://en.wikibooks.org/wiki/Java_Programming", path);
	}

	public List<String> getKeywords(HashMap<String, Integer> map, String post) {
		{
			List<String> keywords = new ArrayList<String>();
			String[] str = post.split(" ");
			LinkedHashMap sortedMap;
			for (String string : str) {
				if (map.containsKey(string)) {

					map.put(string, map.get(string) + 1);

				}
			}

			List mapKeys = new ArrayList(map.keySet());
			List mapValues = new ArrayList(map.values());
			Collections.sort(mapValues);
			Collections.sort(mapKeys);

			sortedMap = new LinkedHashMap();
			String comp1 = null;
			Iterator valueIt = mapValues.iterator();
			while (valueIt.hasNext()) {
				Object val = valueIt.next();
				Iterator keyIt = mapKeys.iterator();

				while (keyIt.hasNext()) {
					Object key = keyIt.next();
					if (map.get(key) != null)
						comp1 = map.get(key).toString();
					String comp2 = val.toString();

					if (comp1.equals(comp2)) {
						map.remove(key);
						mapKeys.remove(key);
						sortedMap.put((String) key, (Integer) val);
						break;
					}

				}

			}
			System.out.println("Sorted Size:" + sortedMap.size());
			Iterator it = sortedMap.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();

				if (Integer.parseInt(pair.getValue().toString()) != 0 && pair.getKey() != "if" && pair.getKey() != "do"
						&& pair.getKey() != "type" && pair.getKey() != "for") {

					keywords.add(pair.getKey().toString());
				}

			}
			Collections.reverse(keywords);
			return keywords;
		}

	}

}
