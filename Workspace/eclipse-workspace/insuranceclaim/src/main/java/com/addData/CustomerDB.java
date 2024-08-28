package com.addData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jakartaee.bcel.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class CustomerDB
 */

public class CustomerDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root","rps@123");
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO insurance_claim (first_name, last_name, policy_name, username, password, contact) VALUES (?,?,?,?,?,?);");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, policyName);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, contactNo);
			preparedStatement.executeUpdate();
			response.setContentType("text/plain");
			PrintWriter out=response.getWriter();
			out.print("Customer added");
			
		} catch (Exception e) {
			response.setContentType("text/plain");
			PrintWriter out=response.getWriter();
			out.print("Failed");
			e.printStackTrace();
		}
	}

}
