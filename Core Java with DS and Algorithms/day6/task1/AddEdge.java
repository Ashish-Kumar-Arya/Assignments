package assignments.day6.task1;

import java.util.ArrayList;

public class AddEdge {

    public static void main(String[] args) {
        int v=7;
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
        addEdge(adj,2,1);
        addEdge(adj,2,5);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
    }
    
    public static void addEdge(ArrayList<ArrayList<Integer>> adj,Integer source, Integer dest) {
        adj.get(source).add(dest);
        if(isCyclic(adj.size(), adj)){
            System.out.println("Edge "+source+" "+dest+" is not added due to cycle generation");
            adj.get(source).remove(dest);
        }
        else {
            System.out.println("Edge "+source+" "+dest+" added");
        }
    } 

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        boolean recS[]=new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(dfs(i,adj,vis,recS)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean recS[]) {
        vis[v]=true;
        recS[v]=true;
        for(Integer neighbor:adj.get(v)) {
            if(!vis[neighbor]) {
                if(dfs(neighbor, adj, vis, recS)) return true;
            }
            else if(recS[neighbor]) {
                return true;
            }
        }
        recS[v]=false;
        return false;
    }
}