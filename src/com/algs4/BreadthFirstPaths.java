package com.algs4;

import java.io.File;
import java.util.Stack;

/**
 * 
 * @author walkerwang
 *
 * result:
 *  1 to 0:1-0
	1 to 1:1
	1 to 2:1-0-2
	1 to 3:1-0-5-3
	1 to 4:1-0-6-4
	1 to 5:1-0-5
	1 to 6:1-0-6
	1 to 7: not connected
	1 to 8: not connected
	1 to 9: not connected
	1 to 10: not connected
	1 to 11: not connected
	1 to 12: not connected
 */
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
	
	//判断源顶点和v是否可达
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	//到顶点v的路径
	public Stack<Integer> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v)) {
			return null;
		}
		Stack<Integer> path = new Stack<>();
		for (int x = v; x != s; x = edgeTo[x]) {
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
		In in = new In(new File("tinyG.txt"));
		Graph G = new Graph(in);
		int s = 1;
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		for(int v = 0; v < G.V(); v++) {
			if (bfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:", s, v);
				Stack<Integer> stack = bfs.pathTo(v);
				while(stack.size() != 0) {
					int x = stack.pop();
					if (x == s) StdOut.print(x); 
					else		StdOut.print("-" + x);
				}
				StdOut.println();
			} else {
				StdOut.printf("%d to %d: not connected\n", s, v);
			}
		}
	}
}
