package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.spring.hibernate.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		Criteria c = s.createCriteria(Student.class);
		
//		adding restriction
		
		c.add(Restrictions.eq("city", "lko"));
		
		List<Student> students = c.list();

		for (Student student : students) {
			System.out.println(student);
		}	

		s.close();

		factory.close();
	}

}
