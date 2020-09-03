// Post-order traversal without Recursion
// incorrect output. Not yet completed

package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostOrderTrav {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		BinaryTree tree = new BinaryTree();
		BinaryTree root = null;

		root = tree.insert(arr, root, 0);

		tree.printBinaryTree(root);

		List<Integer> result = new ArrayList<Integer>();
		postOrder(root, result);

		int res[] = new int[result.size()];

		int c = 0;
		for (int i : result) {
			res[c++] = i;
		}

		System.out.println();
		System.out.println(Arrays.toString(res));
	}

	static List<Integer> postOrder(BinaryTree root, List<Integer> result) {
		BinaryTree curr = null;
		BinaryTree moveRight = root;
		BinaryTree prev = moveRight;
		BinaryTree ancestor = null;

		while (true) {

			if (moveRight == curr && moveRight == prev) {
				moveRight = null;
			}

			if (curr == root.left) {
				moveRight = moveRight.right;
			}

			if (moveRight == null) {
				result.add(root.key);
				break;
			}

			prev = moveRight;

			if (ancestor == null) {
				while (prev.left != null && prev.left != curr) {
					prev = prev.left;
				}

				while (prev.right != null) {
					ancestor = prev;
					prev = prev.right;
				}
				curr = prev;
				result.add(curr.key);
			} else {
				result.add(ancestor.key);
				curr = ancestor;
				ancestor = null;
			}
		}
		return result;
	}
}
