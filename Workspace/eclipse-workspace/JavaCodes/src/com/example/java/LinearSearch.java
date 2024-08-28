package com.example.java;

public class LinearSearch {

	public static int linearSearch(int[] arr, int target) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==target) {
				return i;
			}
		}
			return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,21,33,45,21,12,43};
		int target=12;
		int ind = linearSearch(arr,target);
		if(ind==-1) {
			System.out.println("Target not found.");
		}
		else {
			System.out.println(target+" is at index "+ind+".");	
		}
	}

}
