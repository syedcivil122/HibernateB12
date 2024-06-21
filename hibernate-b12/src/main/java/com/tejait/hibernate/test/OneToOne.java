package com.tejait.hibernate.test;

import java.util.List;

import org.hibernate.Transaction;

import com.mysql.cj.Session;
import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Customer;
import com.tejait.hibernate.model.Wallet;

public class OneToOne {

	public void saveCustomerWallet() {
		org.hibernate.Session session= HibernateUtil.getSeesion();
		
		Customer c1=new Customer();
		         c1.setCname("Karim");
		         c1.setCity("Kuwait");
		         c1.setMobileNum(3457556);
		         
		         
		Wallet w1=new Wallet();
		       w1.setBalance(20000);
		       w1.setCust(c1);
		       
		      session.save(c1);
		      session.save(w1);
		      
	Transaction tx = session.beginTransaction();
	tx.commit();
		       
		
	}
	
	public void updateCustomerWallet() {
		org.hibernate.Session session= HibernateUtil.getSeesion();
		
		Customer c1=new Customer();
		         c1.setCid(2);
		         c1.setCname("Karimulla");
		         c1.setCity("Rodha");
		         c1.setMobileNum(3457556);
		         
		         
		Wallet w1=new Wallet();
		       w1.setWid(2);
		       w1.setBalance(25000);
		       w1.setCust(c1);
		       
		      session.update(c1);;
		      session.update(w1);
		      
	Transaction tx = session.beginTransaction();
	tx.commit();
		       
		
	}
	
	public void deleteCustomerWallet() {
		org.hibernate.Session session= HibernateUtil.getSeesion();
		
		Customer c1=new Customer();
		         c1.setCid(3);
		         c1.setCname("Karim");
		         c1.setCity("Kuwait");
		         c1.setMobileNum(3457556);
		         
		         
		Wallet w1=new Wallet();
		       w1.setWid(3);
		       w1.setBalance(20000);
		       w1.setCust(c1);
		       
		      session.delete(c1);
		      session.delete(w1);
		      
	Transaction tx = session.beginTransaction();
	tx.commit();
		       
		
	}
	
	
	
	public void getCustomerWallet() {
		org.hibernate.Session session = HibernateUtil.getSeesion();
		List<Customer> list=session.createQuery("from Customer").list();
		
		for(Customer c:list) {
			System.out.println("Get Cid: "+ c.getCid()+" Get Cname " +c.getCname()+" Get City "+c.getCity() + " Get Mobile "+c.getMobileNum()+
					            "Get Wal "+c.getWal().getBalance());
			
		}
	}
	
	public static void main(String[] args) {
		OneToOne ot=new OneToOne();
//		ot.saveCustomerWallet();
//		ot.getCustomerWallet();
//		ot.updateCustomerWallet();
		ot.deleteCustomerWallet();
	}

}
