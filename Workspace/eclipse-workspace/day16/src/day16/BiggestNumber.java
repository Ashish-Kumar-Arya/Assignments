package day16;

public class BiggestNumber {
	public static int biggest(int arr[])
	{
		int biggest=0;
		for(int i=0; i<arr.length; i++) {
			if(biggest<arr[i]) {
				biggest=arr[i];
			}
		}
		return biggest;
	}
}