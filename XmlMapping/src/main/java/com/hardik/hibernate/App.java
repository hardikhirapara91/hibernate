package com.hardik.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.hardik.hibernate.model.User;
import com.hardik.hibernate.util.HibernateUtil;

/**
 * App Main
 *
 */
public class App {

	public static void main(String[] args) {

		System.out.println("Maven + Hibernate + MySQL");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Set User Object
		User user = new User();
		user.setUsername("hardikh");
		user.setCreatedBy("hiteshh");
		user.setCreatedDate(new Date());

		// Save User
		session.save(user);
		session.getTransaction().commit();

		// Close Session
		HibernateUtil.shutdown();
	}
}
