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
	Scanner input;
	
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
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	public List<String> findBySlangWord(String word) {
		historySearch.add(word);
		word = word.toUpperCase();
		return dictionary.get(word);
	}
	
	public List<String> findByDefinition(String word) {
		historySearch.add(word);
		List<String> slangList = new ArrayList<>();
		for (String s : dictionary.keySet()) {
			if (dictionary.get(s).contains(word)) {
				slangList.add(s);
			}
		}
		return slangList;
	}
	
	public List<String> getHistorySearch() {
		return historySearch;
	}
	
	public boolean addSlangWord(String slang, List<String> definitions) {
		if (dictionary.containsKey(slang)) {
			System.out.println("Do you want to overwrite (Y/N): ");
			String confirm = input.nextLine();
			if (confirm.equals("Y") || confirm.equals("y")) {
				dictionary.put(slang, definitions);
				return true;
			} else {
				List<String> temp = dictionary.get(slang);
				temp.addAll(definitions);
				dictionary.put(slang, temp);
				return true;
			}
		} else {
			dictionary.put(slang, definitions);
			return true;
		}
	}
}
