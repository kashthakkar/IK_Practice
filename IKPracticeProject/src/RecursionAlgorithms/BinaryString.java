package RecursionAlgorithms;

public class BinaryString {
	public static void main(String[] args) {
		binaryStrings("", 2);
	}
	
	public static void binaryStrings(String slate, int n) {
		if(n==0) {
			System.out.println(slate);
		} else {
			binaryStrings(slate + "0", n - 1);
			binaryStrings(slate + "1", n - 1);
		}
	}
}
