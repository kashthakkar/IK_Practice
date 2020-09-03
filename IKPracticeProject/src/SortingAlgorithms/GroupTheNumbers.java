package SortingAlgorithms;

import java.util.Arrays;

public class GroupTheNumbers {
	public static void main(String[] args) {
		int arr[] = {1, 6, 2, 4, 7, 8, 10, 11, 13, 12};
		// int arr[] = {4, 7, 8};
		//int arr[] = {90}; 
		
		group(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void group(int arr[]) {
		if (arr.length <= 1) return;
		
		int lptr = 0;
		int i = arr.length - 1;
		
		while (i >= lptr) {
			if(arr[i] % 2 == 0) {
				swap(arr, lptr, i);
				lptr++;
			} else {
				i--;
			}
			
			if(lptr < arr.length && arr[lptr] % 2 == 0) {
				lptr++;
			}
		}
	}
	
	static void swap(int arr[], int aIndex, int bIndex) {
		int temp = arr[aIndex];
		arr[aIndex] = arr[bIndex];
		arr[bIndex] = temp;
	}
}
