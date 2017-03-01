package com.algs4;

import java.io.File;
import java.util.Stack;

/**
 * 
 * @author walkerwang
 *
 * result:
 *  1 to 0: 1-0
	1 to 1: 1
	1 to 2: 1-0-2
	1 to 3: 1-0-6-4-5-3
	1 to 4: 1-0-6-4
	1 to 5: 1-0-6-4-5
	1 to 6: 1-0-6
	1 to 7:  not connected
	1 to 8:  not connected
	1 to 9:  not connected
	1 to 10:  not connected
	1 to 11:  not connected
	1 to 12:  not connected
 */
public class DepthFirstPaths {

	private boolean[] marked; 
	
	private int[] edgeTo;
	
	//空final
	private final int s;
	
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		validateVertex(s);
		dfs(G, s);
	}
	
	/**
	 * 深度优先搜索
	 * @param G
	 * @param v
	 */
	public void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;	// v->w, edgeTo[w]=v
				dfs(G, w);
			}
		}
	}
	
	/**
	 * 从源顶点s到v是否可达
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	public int hasPath(int v) {
		validateVertex(v);
		return edgeTo[v];
	}
	
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
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
		}
	}
	
	public static void main(String[] args) {
		In in = new In(new File("tinyG.txt"));
		Graph G = new Graph(in);
		int s = 1;
		
		DepthFirstPaths dfs = new DepthFirstPaths(G, s);
		
		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				StdOut.printf("%d to %d: ", s, v);
				Stack<Integer> stack = dfs.pathTo(v);
				while(stack.size() != 0) {
					int x = stack.pop();
					if (x == s) StdOut.print(x); 
					else		StdOut.print("-" + x);
				}
				StdOut.println();
			}
			else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }
		}
	}
}
