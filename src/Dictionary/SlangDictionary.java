package Dictionary;

import java.io.*;
import java.util.*;

/**
 * Dictionary
 * Created by Thai Duong
 * Date 11/15/2022 - 9:32 PM
 * Description: ...
 */
public class SlangDictionary {
	private static final Hashtable<String, List<String>> dictionary = new Hashtable<>();
	private static final List<String> historySearch = new ArrayList<>();
	
	public void getData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/Data/slang.txt"));
			String data;
			while ((data = br.readLine()) != null) {
				if (data.contains("`")) {
					String[] item = data.split("`");
					dictionary.put(item[0], Arrays.asList(item[1].split("\\|")));
				}
			}
			br.close();
			Enumeration<String> e = dictionary.keys();
			
			while (e.hasMoreElements()) {
				String element = e.nextElement();
				System.out.println(element + ": " + dictionary.get(element));
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
