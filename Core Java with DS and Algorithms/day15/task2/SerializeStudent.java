package assignments.day15.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

class SerializeStudent {
    public static void main(String[] args) throws IOException {
        Student s=new Student("Ashish", 11, LocalDate.of(2004, 5, 11));
        FileOutputStream fo=new FileOutputStream("/home/ashish/Desktop/student.ser");
        ObjectOutputStream out=new ObjectOutputStream(fo);
        out.writeObject(s);
        System.out.println("Serialization is done for Student in the file student.ser");
    }
}