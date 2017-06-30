package com.hardik.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hardik.hibernate.model.Employee;
import com.hardik.hibernate.util.HibernateUtil;

/**
 * App Main
 *
 */
public class App {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			transaction.setTimeout(5);

			// Criteria
			Query query = session.getNamedQuery("findEmployeeBySalary");
			query.setParameter("salary", 5000);

			List<Employee> employees = query.getResultList();

			for (Employee employee : employees) {
				System.out.println(employee);
			}

			transaction.commit(); // Commit

		} catch (RuntimeException ex) {
			transaction.rollback();
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
	}
}
