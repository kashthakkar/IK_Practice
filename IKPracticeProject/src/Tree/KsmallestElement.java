// kth smallest element in a tree

package Tree;

public class KsmallestElement {
	static int counter = 0;
	static int ans;

	public static void main(String[] args) {
		Integer arr[] = { 10, 12, 3, 4, 15, 8 };
		TreeNode tree = new TreeNode();
		TreeNode root = null;
		int k = 5;

		// root = tree.insert(arr, root, 0);

		for (Integer i : arr) {
			root = tree.insert(root, i);
		}

		kSmallest(root, k);

		System.out.println(ans);
	}

	static void kSmallest(TreeNode root, int k) {
		if (root == null) {
			return;
		}

		kSmallest(root.left, k);
		counter++;
		if (counter == k) {
			ans = root.key;
			return;
		}
		kSmallest(root.right, k);
	}
}
