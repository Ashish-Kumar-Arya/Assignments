package assignments.day7.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {
    static class Graph {
        private final int vertices;
        private final List<Edge> edges;

        static class Edge {
            int source, target, weight;
            Edge(int source, int target, int weight) {
                this.source=source;
                this.target=target;
                this.weight=weight;
            }
        }

        Graph(int vertices) {
            this.vertices=vertices;
            this.edges=new ArrayList<>();
        }

        //Adding an undirected edge
        void addEdge(int source, int target, int weight) {
            edges.add(new Edge(source, target, weight));
        }

        List<Edge> kruskalMST() {
            edges.sort(Comparator.comparingInt(edge->edge.weight));
            UnionFind unionFind=new UnionFind(vertices);
            List<Edge> mst=new ArrayList<>();

            for(Edge edge:edges) {
                int root1=unionFind.find(edge.source);
                int root2=unionFind.find(edge.target);
                //If adding this edge doesn't from a cycle
                if(root1!=root2) {
                    mst.add(edge);
                    unionFind.union(root1, root2);
                }
            }
            return mst;
        }

        static class UnionFind {
            private final int[] parent;
            private final int[] rank;

            UnionFind(int size) {
                parent=new int[size];
                rank=new int[size];
                for(int i=0; i<size; i++) {
                    parent[i]=i;
                    rank[i]=0;
                }
            }

            int find(int u) {
                if(parent[u]!=u) {
                    parent[u]=find(parent[u]);
                }
                return parent[u];
            }

            void union(int u, int v) {
                int rootU=find(u);
                int rootV=find(v);
                if(rootU!=rootV) {
                    if(rank[rootU]>rank[rootV]) {
                        parent[rootV]=rootU;
                    }
                    else if(rank[rootU]<rank[rootV]) {
                        parent[rootU]=rootV;
                    }
                    else {
                        parent[rootV]=rootU;
                        rank[rootU]++;
                    }
                }
            }
        }
        
    }

    public static void main(String[] args) {
        Graph graph=new Graph(4);

        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);

        List<Graph.Edge> mst=graph.kruskalMST();

        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight=0;
        for(Graph.Edge edge:mst) {
            System.out.println(edge.source+" -- "+edge.target+" == "+edge.weight);
            totalWeight+=edge.weight;
        }
        System.out.println("Total weight of MST: "+totalWeight);
    }
}