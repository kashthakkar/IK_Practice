package SortingAlgorithms;

public class MergeKSortedArraysTopAttempt {
	public static void main(String[] args) {
		int K = 4;
		int N = 6;
		
		int array2D[][] = new int[K][N];
		array2D[0] = new int[] {24, 23, 20, 15, 7, 4};
		array2D[1] = new int[] {26, 21, 19, 11, 11, 3};
		array2D[2] = new int[] {36, 34, 26, 24, 15, 8};
		array2D[3] = new int[] {21, 14, 10, 5, 4, 3};
		
		int finalArray[] = mergeArrays(array2D);
		
		for (int i = 0; i < finalArray.length; i++) {
			System.out.println(finalArray[i]);
		}
	}
	
	static int[] mergeArrays(int[][] arr) {
        boolean isAsc = isAsc(arr);
        return divide(arr,0,arr.length-1,isAsc);
    }
    

    static int[] divide(int[][] arr,int start,int end,boolean isAsc) {
        // return if single
        if(arr.length==1)
            return arr[0];
        
        if(start>=end)
            return arr[end];
        
        int mid = start+((end-start)/2);
        int[] lArray = divide(arr,start,mid,isAsc);
        int[] rArray = divide(arr,mid+1,end,isAsc);
                
        return merge(lArray,rArray,isAsc);
    }
    
    static int[] merge(int[] lArray,int[] rArray,boolean isAsc) {
            
        int lIndex=0;
        int rIndex=0;
        
        int[] merged = new int[lArray.length+rArray.length];
        
        int insertIndex=0;
        while(lIndex<lArray.length && rIndex<rArray.length) {
            
            boolean check = isAsc ? lArray[lIndex]<rArray[rIndex] : lArray[lIndex]>rArray[rIndex];
            
            if(check) {
                merged[insertIndex++] = lArray[lIndex++];
            }
            else {
                merged[insertIndex++] = rArray[rIndex++];
            }        
        }
        
        while(lIndex<lArray.length)
            merged[insertIndex++] = lArray[lIndex++];
        while(rIndex<rArray.length)
            merged[insertIndex++] = rArray[rIndex++];
        
        return merged;
        
    }
    
    static boolean isAsc(int[][] arr) {
        int rowCounter=0;
        
        while(rowCounter<arr.length) {
            int[] row = arr[rowCounter];
            int first=row[0];
            int last=row[row.length-1];
            
            if(first>last)
                return false;
            
            rowCounter++;
            
        }
        return true;
    }

}
