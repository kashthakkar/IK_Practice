// I/P -> {1, 2, 2}
// O/P -> [ []2 [1] [1,2,2] [2,2] [1,2] [] ]
// Not solved yet

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class subSetPattern2 {
	public static void main(String[] args) {
		int nums[] = {1,2,2};
		List<Integer> slate = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		helper(nums, 0, slate, result);
		
		System.out.println(result);
	}
	
	static void helper(int nums[], int index, List<Integer> slate, List<List<Integer>> result) {
		// Base case
		if (index == nums.length) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		
		// Recursion case
		
		// count of the current number
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[index] == nums[i]) {
				count++;
			}
		}
		
		// Include case
		for (int i = 0; i < count; i++) {
			slate.add(nums[i]);
			helper(nums, index + count, slate, result);
		}
		
		// Clean up slate
		for (int i = 0; i < count; i++) {
			slate.remove(slate.size() - 1);
		}
		
		// Exclude case
		helper(nums, index + count, slate, result);
	}
}
