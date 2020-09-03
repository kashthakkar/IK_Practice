package SortingAlgorithms;

import java.util.Arrays;
import java.util.TreeSet;

public class TopKTopAttempt {
	public static void main(String[] args) {
		// int arr[] = {1, 5, 4, 4, 2};
		int arr[] = {4, 8, 9, 6, 6, 2, 10, 2, 8, 1, 2};
		int k = 4;
		
		int topK[] = topK(arr, k);
		
		System.out.println(Arrays.toString(topK));
	}
	
	static int[] topK(int[] arr, int k) {
		TreeSet<Integer> tree = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			tree.add(arr[i]);
			if(tree.size() > k) {
				tree.pollFirst();
			}
		}
		
		int[] result = new int[tree.size()];
		int ptr = 0;
		for(int i : tree) {
			result[ptr++] = i;
		}
		
		return result;
	}
}
