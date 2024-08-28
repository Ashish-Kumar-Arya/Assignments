package recursion;
public class SubsetSum {
	static boolean isSubset(int set[], int n, int sum) {
		if(sum==0)
			return true;
		if(n==0&&sum!=0)
			return false;
		if(set[n-1]>sum)
			return isSubset(set, n-1, sum);
		return (isSubset(set, n-1, sum-set[n-1])||isSubset(set, n-1, sum));
	}
	
	public static void main(String[] args) {
		int set[]= {1,9,7,5,18,12,20,15};
		int sum=35;
		int n=set.length;
		if(isSubset(set,n,sum))
			System.out.println("Subset is present");
		else
			System.out.println("Subset not present");
	}
}
