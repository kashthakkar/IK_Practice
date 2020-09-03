// I/P -> [1, 2, 3]
// O/P -> [ [1] [2] [3] [1,3] [1,2] [2,3] [1,2,3] [] ]

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class subSetInClass {
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> slate = new ArrayList<Integer>();
		
		helper(nums, slate, 0, result);
		
		System.out.println(result);
	}
	
	static void helper(int nums[], List<Integer> slate, int index, List<List<Integer>> result) {
		// Base case
		if(index == nums.length) {
			//result.add(Arrays.copyOf(slate, slate.size()));
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		
		// Recursion case
		
		// Exclude
		helper(nums, slate, index + 1, result);
		
		// Include
		slate.add(nums[index]);
		helper(nums, slate, index + 1, result);
		slate.remove(slate.size() - 1);
	}
}
