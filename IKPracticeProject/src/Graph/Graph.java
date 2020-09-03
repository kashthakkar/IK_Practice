package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	public LinkedList<Integer>[] adjList;
	public int v;

	public Graph(int size) {
		v = size;
		adjList = new LinkedList[v];
	}

	public void buildAdjList(int n, List<List<Integer>> edges) {
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<>();
		}

		for (List<Integer> edge : edges) {
			addEdge(edge.get(0), edge.get(1), true);
		}
	}

	public void addEdge(int start, int end, boolean biDir) {
		adjList[start].add(end);
		if (biDir)
			adjList[end].add(start);
	}

	public void printGraph() {
		for (int i = 0; i < v; i++) {
			if (adjList[i].size() > 0) {
				System.out.print("Vertex " + i + " connected to: ");
			}
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j) + " ");
			}
			System.out.println();
		}
	}

	public boolean hasEulerianCycle() {
		int odd = 0;

//		for (Integer vertex : adjList) {
//			if ((adjList[vertex].size() % 2) == 1)
//				odd++;
//		}

		for (int i = 0; i < adjList.length; i++) {
			if ((adjList[i].size() % 2) == 1)
				odd++;
		}

		if (odd == 0)
			return true;
		else
			return false;
	}

	public boolean hasEulerianPath() {
		int odd = 0;

		for (int i = 0; i < adjList.length; i++) {
			if ((adjList[i].size() % 2) == 1)
				odd++;
		}

		if (odd == 0 || odd == 2)
			return true;
		else
			return false;
	}

//	public void search(int s) {
//		LinkedList<Integer>[] captured = new
//	}

	public void BFS(int s, int size) {
		Integer[] captured = new Integer[size];
		Integer[] visited = new Integer[size];
		Integer[] parent = new Integer[size];

		Queue<Integer> q = new LinkedList<>();
		q.add(s);

		while (!q.isEmpty()) {
			int v = q.remove();
			captured[v] = 1;

			System.out.print(v + " ");

			for (Integer w : adjList[v]) {
				if (visited[w] == null || visited[w] == 0) {
					visited[w] = 1;
					parent[w] = v;
					q.add(w);
				}
			}
		}
	}

	public void DFS(int s, int size) {
		Integer[] captured = new Integer[size];
		Integer[] visited = new Integer[size];
		Integer[] parent = new Integer[size];

		Stack<Integer> q = new Stack<Integer>();
		q.push(s);

		while (!q.isEmpty()) {
			int v = q.pop();
			captured[v] = 1;

			System.out.print(v + " ");

			for (int w : adjList[v]) {
				if (visited[w] == null || visited[w] == 0) {
					visited[w] = 1;
					parent[w] = v;
					q.add(w);
				}
			}
		}
	}

	public void recDFS(int s, Integer[] visited) {
		visited[s] = 1;

		System.out.print(s + " ");

		for (Integer w : adjList[s]) {
			if (visited[w] == null || visited[w] == 0) {
				recDFS(w, visited);
			}
		}
	}

	public int findComponents(int vertices, Integer[] visited) {
		int component = 0;

		for (int i = 0; i < vertices; i++) {
			if (visited[i] == null || visited[i] == 0) {
				component++;
				findComponentDFS(i, component, visited);
			}
		}

		return component;
	}

	public void findComponentDFS(int source, int c, Integer[] visited) {
		visited[source] = c;
		for (Integer w : adjList[source]) {
			if (visited[w] == null || visited[w] == 0) {
				findComponentDFS(w, c, visited);
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		Graph graph = new Graph(n);
		List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 4), Arrays.asList(1, 2),
				Arrays.asList(1, 3), Arrays.asList(1, 4), Arrays.asList(2, 3), Arrays.asList(3, 4));

		graph.buildAdjList(n, edges);

		graph.printGraph();

		System.out.println("Graph is" + (graph.hasEulerianCycle() ? " " : " not an ") + "Eulerian cycle");

		System.out.println("Graph is" + (graph.hasEulerianPath() ? " " : " not an ") + "Eulerian path");

		System.out.print("BFS of a graph: ");
		graph.BFS(0, n);

		System.out.print("\nDFS of a graph: ");
		graph.DFS(0, n);

		System.out.print("\nRecursion DFS of a graph: ");
		graph.recDFS(0, new Integer[n]);

		System.out.print("\nFinding connected component of a graph: " + graph.findComponents(n, new Integer[n]));
	}
}
