package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeStudent {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fi=new FileInputStream("/home/rps/Desktop/student.ser");
		ObjectInputStream oi=new ObjectInputStream(fi);
		Student s=(Student)oi.readObject();
		System.out.println("Deserialized Object Value "+s.getName()+" "+s.getRoll()+" "+s.getDob());
	}
}