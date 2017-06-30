package com.hardik.hibernate;

import java.util.List;

import org.hibernate.SQLQuery;
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
		String sql = "select * from employee where salary=:salary";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("salary", 5000);

		List<Employee> employees = query.list();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		// Close Session
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
