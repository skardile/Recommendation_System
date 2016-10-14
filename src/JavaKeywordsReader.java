
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.tartarus.snowball.ext.PorterStemmer;

public class JavaKeywordsReader {

	public HashMap<String, Integer> read(String path) {

		String fileName = path + "\\" + "JavaKeywords.txt";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PorterStemmer stem = new PorterStemmer();
		EnglishAnalyzer en_an = new EnglishAnalyzer();
		QueryParser parser = new QueryParser("your_field", en_an);

		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()) {
				String st = scanner.nextLine();
				stem.setCurrent(st);
				stem.stem();
				map.put(stem.getCurrent(), 0);
			}

			System.out.println("Original Map size:" + map.size());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}

}
