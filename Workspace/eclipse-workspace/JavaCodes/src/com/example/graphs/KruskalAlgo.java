package com.example.graphs;

public class KruskalAlgo {
	
	static class Edge {
		int src, des, weight;
		
		public Edge(int s, int d, int w) {
			this.src=s;
			this.des=d;
			this.weight=w;
		}
	}
	
	static class Subset {
		int parent, rank;
		public Subset(int parent, int rank) {
			this.parent=parent;
			this.rank=rank;
		}
	}

	private static void union(Subset[] subsets, int x, int y) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
