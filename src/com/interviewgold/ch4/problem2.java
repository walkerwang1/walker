package com.interviewgold.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem2 {
	
	private class Graph {

		List<Node> getNodes() {
			List<Node> list = new ArrayList<>();
			return list;
		}
	}
	
	private class Node {
		State state;
		
		List<Node> getAdjacent() {
			List<Node> list = new ArrayList<>();
			return list;
		}
	}
	
	private enum State {
		Unvisited, Visited, Visiting;
	}
	
	/*
	 * BFS
	 */
	public static boolean search(Graph g, Node start, Node end) {
		//队列
		LinkedList<Node> q = new LinkedList<>();
		
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				for(Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						}else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
	}
}
