package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
	public static void main(String[] args) {
		//without generics
		List l1=new ArrayList<>();
		l1.add("Java");
		l1.add("Python");
		l1.add(1234);
//		for(Object s:l1) {
//			System.out.println((String) s); it will throw run time error
//		}
	}
}