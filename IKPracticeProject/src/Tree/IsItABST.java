package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsItABST {
	public Integer key;
	public IsItABST left;
	public IsItABST right;

	public IsItABST() {
		this.left = null;
		this.right = null;
	}

	public IsItABST(Integer key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public IsItABST helper(Integer arr[], int start, int end) {

		// Base case
		if (start > end)
			return null;

		// Find root element
		int mid = (start + end) / 2;

		IsItABST root = new IsItABST(arr[mid]);

		root.left = helper(arr, start, mid - 1);
		root.right = helper(arr, mid + 1, end);

		return root;
	}

	public void printBFS(IsItABST root) {
		List<Integer> arr = new ArrayList<Integer>();

		Queue<IsItABST> q = new LinkedList<IsItABST>();
		q.add(root);
		while (!q.isEmpty()) {
			int numnodes = q.size();

			for (int i = 0; i < numnodes; i++) {
				IsItABST node = q.remove();
				arr.add(node.key);

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}

		System.out.println(arr);
	}

	public boolean IsItBST(IsItABST root, int max, int min) {

		boolean left = true;
		boolean right = true;

		if (root.left != null) {
			left = IsItBST(root.left, root.key, min);
		}

		if (root.right != null) {
			right = IsItBST(root.right, max, root.key);
		}

		if (left && right && (root.key <= max && root.key >= min))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Integer arr[] = { -10, -3, 0, 5, 9 };
		IsItABST tree = new IsItABST();
		IsItABST root = tree.helper(arr, 0, arr.length - 1);

		tree.printBFS(root);

		boolean isBST = tree.IsItBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);

		if (isBST)
			System.out.println("Tree is BST");
		else
			System.out.println("Tree is not BST");

	}
}
