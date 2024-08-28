package bitmanipulation;

import java.util.Scanner;

public class Swap{
	
	static final int INT_BITS=8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=10,b=20;
		System.out.println("Before swaping: a="+a+" b="+b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("After shifting: a="+a+" b="+b);
	}
}