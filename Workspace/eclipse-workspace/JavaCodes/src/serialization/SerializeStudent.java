package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class SerializeStudent {
	public static void main(String[] args) throws IOException {
		Student std=new Student("Ashish", 11, LocalDate.of(2005, 07, 22));
		FileOutputStream fo=new FileOutputStream("/home/rps/Desktop/student.ser");
		ObjectOutputStream out=new ObjectOutputStream(fo);
		out.writeObject(std);
		System.out.println("Serialization done for Student in the file student.ser");
	}
}
