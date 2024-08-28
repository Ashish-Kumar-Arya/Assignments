package com.example;

import java.util.List;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.util.HibernateUtil;

public class HibernateCrudleExample {
	public static void main(String[] args) {
		UserDao userDao=new UserDao();
		//Create
		userDao.saveUser(new User("Kamal","Arya","kamal@gmail.com"));
		userDao.saveUser(new User("Manish","Arya","manish@gmail.com"));
		
		//Read
		List<User> users=userDao.getUsers();
		users.forEach(System.out::println);
		
		//Update
		User user=users.get(0);
		user.setFirstName("Pankaj");
		userDao.updateUser(user);
		
		//Delete
		userDao.deleteUser(user.getId());
		
		//Read
		users=userDao.getUsers();
		users.forEach(System.out::println);
		
		//Shutdown Hibernate
		HibernateUtil.shutDown();
	}
}
