package day16.assignments.task3;

public class StringUtil {
	
	public static String reverse(String str) {
		String rev="";
		for(int i=str.length()-1; i>=0; i--) {
			rev+=str.charAt(i);
		}
		return rev;
	}
	
	public static boolean isPalindrome(String str) {
		int start=0, end=str.length()-1;
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static boolean containsDigit(String str) {
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
