package com.algs4;

import java.util.Iterator;
import java.util.Stack;

public class Graph {
	 private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	/**
	 * Initializes an empty graph with {@code V} vertices and 0 edges
	 * param V the number of vertices
	 * 
	 * @param V
	 * 		number of vertices
	 * @throws IllegalArgumentExeception if {@code V < 0}
	 */
	public Graph(int V) {
		if (V < 0 ) {
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		}
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	public Graph(In in) {
		try {
			this.V = in.readInt();
			if (V < 0) {
				throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
			}
			adj = (Bag<Integer>[]) new Bag[V];
			for (int v = 0; v < V; v++) {
				adj[v] = new Bag<Integer>();
			}
			
			int E = in.readInt();
			if (E < 0) {
				throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
			}
			for (int i = 0; i < E; i++) {
				int v = in.readInt();
				int w = in.readInt();
				validateVertex(v);
				validateVertex(w);
				addEdge(v, w);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("invalid input format in Graph constructor", e);
		}
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}
	
	/**
     * Initializes a new graph that is a deep copy of {@code G}.
     *
     * @param  G the graph to copy
     */
	public Graph(Graph G) {
		this.V = G.V();
		this.E = G.E();
		for (int v = 0; v < V; v++) {
			Stack<Integer> reverse = new Stack<>();
//			for (int w : G.adj[v]) {
//				reverse.push(w);
//			}
			Iterator<Integer> iter = G.adj[v].iterator();
			while(iter.hasNext()) {
				int w = iter.next();
				reverse.push(w);
			}
			
			for (int w : reverse) {
				adj[v].add(w);
			}
		}
		
	}
	
	/**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }
	
	/**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	/**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		//adj[v]是Bag对象，怎么返回Iterable？
//		return adj[v];
		return null;
	}
	
	/**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	/**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + NEWLINE);
		for(int v = 0; v < V; v++) {
			sb.append(v + ": ");
			Iterator<Integer> iter = adj[v].iterator();
			while(iter.hasNext()) {
				int w = iter.next();
				sb.append(w + " ");
			}
			sb.append(NEWLINE);
		}
		return sb.toString();
	}
	
	/**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
