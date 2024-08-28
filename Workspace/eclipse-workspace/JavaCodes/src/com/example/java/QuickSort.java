package com.example.java;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11,1,13,110, 12};
		quickSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr);
		}
	}
		
	public static int partition(int[] arr, int low, int high) {
		int pivot=high;
		int i=low-1;
		for(int j=low;j<=high-1;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;	
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		int pi=partition(arr, low, high);
		quickSort(arr, pi+1, high);
		quickSort(arr, low, pi-1);
	}
}
