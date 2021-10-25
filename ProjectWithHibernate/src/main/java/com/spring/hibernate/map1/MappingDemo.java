package com.spring.hibernate.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Many to many mapping");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//		creating 2 employee
		Emp e1 = new Emp();
		Emp e2 = new Emp();

//		setting data

		e1.seteId(21);
		e1.setEmpName("akash ks");

		e2.seteId(22);
		e2.setEmpName("ashish ks");

//		creating 2 projects
		Project p1 = new Project();
		Project p2 = new Project();

//		setting data
		p1.setpId(31);
		p1.setProjectName("chatbot");

		p2.setpId(33);
		p2.setProjectName("boot");

		List<Project> pList = new ArrayList<Project>();
		List<Emp> eList = new ArrayList<Emp>();

		pList.add(p1);
		pList.add(p2);

		eList.add(e1);
		eList.add(e2);

		e1.setProjects(pList);
		p2.setEmps(eList);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		tx.commit();
		session.close();
		sessionFactory.close();
	}

}
