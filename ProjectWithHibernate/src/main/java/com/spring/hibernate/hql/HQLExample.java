package com.spring.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.Student;

// hql using mystudent table 
public class HQLExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		opening session

		Session session = factory.openSession();
//		hql
//		syntax

//		String query = "from Student";
//		String query = "from Student where city='delhi'";

//		dynamic query
//		String query = "from Student where city=:x";

//		using alias
		String query = "from Student s where s.city=:x and s.name=:n";

		Query q = session.createQuery(query);
		q.setParameter("x", "delhi");
		q.setParameter("n", "Anshu");
		List<Student> students = q.list();

		for (Student student : students) {
			System.out.println(student.getName() + ":" + student.getCertificate().getCourse());
		}

//		deleting data
//		we need to open transaction
		Transaction tx = session.beginTransaction();
				
//		DELET QUERY
//		Query query2 = session.createQuery("Delete from Student s where s.city=:c");
//		query2.setParameter("c", "BBSR");
//		int deleted = query2.executeUpdate();
//		System.out.println("Deleted: " + deleted);

//		update query
//		Query query2 = session.createQuery("update Student s set s.city=:c where s.name=:n");
//		query2.setParameter("c", "goa");
//		query2.setParameter("n", "amrita");
//		int updated = query2.executeUpdate();
//		System.out.println("Updated data = " + updated);

//		tx.commit();

		
		
//		join column
		Query query3 = session.createQuery("select q.questionId, q.qstn, a.answer from Question q inner join q.answers as a");

//		 object of object array
		List<Object[]> list = query3.getResultList();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		
		session.close();

		
		factory.close();

	}

}
