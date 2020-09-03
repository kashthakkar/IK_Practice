// Post order traversal without Recursion

package Tree;

import java.util.Stack;

public class PostOrderTravTopAttempt {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTree tree = new BinaryTree();
		BinaryTree root = null;

		root = tree.insert(arr, root, 0);

		tree.printBinaryTree(root);

		postOrder(root);
	}

	static void postOrder(BinaryTree root) {
		if (root == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();

		Stack<BinaryTree> s = new Stack<>();
		s.push(root);
		while (!s.empty()) {
			BinaryTree node = s.peek();
			if (node.right != null) {
				s.push(node.right);
			}
			if (node.left != null) {
				s.push(node.left);
			}
			if (node.left == null && node.right == null) {
				node = s.pop();
				sb.append(node.key + " ");
			} else {
				node.left = null;
				node.right = null;
			}
		}

		System.out.println("\nPost-order ");
		System.out.println(sb.toString().trim());
	}
}
