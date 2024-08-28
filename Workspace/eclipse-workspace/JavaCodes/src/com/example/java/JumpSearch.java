package com.example.java;

public class JumpSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 14, 15, 24, 38, 45};
		int target = 38;
		System.out.println(jumpSearch(arr, target));
	}

	public static int jumpSearch(int[] arr, int target) {
		int step = (int) Math.sqrt(target);
		int start=0, end=step;
		if(arr[arr.length-1]<target) {
			return -1;
		}
		while(arr[end-1]<target) {
			start=end;
			end+=step;
			if(end>arr.length) {
				start=end-1;
				end=arr.length;
				break;
			}
		}
		System.out.println(start+"-"+(end-1));
		while(start<end) {
			if(arr[start]==target) {
				return start;
			}
			else {
				start++;
			}
		}
		return -1;
	}
}
