package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDao {
	public int registerCustomer(Customer customer) throws ClassNotFoundException {
		String INSERT_CUSTOMER="INSERT INTO insurance_claim (first_name, last_name, policy_name, username, password, contact) VALUES (?,?,?,?,?,?);";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try 
		(
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root","rps@123");
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_CUSTOMER);
		) {
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getPolicyName());
			preparedStatement.setString(4, customer.getUsername());
			preparedStatement.setString(5, customer.getPassword());
			preparedStatement.setString(6, customer.getContact());
			
			System.out.println(preparedStatement);
			result=preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void printSQLException(SQLException ex) {
		for(Throwable e: ex) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: "+((SQLException) e).getSQLState());
			System.err.println("Error Code: "+((SQLException) e).getErrorCode());
			System.err.println("MEssage: "+e.getMessage());
			Throwable t=ex.getCause();
			while(t!=null) {
				System.out.println("Cause: "+t);
				t=t.getCause();
			}
		}
	}
}
