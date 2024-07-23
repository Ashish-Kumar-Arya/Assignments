package assignments.day15.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeStudent {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fi=new FileInputStream("/home/ashish/Desktop/student.ser");
        ObjectInputStream oi=new ObjectInputStream(fi);
        Student s=(Student)oi.readObject();
        System.out.println("Deserialized object values: "+s.getName()+" "+s.getRollno()+" "+s.getDob());
    }
}
