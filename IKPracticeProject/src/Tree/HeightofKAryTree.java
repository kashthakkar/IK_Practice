package Tree;

public class HeightofKAryTree {

	static int maxHeight(nAryTreeNode node) {
		if (node.children.size() == 0) {
			return 0;
		}

		int max;
		int height = 0;

		for (nAryTreeNode child : node.children) {
			height = Math.max(height, maxHeight(child));
		}

		return height + 1;
	}
}
