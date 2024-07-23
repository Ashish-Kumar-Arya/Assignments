package assignments.day14.task1;

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first=first;
        this.second=second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public Pair<U,T> reversedPair() {
        return new Pair<>(second, first);
    }

    

    @Override
    public String toString() {
        return "Pair{"+"first="+first+", second="+second+'}';
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair=new Pair<Integer,String>(1, "one");
        System.out.println("Original pair: "+pair);

        Pair<String, Integer> reversedPair=pair.reversedPair();
        System.out.println("Reversed pair: "+reversedPair);
    }
}
