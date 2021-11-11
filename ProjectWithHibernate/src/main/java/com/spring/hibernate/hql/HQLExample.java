package com.spring.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.states.Student;

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
		Query query2 = session.createQuery("Delete from Student s where s.city=:c");
		query2.setParameter("c", "BBSR");
		int deleted = query2.executeUpdate();
		System.out.println("Deleted: " + deleted);
		tx.commit();
		session.close();

		factory.close();

	}

}
