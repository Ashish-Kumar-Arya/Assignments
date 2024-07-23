package assignments.day7.task1;

import java.util.ArrayList;

public class DFS {
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++) {
            if(!vis[i]) {
                dfsUtil(vis, adj, i);
            }
        }
    }

    public static void dfsUtil(boolean[] vis, ArrayList<ArrayList<Integer>> adj,int v) {
                vis[v]=true;
                System.out.print(v+" ");
                for(Integer neighbor: adj.get(v)) {
                    if(!vis[neighbor]) {
                        dfsUtil(vis, adj, neighbor);
                    }
    }
}                

    public static void main(String[] args) {
    int v=7,e=10;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
    }
    addEdge(adj,0,1);
    addEdge(adj,0,5);
    addEdge(adj,0,3);
    addEdge(adj,0,4);
    addEdge(adj,1,2);
    addEdge(adj,1,3);
    addEdge(adj,2,3);
    addEdge(adj,2,5);
    addEdge(adj,3,5);
    addEdge(adj,4,5);
    dfs(adj,v);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,Integer source, Integer dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);  
    }
}