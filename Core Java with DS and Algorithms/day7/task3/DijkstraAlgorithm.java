package assignments.day7.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static class Graph {
        private final int vertices;
        private final Map<Integer, List<Edge>> adjList;

        static class Edge {
            int target;
            int weight;

            Edge(int target, int weight) {
                this.target=target;
                this.weight=weight;
            }
        }

        Graph(int vertices) {
            this.vertices=vertices;
            this.adjList=new HashMap<>();
            for(int i=0; i<vertices; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

        void addEdge(int source, int target, int weight) {
            adjList.get(source).add(new Edge(target, weight));
            // for undirecte graph, add the reverse edge
            adjList.get(target).add(new Edge(source, weight));
        }

        int[] dijkstra(int start) {
            int[] dist=new int[vertices];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start]=0;

            PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(node->node.distance));
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node currentNode=pq.poll();
                int u=currentNode.vertex;

                //Iterate over the adjacent nodes
                for(Edge edge:adjList.get(u)) {
                    int v=edge.target;
                    int weight=edge.weight;

                    if(dist[u]+weight<dist[v]) {
                        dist[v]=dist[u]+weight;
                        pq.add(new Node(v,dist[v]));
                    }
                }
            }
            return dist;
        }

        static class Node {
            int vertex;
            int distance;

            Node(int vertex, int distance) {
                this.vertex=vertex;
                this.distance=distance;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 3);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 9);
        graph.addEdge(3, 2, 7);
        graph.addEdge(4, 1, 1);
        graph.addEdge(4, 2, 8);
        graph.addEdge(0, 1, 10);
        graph.addEdge(4, 3, 2);

        int[] distances=graph.dijkstra(0);
        System.out.println("Shortest paths from node 0");
        for(int i=0; i<distances.length; i++) {
            System.out.println("Distance to node "+i+" is "+distances[i]);
        }
    }
}
