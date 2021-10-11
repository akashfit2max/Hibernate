package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Student student = new Student();
		student.setId(123);
		student.setName("Akash kumar");
		student.setCity("BBSR");

		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("1 month");

		student.setCertificate(certificate);

		Student student1 = new Student();
		student1.setId(1345);
		student1.setName("Ashis kumar");
		student1.setCity("delhi");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("spring jdbc");
		certificate1.setDuration("1.5 month");

		student1.setCertificate(certificate1);

		session.save(student);
		session.save(student1);

		tx.commit();
		session.close();
		factory.close();

	}

}
