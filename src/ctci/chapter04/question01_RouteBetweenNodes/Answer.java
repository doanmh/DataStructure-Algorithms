package ctci.chapter04.question01_RouteBetweenNodes;

import java.util.LinkedList;
import java.util.Queue;

public class Answer {
	public static boolean findPath(Graph G, int node1, int node2) {
		int vertices = G.getVertices();
		int[] visited = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			visited[i] = 0;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node1);
		while (!q.isEmpty()) {
			int currentNode = q.poll();
			visited[currentNode] = 1;
			for (int i = 0; i < G.getAdj(currentNode).size(); i++) {
				LinkedList<Integer> adj = G.getAdj(currentNode);
				if (visited[adj.get(i)] == 0) {
					if (adj.get(i) == node2) {
						return true;
					} else {
						visited[adj.get(i)] = 1;
						q.add(adj.get(i));
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(findPath(g, 4, 1));
	}
}
