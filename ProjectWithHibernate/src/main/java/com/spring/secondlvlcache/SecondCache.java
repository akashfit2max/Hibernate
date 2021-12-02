package com.spring.secondlvlcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.Student;

public class SecondCache {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session1 = factory.openSession();
//		first session
		Student student = session1.get(Student.class, 1345);
		System.out.println(student);
		session1.close();

//		2nd session

		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 1345);
		System.out.println(student2);
		session2.close();
		factory.close();

	}

}
