// n-ary Tree Node

package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class nAryTreeNode {
	int val;
	Vector<nAryTreeNode> children = new Vector<nAryTreeNode>();

	public nAryTreeNode() {
		children.clear();
	}

	public nAryTreeNode build_tree(int from[], int to[]) {
		HashMap<Integer, nAryTreeNode> address = new HashMap<Integer, nAryTreeNode>();

		int N = from.length + 1;
		address.clear();
		for (int i = 1; i <= N; i++) {
			address.put(i, new nAryTreeNode());
		}
		for (int i = 0; i < N - 1; i++) {
			System.out.println("from " + from[i]);
			System.out.println("to " + to[i]);
			address.get(from[i]).children.add(address.get(to[i]));
		}
		return address.get(1);
	}

	public void printBFS(nAryTreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();

		Queue<nAryTreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int numNodes = q.size();
			temp = new ArrayList<>();

			System.out.println("numNodes " + numNodes);

			for (int i = 0; i < numNodes; i++) {
				nAryTreeNode node = q.remove();
				temp.add(node.val);

				System.out.println("node childrens " + node.children.size());

				for (int j = 0; j < node.children.size(); j++) {
					q.add(node);
				}

//				if (node.left != null)
//					q.add(node.left);
//				if (node.right != null)
//					q.add(node.right);
			}
			result.add(temp);
		}
		for (List<Integer> t : result) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		int from[] = { 1, 1, 1, 5 };
		int to[] = { 3, 2, 5, 4 };

		nAryTreeNode nTree = new nAryTreeNode();
		nAryTreeNode root = null;

		root = nTree.build_tree(from, to);

		nTree.printBFS(root);
	}
}
