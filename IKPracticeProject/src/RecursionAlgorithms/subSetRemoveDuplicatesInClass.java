// I/P -> [1,1,2]
// O/P -> [ [1,1,2] [1,2,1] [2,1,1] ]

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subSetRemoveDuplicatesInClass {
	public static void main(String[] args) {
		int nums[] = {1,1,2};
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		List<Integer> slate = new ArrayList<Integer>();
		
		helper(nums, 0, slate, result);
		
		System.out.println(result);
	}
	
	static void helper(int nums[], int index, List<Integer> slate, Set<List<Integer>> result) {
		// Base case
		if (index == nums.length) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		
		// Recursion case
		
		for (int i = index; i < nums.length; i++) {
			swap(index, i , nums);
			slate.add(nums[index]);
			helper(nums, index + 1, slate, result);
			slate.remove(slate.size() - 1);
			swap(i, index, nums);
		}
	}
	
	static void swap(int aIndex, int bIndex, int nums[]) {
		int temp = nums[aIndex];
		nums[aIndex] = nums[bIndex];
		nums[bIndex] = temp;
	}
}
