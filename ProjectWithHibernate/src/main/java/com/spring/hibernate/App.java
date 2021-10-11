package com.spring.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project started");

//      getting the object of sessionfactory / sessionfactory is an interface
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		System.out.println(factory);
//		System.out.println(factory.isClosed());

		Student student = new Student(3, "mamata", "delhi");

//		creating object of address
		Address address = new Address();
		address.setStreet("medabakkam");
		address.setCity("goa");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(123.3453);

//		reading image
		FileInputStream fis = new FileInputStream("src/main/java/pic.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);

//		1st way = opening a session
		/*
		 * Session session = factory.openSession(); session.save(student);
		 * session.beginTransaction().commit(); session.close();
		 */

//		2nd way
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(address);
		transaction.commit();
		session.close();
		System.out.println("done");
		factory.close();
	}
}
