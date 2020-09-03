// Print all paths of a tree

package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathsOfTree {
	public static void main(String[] args) {
		Integer arr[] = { 10, 20, 30, 40, 50, 60 };
		BinaryTree tree = new BinaryTree();
		BinaryTree root = null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		root = tree.insert(arr, root, 0);

		tree.printBinaryTree(root);

		pathsOfTree(root, result, temp);

		for (List<Integer> l : result) {
			res.add(l);
		}

		System.out.println();
		System.out.println(res);
	}

	public static void pathsOfTree(BinaryTree root, List<List<Integer>> result, List<Integer> temp) {
		temp.add(root.key);

		if (root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		if (root.left != null) {
			pathsOfTree(root.left, result, temp);
			temp.remove(temp.size() - 1);
		}

		if (root.right != null) {
			pathsOfTree(root.right, result, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public static int countSize(BinaryTree root, int size) {
		if (root == null)
			return 0;

		return 1 + countSize(root.left, size) + countSize(root.right, size);
	}
}
