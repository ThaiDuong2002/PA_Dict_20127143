import Dictionary.SlangDictionary;
import GUI.MainInterface;

/**
 * Created by Thai Duong
 * Date 11/15/2022 - 9:57 AM
 * Description: ...
 */
public class Main {
	public static void main(String[] args) {
		SlangDictionary slangDictionary = new SlangDictionary();
		slangDictionary.getData();
		new MainInterface(slangDictionary);
	}
}