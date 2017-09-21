package ctci.chapter04.question01_RouteBetweenNodes;

import java.util.LinkedList;

public class Graph {
	private int V;
	private int E;
	private LinkedList<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int node1, int node2) {
		adj[node1].push(node2);
		E++;
	}
	
	public LinkedList<Integer> getAdj(int v) {
		return adj[v];
	}
	
	public int getVertices() {
		return V;
	}
}
