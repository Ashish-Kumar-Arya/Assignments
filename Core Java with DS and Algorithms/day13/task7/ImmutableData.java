package assignments.day13.task7;

public final class ImmutableData {
    private final int value;

    public ImmutableData(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        ImmutableData data=new ImmutableData(42);
        Runnable printTask=()->{
            System.out.println("Immutable Data Value: "+data.getValue());
        };

        Thread thread1=new Thread(printTask);
        Thread thread2=new Thread(printTask);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}