package fileoperations;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) throws IOException {
		FileOutputStream fo=new FileOutputStream("/home/rps/Desktop/names.txt");
		String names="Ashish,Anuj,Kamal,Kavita,Neha";
		byte arr[]=names.getBytes();
		fo.write(arr);
		fo.close();
	}
}
