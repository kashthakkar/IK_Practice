package RecursionAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class queenPlacement {
	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = 4;
		
		helper(n, new ArrayList<Integer>(), result, 0);
		
		System.out.println(result);
		System.out.println();
		
		// String res[][] = print(result, n);
		
		printQPosition(result, n);
	}
	
	static void helper(int n, List<Integer> slate, List<List<Integer>> result, int row) {
		// Base case
		if (row == n) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}
		
		// Recursive case
		for (int cl = 0; cl < n; cl++) {
			if(noAttacking(slate, cl)) {
				slate.add(cl);
				helper(n, slate, result, row + 1);
				slate.remove(slate.size() - 1);
			}
		}
	}
	
	static boolean noAttacking(List<Integer> slate, int col) {
		for (int i = 0; i < slate.size(); i++) {
			if (slate.get(i) == col) {
				return false;
			}
			
			int rowDiff = Math.abs(slate.size() - i);
			int colDiff = Math.abs(slate.get(i) - col);
			
			if (rowDiff == colDiff) {
				return false;
			}
		}
		return true;
	}
	
	static void printQPosition(List<List<Integer>> result, int n) {
		for (int k = 0; k < result.size(); k++) {
			System.out.println("-----------");
			System.out.println("Solution " + (k + 1));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(result.get(k).get(i) == j) {
						System.out.print(" Q ");
					} else {
						System.out.print(" _ ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	static String[][] print(List<List<Integer>> result, int n) {
		String res[][] = new String[result.size()][n];
        
        for(int k = 0; k < result.size(); k++) {
            for(int i = 0; i < n; i++) {
            	String str = "";
                for(int j = 0; j < n; j++) {
                    if(result.get(k).get(i) == j) {
                        //res[i][j] = "q";
                    	str += "q";
                    } else {
                        //res[i][j] = "-";
                    	str += "-";
                    }
                }
                res[k][i] = str;
            }
        }
        return res;
	}
}
