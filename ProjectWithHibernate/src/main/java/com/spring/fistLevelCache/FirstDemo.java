package com.spring.fistLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.Student;

public class FirstDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		Student student = s.get(Student.class, 1345);
		System.out.println(student);
		
		
//		first lvl cache
//		save this student data in the cache memory
		Student student2 = s.get(Student.class, 1345);
		System.out.println(student2);

		factory.close();
	}

}
