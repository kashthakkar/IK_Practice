// arr1 = [1, 3, 5]
// arr2 = [2, 4, 6, 0, 0, 0]

package SortingAlgorithms;

import java.util.Arrays;

public class Merge2ArrayInPlace {
	public static void main(String[] args) {
		int arr1[] = {1, 3, 5};
		int arr2[] = {2, 4, 6, 0, 0, 0};
		
		merge(arr1, arr2);
		
		System.out.println(Arrays.toString(arr2));
	}
	
	static void merge(int arr1[], int arr2[]) {
		int i = arr1.length - 1;
		int j = arr1.length - 1;
		int k = arr2.length - 1;
		
		while (i >= 0 && j >= 0) {
			if (arr1[i] > arr2[j]) {
				arr2[k] = arr1[i];
				k--;
				i--;
			} else {
				arr2[k] = arr2[j];
				k--;
				j--;
			}
		}
		
		while (i >= 0) {
			arr2[k] = arr1[i];
			k--;
			i--;
		}
		
		while (j >= 0) {
			arr2[k] = arr2[j];
			k--;
			j--;
		}
	}
}
