package com.algs4;

import java.io.File;

/**
 * 深度优先搜索：
 * 1-判断两个顶点是否可达；
 * 2-判断图是否是连通图；（是否存在连通子图）
 * 
 * @author walkerwang
 *
 *  % java Graph tinyG.txt
 *  13 vertices, 13 edges 
 *  0: 6 2 1 5 
 *  1: 0 
 *  2: 0 
 *  3: 5 4 
 *  4: 5 6 3 
 *  5: 3 4 0 
 *  6: 0 4 
 *  7: 8 
 *  8: 7 
 *  9: 11 10 12 
 *  10: 9 
 *  11: 9 12 
 *  12: 11 9 
 */
public class DepthFirstSearch {

	private boolean[] marked;
	
	private int count;
	
	public DepthFirstSearch(Graph G, int s) {	//找到和s连通的所有顶点
		marked = new boolean[G.V()];
		validateVertex(s);
		dfs(G, s);	
	}
	
	/**
	 * 从顶点v开始图G进行深度优先搜索
	 * @param G
	 * @param v
	 */
	public void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	/**
	 * 判断顶点v是否被标记，即v和源顶点s是否存在一条路径
	 * @param v
	 * @return
	 */
	public boolean marked(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	/**
	 * 和源顶点s连通的顶点数
	 * @return
	 */
	public int count() {
		return count;
	}
	
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V) {
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
		}
	}
	
	public static void main(String[] args) {
		In in = new In(new File("tinyG.txt"));
		Graph G = new Graph(in);
		int s = 0;
		DepthFirstSearch search = new DepthFirstSearch(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v) && v != s) {
				StdOut.print(v + " ");
			}
		}
		StdOut.println();
		if (search.count != G.V()) {
			StdOut.println("NOT all connected");
		} else {
			StdOut.println("connection");
		}
	}
}
