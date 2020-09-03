package Tree;

import java.util.ArrayList;
import java.util.List;

public class nArrayTree {
	public int key;
	List<nArrayTree> children;

	static int k = 3; // kth size children

	public nArrayTree() {
		children = new ArrayList<nArrayTree>();
	}

	public nArrayTree(int key) {
		this.key = key;
		children = new ArrayList<nArrayTree>();
	}

	public nArrayTree insert(nArrayTree root, int key) {
		nArrayTree newNode = new nArrayTree(key);

		if (root == null)
			return newNode;

		nArrayTree prev = null;
		nArrayTree curr = root;

		while (curr != null) {

		}

		return root;
	}

}
