package RecursionAlgorithms;

public class DecimalString {
	public static void main(String[] args) {
		dshelper("", 2);
	}
	
	static void dshelper(String slate, int n) {
		if (n==0) {
			System.out.println(slate);
		} else {
			for (int i = 0; i < 9; i++) {
				dshelper(slate + i, n - 1);
			}
		}
	}
}
