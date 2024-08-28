package functionalInterface.predefine;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionEx {
	public static void main(String[] args) {
		List<String> l1=Arrays.asList("Hi", "Hello", "How", "Oh");
		System.out.println("Greetings");
		System.out.println(l1);
		Function<String, String> adding=s->s+" !";
		List<String> greetings=l1.stream().map(adding).collect(Collectors.toList());
		System.out.println("Greetings with Exclamation");
		System.out.println(greetings);
		
		Function<String, Integer> len=s->s.length();
		List<Integer> ll=l1.stream().map(len).collect(Collectors.toList());
		System.out.println(ll);
		
		//BiFunction
		BiFunction<Integer, Integer, Integer> add=(x,y)->x+y;
		System.out.println(add.apply(3, 7));
		BiFunction<Double, Double, Double> sum=(x,y)->x+y;
		System.out.println(sum.apply(30.343,40.454));
	}
}
