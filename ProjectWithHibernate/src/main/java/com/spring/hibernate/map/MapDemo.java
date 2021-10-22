package com.spring.hibernate.map;

import java.util.ArrayList;
import java.util.List;

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
		q1.setQuestionId(1221);
		q1.setQuestion("what is java ?");

//		creating answer
		Answer a1 = new Answer();
		a1.setAnswerId(111);
		a1.setAnswer("java is a programming language");
//		q1.setAnswer(a1);

//		creating question
//		Question q2 = new Question();
//		q2.setQuestionId(12);
//		q2.setQuestion("what is collection framework ?");

//		creating answer
		Answer a2 = new Answer();
		a2.setAnswerId(121);
//		a2.setAnswer("it is a api for storing collections");
		a2.setAnswer("java is open source");
//		q2.setAnswer(a2);

//		creating answer
		Answer a3 = new Answer();
		a3.setAnswerId(131);
		a3.setAnswer("java is very flixible");

//		making a list of answers
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);

//		adding the list in the question class
		q1.setAnswers(answers);

//		open session

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

//		session.save(q1);
//		session.save(q2);
//		session.save(a1);
//		session.save(a2);

//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);

		Question question = (Question) session.get(Question.class, 1221);
		System.out.println(question.getQuestion());

		for (Answer answer : question.getAnswers()) {
			System.out.println(answer.getAnswer());
		}

		tx.commit();
		session.close();
		factory.close();

	}

}
