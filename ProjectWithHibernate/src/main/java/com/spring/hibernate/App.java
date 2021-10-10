package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Project started");

//      getting the object of sessionfactory / sessionfactory is an interface
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		System.out.println(factory);
//		System.out.println(factory.isClosed());

		Student student = new Student(2, "ashish", "delhi");

//		1st way = opening a session
		/*
		 * Session session = factory.openSession(); session.save(student);
		 * session.beginTransaction().commit(); session.close();
		 */

//		2nd way
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();

	}
}
