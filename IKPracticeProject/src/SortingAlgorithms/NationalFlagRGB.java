// Input [B, R, G, B, R, B, B, G]
// Output [R, R, G, G, B, B, B, B]

package SortingAlgorithms;

import java.util.Arrays;

public class NationalFlagRGB {
	public static void main(String[] args) {
		String array[] = {"B", "R", "G", "B", "R", "B", "B", "G"};
		
		sort(array);
		
		System.out.println(Arrays.toString(array));
	}
	
	static void sort(String array[]) {
		int i = 0;
		int lptr = 0;
		int rptr = array.length - 1;
		
		while (i <= rptr) {
			if(array[i] == "R") {
				swap(array, i, lptr);
				lptr++;
				i++;
			} else if (array[i] == "B") {
				swap(array, i, rptr);
				rptr--;
			} else if(array[i] == "G") {
				i++;
			}
		}
	}
	
	static void swap(String array[], int aIndex, int bIndex) {
		String temp = array[aIndex];
		array[aIndex] = array[bIndex];
		array[bIndex] = temp;
	}
}
