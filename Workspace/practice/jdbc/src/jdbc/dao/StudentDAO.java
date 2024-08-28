package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	
	Connection con;
	
	public void connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "rps@123");
	}
	
	public Student getStduent(int rollno) throws Exception {
		String query = "select student_name from student where student_id="+rollno;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString(1);
		return new Student(name, rollno);
	}
	
	public void addStudent(Student s) throws Exception {
		String query = "insert into student values (?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, s.rollno);
		st.setString(2, s.name);
		int result = st.executeUpdate();
		System.out.println(result + " row/s updates");
	}
}