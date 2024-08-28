package bitmanipulation;

public class TotalSetBit {
	
	public static int counts(int n) {
		int total=0;
		for(int i=1; i<=n; i++) {
			total+=countsetbit(i);
		}
		return total;
	}
	
	public static int countsetbit(int x) {
		int r=0;
		while(x>0) {
			if(x%2!=0) {
				r++;
			}
			x=x/2;
		}
		return r;
	}
	
	public static void main(String[] args) {
		System.out.println(counts(5));
	}
}
