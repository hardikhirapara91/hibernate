package com.hardik.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hardik.hibernate.model.Cart;
import com.hardik.hibernate.model.Items;
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

		// Set Cart
		Cart cart = new Cart();
		cart.setName("Cart1");

		// Set Items
		Items item1 = new Items("I10", 10, 1, cart);
		Items item2 = new Items("I20", 20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1);
		itemsSet.add(item2);

		cart.setItems(itemsSet);
		cart.setTotal(10 * 1 + 20 * 2);

		// Save User
		session.save(cart);
		session.save(item1);
		session.save(item2);

		session.getTransaction().commit();

		// Close Session
		HibernateUtil.shutdown();
	}
}
