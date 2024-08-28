package hasingpassword;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Authentication {
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
			System.out.println("Enter id");
			int id=Integer.parseInt(sc.nextLine());
			System.out.println("Enter password");
			String password=sc.nextLine();
			String hashedInputPassword=getHashPassword(password);
			String query="select password_hash from user where user_id=?";
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				String dbhashPassword=rs.getString("password_hash");
				if(hashedInputPassword.equals(dbhashPassword)) {
					System.out.println("access is allowed");
				}
				else {
					System.out.println("user not allowed");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}