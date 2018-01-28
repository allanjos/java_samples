package br.com.olivum.java.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.olivum.java.hibernate.Product;

public class Main {
	private static SessionFactory sf;

	public static void main(String[] args) { 
		System.out.println("Starting");

		try {		
			sf = new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) {
			System.err.println("Error: " + ex);

			throw new ExceptionInInitializerError(ex);
		}

		// Register new product

		Date date = new Date();

		Product product = new Product();
		product.setName("Product " + date.getTime());

		Session ss = sf.openSession();

		Transaction transaction = ss.beginTransaction();

		// Saving objects to session

		ss.save(product);

		// Commit transaction

		transaction.commit();

		ss.close();

		sf.close();

		System.out.println("Finishing");
	}
}