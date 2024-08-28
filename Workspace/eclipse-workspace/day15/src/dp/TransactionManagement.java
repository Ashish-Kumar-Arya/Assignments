package dp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionManagement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","rps@123");
			System.out.println("Connected");
			Scanner sc=new Scanner(System.in);
			connection.setAutoCommit(false);
			System.out.println("Enter id , name and password");
			String insertQuery="insert into student(student_id,student_name,student_password) values(?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(insertQuery);
			while(true) {
				System.out.println("Enter id");
				int id=Integer.parseInt(sc.nextLine());
				System.out.println("Enter name");
				String name=sc.nextLine() ;
				System.out.println("Enter password");
				String password=sc.nextLine();
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, password);
				pstmt.executeUpdate();
				System.out.println("Want to commit or Rollback");
				String commit=sc.nextLine();
				if(commit.equals("Commit")||commit.equals("commit")) {
					connection.commit();
				}
				if(commit.equals("Rollback")||commit.equals("rollback")) {
					connection.rollback();
				}
				System.out.println("Want to insert values");
				String a=sc.nextLine();
				if(a.equals("Yes")||a.equals("yes")) {
					continue;
				}
				else {
					break;
				}
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}