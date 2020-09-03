package SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		
		//Scanner input = new Scanner(System.in);
		
		//System.out.println("Enter K array length");
		int K = 2; // input.nextInt();
		
		//System.out.println("Enter N array number");
		int N = 3; //input.nextInt();
		
		int array2D[][] = new int[K][N];
		
//		array2D[0] = new int[] {24, 23, 20, 15, 7, 4};
//		array2D[1] = new int[] {26, 21, 19, 11, 11, 3};
//		array2D[2] = new int[] {17, 13, 13, 12, 12, 7};
//		array2D[3] = new int[] {27, 23, 22, 19, 13, 7};
//		array2D[4] = new int[] {26, 26, 25, 18, 9, 3};
//		array2D[5] = new int[] {18, 17, 17, 16, 15, 8};
//		array2D[6] = new int[] {36, 34, 26, 24, 15, 8};
//		array2D[7] = new int[] {21, 14, 10, 5, 4, 3};
		
		array2D[0] = new int[] {116, 120, 215};
		array2D[1] = new int[] {117, 119, 128};
		
//		array2D[0] = new int[] {8, 8, 8, 8, 8};
//		array2D[1] = new int[] {8, 8, 8, 8, 8};
//		array2D[2] = new int[] {8, 8, 8, 8, 9};
//		array2D[3] = new int[] {8, 8, 8, 8, 8};
//		array2D[4] = new int[] {8, 8, 8, 8, 8};
		
//		array2D[0] = new int[] {9, 9, 9, 9};
//		array2D[1] = new int[] {9, 9, 9, 9};
//		array2D[2] = new int[] {9, 9, 9, 9};
//		array2D[3] = new int[] {9, 9, 9, 10};
//		array2D[4] = new int[] {9, 9, 9, 9};
//		array2D[5] = new int[] {9, 9, 9, 9};
		
		boolean isAsc = isAsc(array2D);
		int finalArray[] = mergeNArrays(array2D, isAsc);
		
		for (int i = 0; i < finalArray.length; i++) {
			System.out.println(finalArray[i]);
		}
	}
	
	static int[] mergeNArrays(int[][] array2D, boolean isAsc) {
		int len = 0;
		
		int finalArray[] = new int[array2D.length * array2D[0].length];
		
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				int element = array2D[i][j];
				insertionSort(finalArray, element, len++, isAsc);
			}
		}
		
		return finalArray;
	}
	
	static void insertionSort(int finalArray[], int element, int len, boolean isAsc) {
		int j = len - 1;
		
		if (isAsc) {
			while (j >= 0 && finalArray[j] > element) {
				finalArray[j+1] = finalArray[j];
				j = j - 1;
			}
			finalArray[j+1] = element;
		} else {
			while (j >= 0 && finalArray[j] < element) {
				finalArray[j+1] = finalArray[j];
				j = j - 1;
			}
			finalArray[j+1] = element;
		}
	}
	
	static boolean isAsc(int array2D[][]) {
		boolean isAsc = false;
		
		int index = 0;
		
		for (int i = 0; i < array2D.length - 1; i++) {
			for (int j = 0; j < array2D[i].length - 1; j++) {
				if (array2D[i][j] < array2D[i][j+1]) {
					index = -1;
				} else if (array2D[i][j] > array2D[i][j+1]) {
					index = 1;
				}
			}
		}
		
		isAsc = (index > 0) ? false : true;
		
		return isAsc;
	}
}
