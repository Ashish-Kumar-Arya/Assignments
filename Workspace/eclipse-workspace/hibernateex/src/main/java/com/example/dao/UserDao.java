package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.User;
import com.example.util.HibernateUtil;

public class UserDao {
	public void saveUser(User user) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<User> getUsers() {
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM User", User.class).list();
		}
	}
	
	public void updateUser(User user) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteUser(Long userId) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			User user=session.get(User.class, userId);
			if(user!=null) {
				session.delete(user);
			}
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
