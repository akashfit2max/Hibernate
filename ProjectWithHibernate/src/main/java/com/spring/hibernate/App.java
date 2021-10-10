package com.spring.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Project started");

//      getting the object of session factory / session factory is an interface
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed());

	}
}
