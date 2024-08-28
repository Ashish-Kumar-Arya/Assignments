package functionalInterface.predefine;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEx {
	public static void main(String[] args) {
		List<String> ls=Arrays.asList("Ram", "Shyam","Sita","Sam");
		// predicate to filter the strings starts with 'S'.
		Predicate<String> withS=l1->l1.startsWith("S");
		List<String> names=ls.stream().filter(withS).collect(Collectors.toList());
		System.out.println(names);
		
		// predicate to filter the strings with length greater than 3.
		Predicate<String> length3=l1->l1.length()>3;
		List<String> len=ls.stream().filter(length3).collect(Collectors.toList());
		System.out.println(len);
		
		// BiPredicate
		BiPredicate<Integer, Integer> greater=(x,y)->x>y;
		System.out.println("Is the number greater: "+greater.test(50, 45));
	}
}
	