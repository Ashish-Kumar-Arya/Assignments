package com.example.java;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {11, 23, 45, 53, 55, 62};
		int target=11;
		int ind=binarySearch(arr, target);
		if(ind==-1) {
			System.out.println("Target not found.");
		}
		else {
			System.out.println(target+" is at index "+ind);
		}
	}

	public static int binarySearch(int[] arr, int target) {
		int start=0, end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			System.out.println("start="+start+",end="+end+",mid="+mid);
			if(arr[mid]==target) {
				return mid;
			}
			else if(arr[mid]>target) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return -1;
	}
}
