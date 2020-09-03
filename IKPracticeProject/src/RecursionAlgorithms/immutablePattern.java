package RecursionAlgorithms;

// I/P -> a1b2
// O/ P -> [A1B2, A1b2, a1B2, a1b2]

import java.util.ArrayList;
import java.util.List;

public class immutablePattern {
	public static void main(String[] args) {
		String input = "a1b2";
		
		List<String> result = new ArrayList<String>();
		
		helper(input, "", 0, result);
		
		System.out.println(result);
	}
	
	static void helper(String input, String slate, int index, List<String> result) {
		// Base case
		if (index == input.length()) {
			result.add(slate);
			return;
		}
		
		// Recursion case
		if (Character.isDigit(input.charAt(index))) {
			helper(input, slate + Character.toString(input.charAt(index)), index + 1, result);
		} else {
			helper(input, slate + Character.toUpperCase(input.charAt(index)), index + 1, result);
			helper(input, slate + Character.toLowerCase(input.charAt(index)), index + 1, result);
		}
	}
}
