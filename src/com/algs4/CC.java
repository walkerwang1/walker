package com.algs4;

import java.io.File;

/**
 * 无向图连通分量问题。
 * 
 * @author walkerwang
 *
 */
public class CC {
	
	private boolean[] marked;
	
	private int[] id;
	
	private int[] size;
	
	private int count;
	
	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);	//顶点v连通的所有其他顶点，构成一个连通分量
				count++;	//连通分量的个数
			}
		}
	}
	
	//深度优先搜索
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;		//顶点v属于哪一个连通分量
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	//判断顶点v和w是否连通
	private boolean connected(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return id[v] == id[w];
	}
	
	//连通分量的个数
	private int count() {
		return count;
	}
	
	private int id(int v) {
		validateVertex(v);
		return id[v];
	}
	
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}
	
	public static void main(String[] args) {
		In in = new In(new File("tinyG.txt"));
		Graph G = new Graph(in);
		CC cc = new CC(G);
		
		//连通分量的个数
		int m = cc.count();
		StdOut.println(m + " components");
		
		Queue<Integer>[] components = new Queue[m];
		for (int i = 0; i < m; i++) {
			components[i] = new Queue<>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].enqueue(v);
		}
		
		 for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
	}
}
