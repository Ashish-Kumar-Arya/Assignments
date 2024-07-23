package assignments.day14.task2;

import java.util.Arrays;

public class GenericSwap {
    public static <T> void swap(T[] arr, int index1, int index2) {
        T temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    public static void main(String[] args) {
        Integer[] intArr={1,2,3,4,5};
        System.out.println("Original Integer array: "+Arrays.toString(intArr));
        swap(intArr, 1, 2);
        System.out.println("Swapped Integer array: "+Arrays.toString(intArr));

        String[] strArray={"A","B","C","D"};
        System.out.println("Original String array: "+Arrays.toString(strArray));
        swap(strArray, 1, 3);
        System.out.println("Swapped String array: "+Arrays.toString(strArray));

        Float[] floatArr={1.1f,1.2f,2.1f,2.2f};
        System.out.println("Original Float array: "+Arrays.toString(floatArr));
        swap(floatArr, 0, 3);
        System.out.println("Swapped Float array: "+Arrays.toString(floatArr));
    }
}
