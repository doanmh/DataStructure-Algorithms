package ctci.chapter04.question07_BuildOrder;

import java.util.LinkedList;

public class Graph {
	private LinkedList<Integer>[] adj;
	private int V;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
	}
	
	public int size() {
		return V;
	}
	
	public void addEdge(int src, int dst) {
		if (adj[src] == null) {
			adj[src] = new LinkedList<Integer>();
		}
		adj[src].add(dst);
	}
	
	public LinkedList<Integer> getAdj(int vertex) {
		return adj[vertex];
	}
}
