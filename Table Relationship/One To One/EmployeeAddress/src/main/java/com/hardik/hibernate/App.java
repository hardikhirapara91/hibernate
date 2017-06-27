package com.hardik.hibernate;

import org.hibernate.Session;

import com.hardik.hibernate.model.Address;
import com.hardik.hibernate.model.Employee;
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

		// Set Address
		Address addr = new Address();
		addr.setStreet("Street");
		addr.setCity("Rajkot");
		addr.setState("GJ");
		addr.setCountry("IN");
		addr.setZipCode(655425);

		// Set Employee
		Employee emp = new Employee();
		emp.setEmpName("Hardik");
		emp.setDepartment("Computer");

		emp.setAddress(addr);
		addr.setEmployee(emp);

		// Save User
		session.save(emp);
		session.getTransaction().commit();

		// Close Session
		HibernateUtil.shutdown();
	}
}
