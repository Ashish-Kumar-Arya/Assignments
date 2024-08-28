package functionalInterface.predefine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerEx {
	public static void main(String[] args) {
		
		List<Integer> l1=new ArrayList<>(Arrays.asList(11,22,33));
		System.out.println("Original list: "+l1);
		Consumer<List<Integer>> product=list->{
			for(int i=0;i<list.size();i++) {
				list.set(i, list.get(i)*2);
			}
		};
		
		product.accept(l1);
		System.out.println("List after applying accept method: "+l1);
		
		List<String> l2=new ArrayList<>(Arrays.asList("Apple","Banana","Mango","Pineapple","Guava"));
		System.out.println("Original list: "+l2);
		Consumer<List<String>> product1=list->{
			for(int i=0;i<list.size();i++) {
				list.set(i, list.get(i).toUpperCase());
			}
		};
		
		product1.accept(l2);
		System.out.println("List after applying accept method: "+l2);
		
		//BiConsumer
		BiConsumer<List<Integer>, List<Integer>> compare=(l11,l12)->{
			if(l11.size()==l12.size()) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
		};
		List<Integer> aa=Arrays.asList(2,3,4);
		List<Integer> ab=Arrays.asList(2,3,4);
		compare.accept(aa, ab);
	}
}
