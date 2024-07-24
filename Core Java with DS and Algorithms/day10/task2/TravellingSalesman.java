package assignments.day10.task2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TravellingSalesman {
    public static int findMinCost(int[][] graph, int start) {
        int n=graph.length;
        int allVisited=(1<<n)-1;

        int[][] dp=new int[1<<n][n];
        for(int[] row:dp) {
            Arrays.fill(row, Integer.MAX_VALUE/2);
        }
        dp[1<<start][start]=0;

        for(int mask=1; mask<(1<<n); mask++) {
            for(int u=0; u<n; u++) {
                if((mask&(1<<u))==0) continue;

                for(int v=0; v<n; v++) {
                    if((mask&(1<<v))!=0) continue;
                    int nextMask=mask|(1<<v);
                    dp[nextMask][v]=Math.min(dp[nextMask][v], dp[mask][u]+graph[u][v]);
            }
            
            }
        }
        int minCost=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(i!=start) {
                minCost=Math.min(minCost,dp[allVisited][i]+graph[i][start]);
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph={
            {0,10,15,20},
            {10,0,35,25},
            {15,35,0,30},
            {20,25,30,0}
        };
        int n=graph.length;
        for(int i=0; i<n; i++) {
            int minCost=findMinCost(graph, i);
            System.out.println("Minimum cost starting from city "+i+": "+minCost);
        }
    }
}