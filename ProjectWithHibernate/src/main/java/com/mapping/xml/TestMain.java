package com.mapping.xml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.spring.hibernate.Student;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		Person person = new Person(23, "ajay rana", "hyd");

		Transaction tx = s.beginTransaction();

//		s.save(person);

		String hql = "from Person";
		Query query = s.createQuery(hql);
		List<Person> list = query.list();
		
		for (Person person2 : list) {
			System.out.println(person2);
		}
	
		tx.commit();
		s.close();
		factory.close();

	}

}
