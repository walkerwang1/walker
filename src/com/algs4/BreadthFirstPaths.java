package com.algs4;

import java.util.Stack;

public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		validateVertex(s);
		bfs(G, s);
	}
	
	/**
	 * 广度优先搜索
	 * @param G
	 * @param s
	 */
	public void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<>();
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	public Stack<Integer> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v)) {
			return null;
		}
		Stack<Integer> path = new Stack<>();
		for (int x = v; x != s; x = edgeTo[s]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
	/**
	 * 判断顶点v是否有效
	 * @param v
	 */
	public void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V) {
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
		}
	}
	
	public static void main(String[] args) {
		
	}
}
