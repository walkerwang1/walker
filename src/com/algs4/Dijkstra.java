package com.algs4;

/**
 * Dijkstra：从一个顶点到其他各顶点的最短路径算法，解决的是有向图中最短路径。
 * 
 * @author walkerwang
 *
 */
public class Dijkstra {
	private boolean[] marked;
	
	private int[] edgeTo;
	
	private final int s;
	
	public Dijkstra(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		validateVertex(s);
	}
	
	void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V) {
			throw new IllegalArgumentException("Vertex" + v + " is not between 0 and" + (V - 1));
		}
	}
	public static void main(String[] args) {
		
	}
}
