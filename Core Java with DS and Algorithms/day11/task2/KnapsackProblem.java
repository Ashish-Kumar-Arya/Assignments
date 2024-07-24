package assignments.day11.task2;

public class KnapsackProblem {
    public static int knapsackProblem(int w, int[] weights, int[] values) {
        int n=weights.length;
        //Creating a dp array to store the maximum value for each capacity
        int[] dp=new int[w+1];

        for(int i=0; i<=w; i++) {
            dp[i]=0;
        }

        for(int i=0; i<n; i++) {
            int weight=weights[i];
            int value=values[i];
            for(int j=w; j>=weight; j--) {
                dp[j]=Math.max(dp[j], dp[j-weight]+value);

            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int[] weights={10,20,30};
        int[] values={60,100,120};
        int capacity=50;

        int maxValue=knapsackProblem(capacity, weights, values);
        System.out.println("Maximum value that can be accomodated in the knapsack: "+maxValue);
    }
}
