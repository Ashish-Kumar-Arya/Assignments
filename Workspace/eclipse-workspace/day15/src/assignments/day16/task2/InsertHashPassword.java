package assignments.day16.task2;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertHashPassword {
	public static String getHashPassword(String str) {
		String hashText=null;
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			byte[] hashBytes=md.digest(str.getBytes());
			BigInteger no=new BigInteger(1, hashBytes);
			hashText=no.toString(16);
			
			//Padding leading zeros
			while(hashText.length()<64) {
				hashText="0"+hashText;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return hashText;
	}
	
	public static void main(String[] args) {
		try {
			Connection connection=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","rps@123");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the user id");
			int id=sc.nextInt();
			System.out.println("Enter the password");
			sc.nextLine();
			String password=sc.nextLine();
			String insert="insert into user(user_id,password,password_hash) values(?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, getHashPassword(password));
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
