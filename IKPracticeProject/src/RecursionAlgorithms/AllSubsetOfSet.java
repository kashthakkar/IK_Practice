// IK Recursion practice. Problem set 1

//Input: "xy" 
// Output: ["", "x", "y", "xy"]

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetOfSet {
	public static void main(String[] args) {
		String input = "xy";
		List<String> result = new ArrayList<String>();
		
		helper(input, new StringBuilder(), 0, result);
		
		String res[] = new String[result.size()];
        
        int j = 0;
        for(String s : result) {
            res[j++] = s;
        }
		
		System.out.println(Arrays.toString(res));
	}
	
	static void helper(String input, StringBuilder slate, int index, List<String> result) {
		// Base case
		if (index == input.length()) {
			result.add("\"" + slate + "\"");
			return;
		}
		
		// Recursive case
		//Exclude
		helper(input, slate, index + 1, result);
		
		//Include
		slate.append(input.charAt(index));
		helper(input, slate, index + 1, result);
		slate.deleteCharAt(slate.length() - 1);
	}
}
