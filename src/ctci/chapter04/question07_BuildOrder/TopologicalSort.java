package ctci.chapter04.question07_BuildOrder;

import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSort {
	
	public static ArrayList<Integer> topSort(Graph G) {
		int size = G.size();
		/*
		 * if -1 = visited
		 * if 0 = not visited
		 * if 1 = processing
		 */
		int[] visited = new int[size];
		ArrayList<Integer> solution = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if (visited[i] == 0) {
				if (!DFS(G, i, visited, solution)) {
					return null;
				}
			}
		}
		return solution;
	}
	
	public static boolean DFS(Graph G, int vertex, int[] visited, ArrayList<Integer> solution) {
		if (visited[vertex] == 1) {
			return false;
		}
		LinkedList<Integer> adj = G.getAdj(vertex);
		visited[vertex] = 1;
		if (adj == null) {
			solution.add(vertex);
			return true;
		}
		for (int i : adj) {
			if (visited[i] != -1) {
				if (!DFS(G, i, visited, solution)) {
					return false;
				}
			}
		}
		visited[vertex] = -1;
		solution.add(vertex);
		return true;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph(6);
		G.addEdge(0, 3);
		G.addEdge(5, 1);
		G.addEdge(1, 3);
		G.addEdge(5, 0);
		G.addEdge(3, 2);
		ArrayList<Integer> solution = topSort(G);
		if (solution == null) {
			System.out.println("Error");
		} else {
			for (int i = 0; i < solution.size(); i++) {
				System.out.print(solution.get(i) + " ");
			}
			System.out.println();
		}
	}
}
