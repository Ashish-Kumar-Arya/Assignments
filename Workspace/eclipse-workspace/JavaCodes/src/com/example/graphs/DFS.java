package com.example.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
	private int V;
	private LinkedList<Integer> l1[];
	
	public DFS(int v) {
		V=v;
		l1=new LinkedList[v];
		for(int i=0;i<v;i++) {
			l1[i]=new LinkedList<>();
		}
	}	
	
	public void addEdge(int v, int w) {
		l1[v].add(w);
		l1[w].add(v);
	}
	
	public void dfs(int s) {
		boolean visited[] = new boolean[V];
		Stack<Integer> stack=new Stack<>();
		stack.push(s);
		while(!stack.isEmpty()) {
			int temp=stack.pop();
			if(!visited[temp]) {
				System.out.print(temp+" " );
				visited[temp]=true;
			}
			for(int adj:l1[temp]) {
				if(!visited[adj]) {
					stack.push(adj);
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DFS obj = new DFS(6);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(0, 3);
		obj.addEdge(0, 4);
		obj.addEdge(0, 0);
		obj.addEdge(1, 5);
		obj.dfs(5);
	}
	
}
