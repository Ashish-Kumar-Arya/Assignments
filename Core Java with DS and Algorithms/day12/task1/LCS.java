package assignments.day12.task1;

public class LCS {
    public static int lcs(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        //Creating a 2D array to store the lengths of longest common subsequences.
        int[][] dp=new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        printLCS(text1, text2, dp);

        return dp[m][n];
    }

    private static void printLCS(String text1, String text2, int[][] dp) {
        int i=text1.length();
        int j=text2.length();

        StringBuilder sequence=new StringBuilder();

        while (i>0&&j>0) {
            if(text1.charAt(i-1)==text2.charAt(j-1)) {
                sequence.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>=dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }
        sequence.reverse();
        System.out.println("Locngest Common Subsequence: "+sequence.toString());
    }

    public static void main(String[] args) {
        String text1="abcde";
        String text2="ace";

        int lcsLength=lcs(text1, text2);
        System.out.println("Length of LCS: "+lcsLength);
    }
}