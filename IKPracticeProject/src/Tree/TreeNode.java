package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public TreeNode() {

	}

	public TreeNode search(TreeNode root, int key) {
		TreeNode curr = root;

		while (curr != null) {
			if (key == curr.key)
				return curr;
			else if (key < curr.key)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return null;
	}

	public TreeNode insert(TreeNode root, int key) {

		TreeNode newNode = new TreeNode(key);

		if (root == null) {
			return newNode;
		}

		TreeNode prev = null;
		TreeNode curr = root;

		while (curr != null) {
//			if (key == curr.key) {
//				prev = curr;
//				curr = curr.left;
//			} else 
			if (key < curr.key) {
				prev = curr;
				curr = curr.left;
			} else {
				prev = curr;
				curr = curr.right;
			}
		}

//		if (curr != null && curr.key == key)
//			System.out.println("Key already exist " + curr.key);
//		else {
		if (key < prev.key)
			prev.left = newNode;
		else
			prev.right = newNode;
		// }

		return root;
	}

	public Integer findMin(TreeNode root) {
		if (root == null)
			return null;

		TreeNode curr = root;
		while (curr.left != null)
			curr = curr.left;

		return curr.key;
	}

	public Integer findMax(TreeNode root) {
		if (root == null)
			return null;

		TreeNode curr = root;
		while (curr.right != null)
			curr = curr.right;

		return curr.key;
	}

	public TreeNode successor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		TreeNode curr = p.right;

		if (p.right != null) {
			while (curr.left != null)
				curr = curr.left;

			return curr;
		}

		// Search for p starting from root

		TreeNode ancestor = null;
		curr = root;

		while (curr.key != p.key) {
			if (p.key < curr.key) {
				ancestor = curr;
				curr = curr.left;
			} else
				curr = curr.right;
		}

		return ancestor;
	}

	public TreeNode delete(TreeNode root, int key) {
		TreeNode curr = root;
		TreeNode prev = null;

		while (curr != null) {
			if (key == curr.key)
				break;
			else if (key < curr.key) {
				prev = curr;
				curr = curr.left;
			} else {
				prev = curr;
				curr = curr.right;
			}
		}

		// Case 1: curr not is a leaf
		if (curr == null)
			return root;

		if (curr.left == null && curr.right == null) {
			if (prev == null) // one node tree
				return null;

			if (curr == prev.left)
				prev.left = null;
			else
				prev.right = null;
		}

		// Case 2: curr not has 1 child
		TreeNode child = null;

		if (curr.left == null && curr.right != null)
			child = curr.right;

		if (curr.left != null && curr.right == null)
			child = curr.left;

		if (child != null) {
			if (prev == null) {
				root = child;
			}

			if (curr == prev.left)
				prev.left = child;
			else
				prev.right = child;
		}

		// Case 3: curr node has 2 children
		if (curr.left != null && curr.right != null) {
			TreeNode succ = curr.right;
			prev = curr;

			while (succ.left != null) {
				prev = succ;
				succ = succ.left;
			}

			curr.key = succ.key;

			if (succ == prev.left)
				prev.left = succ.right;
			else
				prev.right = succ.right;
		}

		return root;
	}

	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		TreeNode curr = p.left;

		if (p.left != null) {
			while (curr.right != null)
				curr = curr.right;

			return curr;
		}

		// Searching for p starting from root

		TreeNode ancestor = null;
		curr = root;

		while (curr.key != p.key) {
			if (p.key > curr.key) {
				ancestor = curr;
				curr = curr.right;
			} else
				curr = curr.left;
		}

		return ancestor;
	}

	public void dfs(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.key + " "); // Pre-order traversal
		dfs(root.left);
		// System.out.print(root.key + " "); // In-order traversal
		dfs(root.right);
		// System.out.print(root.key + " "); // Post-order traversal
	}

	public List<Integer> postOrderIterative(TreeNode root, List<Integer> result) {
		TreeNode curr = null;
		TreeNode moveRight = root;
		TreeNode prev = moveRight;

		while (true) {

			if (curr == root.left || curr == root.right) {
				moveRight = moveRight.right;
			}

			if (moveRight == null) {
				result.add(root.key);
				break;
			}

			prev = moveRight;

			while (prev.left != null && prev.left != curr) {
				prev = prev.left;
			}

			while (prev.right != null && prev.right != curr) {
				prev = prev.right;
			}
			curr = prev;
			result.add(curr.key);
		}
		return result;
	}

	public static void main(String[] args) {
		int sample[] = { 212, 580, 6, 212, 7, 28, 84, 112, 434 };
		TreeNode tree = new TreeNode();
		TreeNode root = null;

		for (int i : sample) {
			root = tree.insert(root, i);
		}

		tree.dfs(root);
		System.out.println();

		TreeNode curr = null;
		curr = tree.search(root, 28);
		if (curr != null)
			System.out.println("Node found " + curr.key);
		else
			System.out.println("Key not found");

		System.out.println("Max tree element " + tree.findMax(root));
		System.out.println("Min tree element " + tree.findMin(root));

		tree.delete(root, 84);
		tree.dfs(root);

		root = tree.insert(root, 26);
		System.out.println();
		tree.dfs(root);

		tree.delete(root, 28);
		System.out.println();
		tree.dfs(root);

		tree.delete(root, 26);
		System.out.println();
		tree.dfs(root);

		// Post-order without Recursion
		List<Integer> result = new ArrayList<Integer>();
		tree.postOrderIterative(root, result);

		int res[] = new int[result.size()];

		int c = 0;
		for (int i : result) {
			res[c++] = i;
		}

		System.out.println();
		System.out.println(Arrays.toString(res));
	}
}
