package com.example.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<Integer, List<Integer>> al;

	public Graph() {
		al = new HashMap<>();
	}
	
	// vertex method
	public void addVertex(int x) {
		al.putIfAbsent(x,new LinkedList<>());
	}
	
	// edge method
	public void addEdge(int s, int d) {
		al.get(s).add(d); // add source to destination
		// for undirected graph
		al.get(d).add(s);
	}
	
	// display
	public void display() {
		for(int vertex: al.keySet()) {
			System.out.println("Vertex "+vertex+" - ");
			for(int edge: al.get(vertex)) {
			System.out.println(edge+" ");	
			}
			System.out.println(" ");
		}	
	}
	
	public static void main(String args[]) {
		Graph g = new Graph();
		g.addVertex(11);
		g.addVertex(12);
		g.addVertex(13);
		g.addVertex(14);
		
		g.addEdge(11, 12);
		g.addEdge(11, 13);
		g.addEdge(12, 13);
		g.addEdge(11, 14);
		g.display();
	}
}