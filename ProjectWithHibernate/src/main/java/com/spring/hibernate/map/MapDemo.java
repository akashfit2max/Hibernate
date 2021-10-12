package com.spring.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("performing one to one mapping");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		creating question
		Question q1 = new Question();
		q1.setQuestionId(11);
		q1.setQuestion("what is java ?");

//		creating answer
		Answer a1 = new Answer();
		a1.setAnswerId(111);
		a1.setAnswer("java is a programming language");
		q1.setAnswer(a1);

//		creating question
		Question q2 = new Question();
		q2.setQuestionId(12);
		q2.setQuestion("what is collection framework ?");

//		creating answer
		Answer a2 = new Answer();
		a2.setAnswerId(121);
		a2.setAnswer("it is a api for storing collections");
		q2.setAnswer(a2);

//		open session

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(q2);

		tx.commit();
		session.close();
		factory.close();

	}

}
