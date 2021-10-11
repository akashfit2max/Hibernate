package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
//		you can use both get and load
		Student student = session.get(Student.class, 3);
		System.out.println(student);

//		Address address = session.get(Address.class, 2);
//		System.out.println(address);
//
//		Address address1 = session.get(Address.class, 2);
//		System.out.println(address1);

	}

}
