package assignments.day9.task1;

import java.util.Scanner;

public class TotalSetBits {
    public static int totalCount(int n) {
        int total=0;
        for(int i=1;i<=n; i++) {
            total+=countSetBits(i);
        }
        return total;
    }

    public static int countSetBits(int x) {
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
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Total number of set bits in binary representation of "+n+" is "+countSetBits(n));
        System.out.println("Total number of set bits from 1 to " +n+" is "+totalCount(n));
    }
}
