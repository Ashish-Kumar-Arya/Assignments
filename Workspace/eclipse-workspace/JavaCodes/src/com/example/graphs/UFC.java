package com.example.graphs;

public class UFC {
	int V,E;
	Edge edge[];
	
	class Edge {
		int s,d;
	}
	
	public UFC(int v, int e) {
		V=v;
		E=e;
		edge=new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i]=new Edge();	
		}
	}
	
	public int find(int parent[], int i) {
		if(parent[i]==i) {
			return i;
		}
		return find(parent, parent[i]);
	}
	
	public boolean isCycle(UFC g) {
		int parent[] = new int[g.V];
		for(int i=0;i<g.V;i++) {
			parent[i]=i;
		}
		for(int i=0;i<g.E;i++) {
			int x=g.find(parent, g.edge[i].s);
			int y=g.find(parent, g.edge[i].d);
			if(x==y) {
				return true;
			}
			g.union(parent,x,y);
		}
		return false;
	}
	
	public void union(int[] parent, int x, int y) {
		parent[x]=y;
	}
	
	public static void main(String args[]) {
		UFC graph = new UFC(3,2);
		// add edge 0-1
		graph.edge[0].s=0;
		graph.edge[1].d=1;
		
		// add edge 1-2
		graph.edge[0].s=1;
		graph.edge[1].d=2;
		
//		 add edge 0-2
		graph.edge[0].s=0;
		graph.edge[1].d=2;
		
		System.out.println(graph.isCycle(graph));
	}
}
