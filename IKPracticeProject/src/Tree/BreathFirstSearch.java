package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {
	public static void main(String[] args) {
		int sample[] = { 212, 580, 6, 7, 28, 84, 112, 434 };
		TreeNode tree = new TreeNode();
		TreeNode root = null;

		for (int i : sample) {
			root = tree.insert(root, i);
		}

		tree.dfs(root);
		System.out.println();

		BreathFirstSearch bfs = new BreathFirstSearch();
		bfs.levelOrder(root);
	}

	public void levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int numNodes = q.size();
			temp = new ArrayList<>();

			for (int i = 0; i < numNodes; i++) {
				TreeNode node = q.remove();
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
