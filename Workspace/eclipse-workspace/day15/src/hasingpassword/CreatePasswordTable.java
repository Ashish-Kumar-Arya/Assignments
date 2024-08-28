package hasingpassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreatePasswordTable {
	public static void main(String[] args) {
		try {
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","rps@123");
			//Table creating
			String create="create table user (user_id INT PRIMARY KEY, password varchar(30) NOT NULL ,password_hash varchar(200) NOT NULL)";
			PreparedStatement pstmt=connection.prepareStatement(create);
			pstmt.executeUpdate();
			System.out.println("Table created");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
