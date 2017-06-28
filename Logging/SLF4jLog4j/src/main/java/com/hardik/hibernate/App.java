package com.hardik.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hardik.hibernate.model.Course;
import com.hardik.hibernate.model.Student;
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

		// Set Student
		Student student1 = new Student("Eswar");

		// Set Course
		Set<Course> courses = new HashSet<Course>();
		courses.add(new Course("ABC"));

		student1.setCourses(courses);

		// Save User
		session.save(student1);

		session.getTransaction().commit();

		// Close Session
		HibernateUtil.shutdown();
	}
}
