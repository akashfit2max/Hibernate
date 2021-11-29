package com.spring.sqlqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class sqlqueries {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session s = factory.openSession();

		String query = "select * from mystudent";

		NativeQuery nq = s.createSQLQuery(query);

//		iits giving one column as an object array
		List<Object[]> list = nq.list();

		for (Object[] student : list) {
//			System.out.println(Arrays.toString(student));
			System.out.println(student[4] + " : " + student[3]);
		}

		s.close();

		factory.close();
	}

}
