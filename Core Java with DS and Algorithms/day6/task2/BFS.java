package assignments.day6.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        int v=7,e=10;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
    }
    addEdge(adj,0,1);
    addEdge(adj,0,2);
    addEdge(adj,0,3);
    addEdge(adj,0,4);
    addEdge(adj,1,2);
    addEdge(adj,1,3);
    addEdge(adj,2,3);
    addEdge(adj,2,5);
    addEdge(adj,3,4);
    addEdge(adj,4,5);
    bfs(adj,v);
}

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,Integer source, Integer dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);  
    } 

    static void bfs(ArrayList<ArrayList<Integer>> adj, int v) {
        if(adj.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[] = new boolean[v];
        for(int i=0; i<v; i++) {
            if(vis[i]==false) {
                q.add(i);
                vis[i]=true;
        
        while(!q.isEmpty()) {
            Integer node=q.poll();
            System.out.print(node+" ");
            if(adj.get(node)!=null) {
                for(Integer it:adj.get(node)) {
                    if(vis[it]==false) {
                        vis[it]=true;
                        q.add(it);
                    }
                }
            }
            
        }
        } 
    }
    }
}