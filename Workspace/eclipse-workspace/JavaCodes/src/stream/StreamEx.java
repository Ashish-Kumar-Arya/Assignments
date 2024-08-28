package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamEx {
	public static void main(String[] args) {
		List<Integer> num=Arrays.asList(23,14,30,06);
		List<Integer> even=num.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println("Even Numbers: "+even);
		int total =even.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Total Value: "+total);
		List<Double> num1=Arrays.asList(23.34,14.67,30.67,6.89);
		double max=num1.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
		System.out.println("Max. value is "+max);
	}
}