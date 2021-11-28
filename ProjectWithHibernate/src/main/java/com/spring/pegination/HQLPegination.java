package com.spring.pegination;

import org.hibernate.query.*;

import com.spring.hibernate.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("from Student");

//		pagenation setting limits
		query.setFirstResult(0);
		query.setMaxResults(3);

		List<Student> list = query.list();

		for (Student student : list) {
			System.out.println(student);
		}

		session.close();
		factory.close();

	}
}
