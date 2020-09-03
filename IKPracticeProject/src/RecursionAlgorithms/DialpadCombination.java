// Input -> "23"
// Output -> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

// Dialpad
// 2 -> abc
// 3 -> def

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class DialpadCombination {
	public static void main(String[] args) {
		String input = "29";
		
		List<String> dialpadString = createDialpadString(input);
		
		System.out.println(dialpadString);
		
		StringBuilder slate = new StringBuilder();
		List<String> result = new ArrayList<String>();
		
		helper(dialpadString, slate, 0, result);
		
		System.out.println(result);
	}
	
	static void helper(List<String> dialpadString, StringBuilder slate, int index, List<String> result) {
		// Base case
		if (index == dialpadString.size()) {
			result.add(slate.toString());
			return;
		}
		
		// Recursive case
		String str = dialpadString.get(index);
		for (int i = 0; i < str.length(); i++) {
			slate.append(dialpadString.get(index).charAt(i));
			helper(dialpadString, slate, index + 1, result);
			slate.deleteCharAt(slate.length() - 1);
		}
	}
	
	static List<String> createDialpadString(String input) {
		List<String> dialpad = new ArrayList<String>();
		
		for (int i = 0; i < input.length(); i++) {
			switch (Character.getNumericValue(input.charAt(i))) {
				case 2: dialpad.add("abc"); break;
				case 3: dialpad.add("def"); break;
				case 4: dialpad.add("ghi"); break;
				case 5: dialpad.add("jkl"); break;
				case 6: dialpad.add("mno"); break;
				case 7: dialpad.add("pqrs"); break;
				case 8: dialpad.add("tuv"); break;
				case 9: dialpad.add("wxyz"); break;
			}
		}
		
		return dialpad;
	}
}
