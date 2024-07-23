package assignments.day16.task1;

import java.sql.Connection;
import java.sql.DriverManager;

public class EstablishConnection {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","rps@123");
			System.out.println(connection);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
