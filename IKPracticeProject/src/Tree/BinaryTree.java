package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	public Integer key;
	public BinaryTree left;
	public BinaryTree right;

	public BinaryTree() {
		this.left = null;
		this.right = null;
	}

	public BinaryTree(Integer key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public BinaryTree insert(Integer arr[], BinaryTree root, int i) {
		if (i < arr.length) {

			if (arr[i] != null) {
				BinaryTree temp = new BinaryTree(arr[i]);
				root = temp;

				// insert left child
				root.left = insert(arr, root.left, 2 * i + 1);

				// insert right child
				root.right = insert(arr, root.right, 2 * i + 2);
			}
		}
		return root;
	}

	public void printBinaryTree(BinaryTree root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}

	public void printBreathFirstSearch(BinaryTree root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();

		Queue<BinaryTree> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int numNodes = q.size();
			temp = new ArrayList<>();

			for (int i = 0; i < numNodes; i++) {
				BinaryTree node = q.remove();
				temp.add(node.key);

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			result.add(temp);
		}
		for (List<Integer> t : result) {
			System.out.println(t);
		}
	}
}
