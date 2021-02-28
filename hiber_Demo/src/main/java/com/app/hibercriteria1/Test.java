package com.app.hibercriteria1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {
	
	private static SessionFactory sessionFactory=null;
	
	static {
		
		
		Configuration configuration =new Configuration().configure();
		
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry=registry.build();
		sessionFactory =configuration.buildSessionFactory(serviceRegistry);
		
	}
	
	Scanner sc =new Scanner(System.in);
	
	public void insert() {
		
		Session session = sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		Boolean flag =Boolean.FALSE;
		
		System.out.println("how many person do u want to insert");
		int noofperson=sc.nextInt();
		
		for(int i=0;i<noofperson;i++) {
			
			Worker person=new Worker();
			System.out.println("Enter name");
			person.setName(sc.next());
			System.out.println("Enter mobile");
			person.setMobile(sc.next());
			System.out.println("Enter salary");
			person.setSalary(sc.nextDouble());
			
			session.save(person);
			
		}
		tx.commit();
		flag = tx.wasCommitted();
		
		if(flag) {
			
			System.out.println("success");
		}else
			System.out.println("failure");
		
		session.close();
		
	}
	
	public void selectQuery() {
		
		
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Worker.class);
		List<Worker>list=criteria.list();
		list.forEach(System.out::println);
		
	}
	
	public void updateWorker() {
		
		selectQuery();
		
		System.out.println("select worker id for update");
		int id=sc.nextInt();
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
	    Worker worker= (Worker)session.get(Worker.class, id);
	    System.out.println("Enter name");
		worker.setName(sc.next());
		
		session.update(worker);
		
		tx.commit();
		tx.wasCommitted();
		
		System.out.println("update successfully");
		
	}
	
	public void deleteWorker() {
		
		selectQuery();
		System.out.println("enter id for delete record");
		int id=sc.nextInt();
		
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Worker worker=(Worker)session.get(Worker.class, id);
		
		session.delete(worker);
		tx.commit();
		tx.wasCommitted();
		
		System.out.println("delete successfully");
		
		
		selectQuery();
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Test test =new Test();
		
		test.insert();
		//test.selectQuery();
		//test.updateWorker();
		//  test.deleteWorker();
		
	}
	
	
	
	
	
	
	
	

}
