package assignments.day9.task2;

public class NonRepeating {
    public static void nonRepeating(int arr[]) {
        int xor=0;
        for(int n:arr) {
            xor=xor^n;
        }
        int setBit=xor&~(xor-1);
        int x=0,y=0;
        for(int num:arr) {
            if((num&setBit)!=0) {
                x=x^num;
            }
            else {
                y=y^num;
            }
        } 
        System.out.println("Non repeating elements in the array are "+x+" and "+y);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,1,2,4};
        nonRepeating(arr);
    }
}
