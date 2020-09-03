package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class WellFormedBrackets {
	public static void main(String[] args) {
		int n = 3;
		List<String> result = new ArrayList<String>();
		StringBuilder slate = new StringBuilder();
		
		helper(n, 0, 0, slate, result);
		
		System.out.println(result);
	}
	
	static void helper(int n , int opened, int closed, StringBuilder slate, List<String> result) {
		if (closed == n) {
			result.add(slate.toString());
			return;
		}
		
		if (opened < n) {
			slate.append('(');
			helper(n, opened + 1, closed, slate, result);
			slate.deleteCharAt(slate.length() - 1);
		}
		
		if (closed < opened) {
			slate.append(')');
			helper(n, opened, closed + 1, slate, result);
			slate.deleteCharAt(slate.length() - 1);
		}
	}
}
