package com.tejait.hibernate.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Person;

public class PersonTest {

	Session session=HibernateUtil.getSeesion();
	
	public void savePerson() {
		Person p1=new Person();      // Transient
		       p1.setName("AAA");
		       p1.setAge(22);
		       
		       session.save(p1);
		Transaction tx= session.beginTransaction();
		            tx.commit();
		            
		            session.close();  // detached
	}

	public void saveAndPersist() {
		Person p1=new Person();
		       p1.setName("DDD");
		       p1.setAge(23);
		       
		       session.persist(p1);
		  Transaction tx=session.beginTransaction();
		              tx.commit();
		              
//		   Serializable id =session.save(p1);
//		       System.out.println(id);
		              session.close();
		              
	}
	
	public void saveOrUpdate() {
		Session session=HibernateUtil.getSeesion();
		
		Person p1= new Person();
//		       p1.setPid(13);   // when we update the data that time we use Id value
		       p1.setName("RD");
		       p1.setAge(21);
		       
		       session.saveOrUpdate(p1);
		    Transaction tx=session.beginTransaction();
		    tx.commit();
		    
		    session.close();
	}
	
	public void evictAndClear() {
		
		Person p1= new Person();
//	       p1.setPid(13);   // when we update the data that time we use Id value
	       p1.setName("RWQr");
	       p1.setAge(23);
	       
	       session.save(p1);
	       session.evict(p1);// before commit delete the data
	       
	       Transaction tx=session.beginTransaction();
		    tx.commit();
//		    session.evict(p1);  after commit delete the data
	       
	       Person p2= new Person();
//	       p1.setPid(13);   // when we update the data that time we use Id value
	       p1.setName("RWQr123");
	       p1.setAge(23);
	       
	       session.save(p2);
	       session.clear();  
	       
	       
	    Transaction tx1=session.beginTransaction();
	    tx1.commit();
//	    session.clear();  // after commit clear the data
	    
	    session.close();
	}
	
	public void loadAndGet() {
		
		Person load=session.load(Person.class, 12);
		System.out.println("========== Using Load ==========");
		System.out.println(" using load "+ load);
		
		Person get=session.get(Person.class, 13);
		System.out.println("======== using Get ===========");
		System.out.println(" Using Get");
	}
	
	public static void main(String[] args) {
		PersonTest pt = new PersonTest();
//		pt.savePerson();
//		pt.saveAndPersist();
//		pt.saveOrUpdate();
		pt.evictAndClear();
//		pt.loadAndGet();
	}
}
