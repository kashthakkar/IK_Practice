// I/P -> [1,2,3]
// O/P -> [ [1,2,3] [1,3,2,] [2,1,3] [2,3,1] [3,1,2] [3,2,1] ]

package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class subSetPattern {
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		List<Integer> slate = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		helper(nums, 0, slate, result);
		
		System.out.println(result);
	}
	
	static void helper(int nums[], int index, List<Integer> slate, List<List<Integer>> result) {
		// Base case
		if(index == nums.length) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		
		// Recursive case
		for (int i = index; i < nums.length; i++) {
			swap(index, i, nums);
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
