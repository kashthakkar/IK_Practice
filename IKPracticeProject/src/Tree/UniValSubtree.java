package Tree;

public class UniValSubtree {
	public static int uniValTree = 0;

	public static void main(String[] args) {
		Integer arr[] = { 5, 5, 5, 5, 5, null, 5 };
		BinaryTree tree = new BinaryTree();
		BinaryTree root = null;

		root = tree.insert(arr, root, 0);

		tree.printBinaryTree(root);

		boolean uniVal = uniVal(root);

		System.out.println();
		System.out.println("Uni-val tree " + uniVal);
		System.out.println("Uni-val subtree count " + uniValTree);
	}

	static boolean uniVal(BinaryTree root) {
		// Base case
		if (root == null)
			return true;

		if (root.left == null && root.right == null) {
			uniValTree++;
			return true;
		}

		// Internal node
		boolean uniVal = true;

		if (root.left != null) {
			boolean l = uniVal(root.left);
			if (l == false || root.key != root.left.key) {
				uniVal = false;
			}
		}

		if (root.right != null) {
			boolean r = uniVal(root.right);
			if (r == false || root.key != root.right.key) {
				uniVal = false;
			}
		}

		if (uniVal)
			uniValTree++;

		return uniVal;
	}
}
