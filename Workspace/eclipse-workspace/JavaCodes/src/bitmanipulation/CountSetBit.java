package bitmanipulation;

import java.util.Scanner;

public class CountSetBit {
	public static void main(String[] args) {
		int n;
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		System.out.println("Binary representation of "+n+" is "+ Integer.toBinaryString(n));
		System.out.println(countsetbit1(n));
		System.out.println(countsetbit2(n));
		System.out.println(countsetbit3(n));
		
	}
	
	public static int countsetbit1(int x) {
		int r=0;
		while(x>0) {
			if(x%2!=0) {
				r++;
			}
			x=x/2;
		}
		return r;
	}
	
	//using  Brian Kernighan's
	public static int countsetbit2(int x) {
		int r=0;
		while(x>0) {
			x=x&(x-1);
			r++;
		}
		return r;
	}
	
	public static int countsetbit3(int x) {
		int r=0;
		while(x>0) {
			if((x&1)!=0) {
				r++;
			}
			x>>=1;
		}
		return r;
	}
}
