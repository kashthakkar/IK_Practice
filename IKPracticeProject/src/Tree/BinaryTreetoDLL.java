//Convert binary tree to doubly linked list

package Tree;

public class BinaryTreetoDLL {
	int val;
	BinaryTreetoDLL left;
	BinaryTreetoDLL right;
	BinaryTreetoDLL next;
	BinaryTreetoDLL pred;

	static BinaryTreetoDLL dummy = new BinaryTreetoDLL(0);
	static BinaryTreetoDLL prev = dummy;

	BinaryTreetoDLL(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.next = null;
		this.pred = null;
	}

	public static void main(String[] args) {
		int sample[] = { 4, 2, 5, 1, 3 };
		BinaryTreetoDLL tree = new BinaryTreetoDLL(0);
		BinaryTreetoDLL root = null;

		for (int v : sample) {
			root = tree.insert(root, v);
		}

		dfs(root);
		BinaryTreetoDLL head = dummy.next;
		prev.next = head;
		head.pred = prev;
	}

	static void dfs(BinaryTreetoDLL node) {
		if (node.left != null) {
			dfs(node.left);
		}
		prev.next = node;
		node.pred = prev;
		prev = node;
		if (node.right != null) {
			dfs(node.right);
		}
	}

	public BinaryTreetoDLL insert(BinaryTreetoDLL root, int key) {

		BinaryTreetoDLL newNode = new BinaryTreetoDLL(key);

		if (root == null) {
			return newNode;
		}

		BinaryTreetoDLL prev = null;
		BinaryTreetoDLL curr = root;

		while (curr != null) {
			if (key < curr.val) {
				prev = curr;
				curr = curr.left;
			} else {
				prev = curr;
				curr = curr.right;
			}
		}

		if (key < prev.val)
			prev.left = newNode;
		else
			prev.right = newNode;

		return root;
	}
}
