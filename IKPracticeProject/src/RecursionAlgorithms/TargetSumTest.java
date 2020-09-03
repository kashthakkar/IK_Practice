package RecursionAlgorithms;

import java.util.Vector;

public class TargetSumTest {
	public static void main(String[] args) {	
		long input[] = {-100000000,-100000000,-800000000,-300000000,-1800000000,1100000000,600000000};
		long k = -900000000;
		
		Vector<Integer> arr = new Vector<Integer>();
		
		for(long i : input) {
            arr.add((int) i);
        }
		
		boolean check = false;
		
		check = isPossible(arr, k);
		
		//helper(arr, k, 0, 0, check);
		
		System.out.println(check);
	}
	
	static boolean isPossible(Vector<Integer> arr, long target) {
		return helper(arr, 0, target, 0, false);
	}
	
	static boolean helper(Vector<Integer> arr, int index, long k, long sum, boolean used_one) {
        // Base case
        if (sum == k && used_one) {
        	return true;
        }
        
        if (index == arr.size()) {
        	return false;
        }
        
        // Recursive case
        return (helper(arr, index + 1, k, sum + arr.get(index), true) ||
        helper(arr, index + 1, k, sum, used_one || false));
    }
}
