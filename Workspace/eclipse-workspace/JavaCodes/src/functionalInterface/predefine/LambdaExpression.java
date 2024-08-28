package functionalInterface.predefine;

@FunctionalInterface
interface Operate<T> {
	T calculate(T a, T b);
}

public class LambdaExpression {
public static void main(String[] args) {
	Operate<Integer> rf=(a,b)->a+b;
	System.out.println(rf.calculate(25, 35));
	Operate<Double> rf1=(a,b)->a+b;
	System.out.println(rf1.calculate(25.33, 1.33));
}
}
