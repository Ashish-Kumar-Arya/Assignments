package dpalgorithms;

public class LongestCommonSequence {
	public static int lcs(char[]x,char[]y,int m,int n) {
		int[][] arr=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					arr[i][j]=0;
				}
				else if(x[i-1]==y[j-1]){
					arr[i][j]=arr[i-1][j-1]+1;
				}
				else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr[m][n];
	}
	
	public static void main(String[] args) {
		String s1="abccba";
		String s2="abddba";
		
		char f[]=s1.toCharArray();
		char s[]=s2.toCharArray();
		int m=s1.length();
		int n=s2.length();
		int lon=lcs(f,s,m,m);
		System.out.println("The longest subsequence is :"+lon);
	}
}
