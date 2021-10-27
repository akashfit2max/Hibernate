package com.spring.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hibernate object states");
//		transient
//		persistent
//		detached
//		removed

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		System.out.println("example.................");

		Student student = new Student();
		student.setId(1234);
		student.setName("Akash");
		student.setCity("delhi");
		student.setCertificate(new Certificate("python", "2 months"));
//		state : transint

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
//		state : persistent -> db & session

		student.setName("Anshu");

		transaction.commit();
		session.close();

		student.setName("anrag");
		System.out.println(student);

		factory.close();
	}

}
