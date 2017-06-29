package com.hardik.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
		Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.lt("salary", 4000));
		List<Employee> employees = criteria.list();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		// Close Session
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
