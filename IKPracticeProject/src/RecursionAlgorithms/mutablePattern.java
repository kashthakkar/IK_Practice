// I/P -> a1b2
// O/ P -> [A1B2, A1b2, a1B2, a1b2]

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class mutablePattern {
	public static void main(String[] args) {
		String input = "a1b2";
		List<String> result = new ArrayList<String>();
		StringBuilder slate = new StringBuilder();
		
		helper(input, slate, 0, result);
		
		System.out.println(result);
	}
	
	static void helper(String input, StringBuilder slate, int index, List<String> result) {
		// Base case
		if (index == input.length()) {
			result.add(slate.toString());
			return;
		}
		
		// Recursion case
		if (Character.isDigit(input.charAt(index))) {
			slate.append(Character.toString(input.charAt(index)));
			helper(input, slate, index + 1, result);
			slate.deleteCharAt(slate.length() - 1);
		} else {
			slate.append(Character.toUpperCase(input.charAt(index)));
			helper(input, slate, index + 1, result);
			slate.deleteCharAt(slate.length() - 1);
			
			slate.append(Character.toLowerCase(input.charAt(index)));
			helper(input, slate, index + 1, result);
			slate.deleteCharAt(slate.length() - 1);
		}
	}
}
