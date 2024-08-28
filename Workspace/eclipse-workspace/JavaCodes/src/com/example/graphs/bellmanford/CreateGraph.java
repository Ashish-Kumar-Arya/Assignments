package com.example.graphs.bellmanford;

public class CreateGraph {
	
	class CreateEdge {
		int s,d,w;
		
		CreateEdge() {
			s=d=w=0;
		}
	}
	
	int V,E;
	CreateEdge edge[];
	
	CreateGraph(int v, int e) {
		V=v;
		E=e;
		edge=new CreateEdge[e];
	}
}
