/*

Example One
	Input:
	s="222", target=24.
	
	Output:
	["22+2", "2+22"]

Example Two
	Input: s="1234", target=11.
	
	Output: ["1+2*3+4"]

Example Three
	Input:
	s="99", target=1.
	
	Output:
	[]
 
*/

// not done yet

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class EvaluateInputToTarget {
	public static void main(String[] args) {
		String input = "222";
		int target = 24;
		List<String> result = new ArrayList<String>();
		StringBuilder slate = new StringBuilder();
		
		evaluateToTarget(input, result, 0, slate, target);
		
		System.out.println(result);
	}
	
	static void evaluateToTarget(String input, List<String> result, int index, StringBuilder slate, int target) {
		
		// Base case
		if (index == input.length()) {
			result.add(slate.toString());
			return;
		}
		
		// Recursive case
		for (int i = 0; i < input.length(); i++) {
			slate.append(input.charAt(index));
			evaluateToTarget(input, result, index + 1, slate, target);
		}
		
	}
}
