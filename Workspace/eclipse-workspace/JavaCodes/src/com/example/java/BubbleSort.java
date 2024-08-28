package com.example.java;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {11, 151, 10, 15, 66, 3};
		System.out.print("Unsorted array: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		bubbleSort(arr);
		System.out.print("Sorted array: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println("i="+i);
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1]>arr[j]) {
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
			for(int k=0; k<arr.length;k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
		}
	}

}
