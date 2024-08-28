package com.example.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
	private int V;
	private List<List<Node>> l1;
	static class Node
	{
		int dest;
		int weight;
		
		public Node(int dest, int weight) {
			this.dest=dest;
			this.weight=weight;
		}
	}
	
	public DijkstraAlgo(int v) {
		V=v;
		l1=new ArrayList<>();
		for(int i=0;i<v;i++) {
			l1.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int s, int d, int w) {
		l1.get(s).add(new Node(d,w)); //for directed graphs
		l1.get(d).add(new Node(s,w)); //for undirected graphs
	}
	
	public void djks(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node->node.weight));
		System.out.println(pq);
	}
	
	public static void main(String[] args) {
		DijkstraAlgo obj=new DijkstraAlgo(6);
		obj.addEdge(0, 1, 10);
		obj.addEdge(0, 2, 5);
		obj.addEdge(1, 2, 3);
		obj.addEdge(2, 3, 1);
		obj.addEdge(3, 4, 7);
		obj.addEdge(4, 5, 2);
		obj.djks(0);
	}
}
