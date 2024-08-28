package jdbc;

import java.sql.*;

public class DemoClass {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/wipro";
		String uname = "root";
		String pass = "rps@123";
		int id = 2;
		String username = "Kamal";
		String query="insert into student values (?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, username);
		int count = st.executeUpdate();
		System.out.println(count + " row/s updated");
		st.close();
		con.close();
	}

}