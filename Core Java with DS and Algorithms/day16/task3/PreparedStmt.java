package assignments.day16.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStmt {

	public static void main(String[] args) {
		try {
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","rps@123");
			String query="select user_id from user where password=?";
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, "ashish12;");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("user_id"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}