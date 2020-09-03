package SortingAlgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class TopK {
	public static void main(String[] args) {
		int n = 11;
		// int arr[] = {1, 5, 4, 4, 2};
		int arr[] = {4, 8, 9, 6, 6, 2, 10, 2, 8, 1, 2};
		int k = 9;
		
		int topK[] = solve(arr, k);
		
		System.out.println(Arrays.toString(topK));
	}
	
	static int[] solve(int[] arr, int k) {
		sort(arr, k, 0, arr.length - 1);
		
		Set<Integer> setTopK = new HashSet<Integer>();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!setTopK.contains(arr[i])) {
				setTopK.add(arr[i]);
				if (setTopK.size() == k) break;
			}
		}
		
		int topK[] = new int[setTopK.size()];
		
		int j = 0;
		for(int i: setTopK) {
			topK[j++] = i;
		}
		
		return topK;
	}
	
	static void sort(int arr[], int k, int start, int end) {
		if (start < end) {
			int pivotIndex = quickSort(arr, start, end);
			
			sort(arr, k, start, pivotIndex - 1);
			sort(arr, k, pivotIndex + 1, end);
		}
	}
	
	static int quickSort(int arr[], int start, int end) {
		int pivotIndex = ThreadLocalRandom.current().nextInt(start, end);
		swap(arr, pivotIndex, start);
		int pivot = arr[start];
		int smaller = start;
		
		for(int bigger = start + 1; bigger <= end; bigger++) {
			if (arr[bigger] <= pivot) {
				smaller++;
				swap(arr, smaller, bigger);
			}
		}
		swap(arr, start, smaller);
		
		return smaller;
	}
	
	static void swap(int arr[], int aIndex, int bIndex) {
		int temp = arr[aIndex];
		arr[aIndex] = arr[bIndex];
		arr[bIndex] = temp;
	}
}
