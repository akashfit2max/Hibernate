package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.map.Answer;
import com.spring.hibernate.map.Question;

public class cascadeExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		Question question = new Question();
		question.setQuestionId(198);
		question.setQstn("what is spring framework");

		Answer a1 = new Answer(987, "used in java");
		Answer a2 = new Answer(506, "second ans");
		Answer a3 = new Answer(412, "third answer");

		List<Answer> answers = new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);

		question.setAnswers(answers);

		Transaction tx = s.beginTransaction();

//		 as we have used cascade we dont need to explicitly save the answers it will automatically take the related class
		s.save(question);

		tx.commit();
		s.close();
		factory.close();
	}

}
