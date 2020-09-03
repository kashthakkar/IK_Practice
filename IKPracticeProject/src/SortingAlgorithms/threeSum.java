package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class threeSum {
	public static void main(String[] args) {
		// int arr[] = {10, 3, -4, 1, -6, 9};
		// int arr[] = {12, 34, -46};
		// int arr[] = {-2, 2, 0, -2, 2};
		// int arr[] = {0, 0, 0};
		// int arr[] = {-2, 2, 0, -1, 1};
		int arr[] = {4, -2, -2, -1, -3};
		
		arr = eleminateDuplicates(arr);
		
		String result[] = threeSum(arr);
		
		System.out.println(Arrays.toString(result));
	}
	
	static String[] threeSum(int arr[]) {
		String res;
		Set<String> setResult = new HashSet<String>();
		
		
		int i = 0;
		int j = 0;
		int k = arr.length - 1;
		
		for (i = 0; i < arr.length; i++) {
			j = i + 1;
			while (j < k) {
				//System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
				if (arr[i] + arr[j] + arr[k] == 0) {
					res = arr[i] + "," + arr[j] + "," + arr[k];
					setResult.add(res);
					k--;
				} else {
					k--;
				}
				
				if (j >= k) {
					j++;
					k = arr.length - 1;
				}
			}
		}
		
		String arrResult[] = new String[setResult.size()];
		
		int c = 0;
		for(String s : setResult) {
			arrResult[c++] = s;
		}
		
		return arrResult;
	}
	
	static int[] eleminateDuplicates(int arr[]) {
		List<Integer> setArr = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if(!setArr.contains(arr[i])) {
				setArr.add(arr[i]);
			} else if (arr[i] == 0) {
				setArr.add(arr[i]);
			}
		}
		
		int newArr[] = new int[setArr.size()];
		
		int j = 0;
		
		for(Integer i : setArr) {
			newArr[j++] = i;
		}
		
		return newArr;
	}
}
