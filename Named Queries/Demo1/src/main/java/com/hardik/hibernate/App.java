package com.hardik.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hardik.hibernate.model.Employee;
import com.hardik.hibernate.util.HibernateUtil;

/**
 * App Main
 *
 */
public class App {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Criteria
		Query query = session.getNamedQuery("findEmployeeBySalary");
		query.setParameter("salary", 5000);

		List<Employee> employees = query.getResultList();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		// Close Session
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
