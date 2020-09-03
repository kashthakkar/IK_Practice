// I/P -> [1, 2, 3]
// O/P -> [ [1] [2] [3] [1,3] [1,2] [2,3] [1,2,3] [] ]

package RecursionAlgorithms;

import java.util.Arrays;

public class SubSet {
	static int enter = 0;
	static int exit = 0;
	
	public static void main(String[] args) {
		int array[] = {1, 2, 3};
		subsetHelper("", array);
	}
	
	static void subsetHelper(String slate, int array[]) {
		if (array.length == 0) {
			System.out.println("[" + slate.replaceAll(",$", "") + "]");
		} else {
			//System.out.println("Enter " + enter++);
			// exclude
			subsetHelper(slate, Arrays.copyOfRange(array, 1, array.length));
			
			// include
			subsetHelper(slate + array[0] +",", Arrays.copyOfRange(array, 1, array.length));
			//System.out.println("Exit " + exit++);
		}
	}
}
