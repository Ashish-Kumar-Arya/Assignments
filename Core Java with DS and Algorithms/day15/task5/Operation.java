package assignments.day15.task5;

import java.io.Serializable;

public class Operation implements Serializable {
    private int a;
    private int b;
    private char o;
    public Operation(int a, int b, char o) {
        this.a = a;
        this.b = b;
        this.o = o;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public char getO() {
        return o;
    }
    public void setO(char o) {
        this.o = o;
    }
}