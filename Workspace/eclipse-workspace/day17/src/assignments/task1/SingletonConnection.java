package assignments.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static SingletonConnection instance;
	private  Connection connection;
	private SingletonConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","rps@123");
	}
	
	public static SingletonConnection getInstance() throws SQLException, ClassNotFoundException {
		if(instance==null) {
			instance=new SingletonConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SingletonConnection sc=SingletonConnection.getInstance();
		Connection connection1=sc.getConnection();
		Connection connection2=sc.getConnection();
		System.out.println(connection1.equals(connection2));
	}
}
