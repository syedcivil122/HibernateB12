package com.tejait.hibernate.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Customer;
import com.tejait.hibernate.model.Orders;


public class OneToMany {

	public void saveCustomerOrders() {
		Session session=HibernateUtil.getSeesion();
		Customer c1= session.load(Customer.class, 2);
		
		Orders o1 = new Orders();
		       o1.setOrdNum(123456L);
		       Date d=new Date();
		       o1.setOrdDate(d);
		       o1.setCus(c1);
		       
		Orders o2 = new Orders();
		       o2.setOrdNum(234567L);
		       o2.setOrdDate(new Date());
		       o2.setCus(c1);
		       
		       session.save(o1);
		       session.save(o2);
	   Transaction  tx= session.beginTransaction();
	                tx.commit();
	                
		
	}
	
	public void getOders() {
		Session session=HibernateUtil.getSeesion();
		
		List<Orders> list= session.createQuery("from Orders").list();
		for(Orders o1:list) {
			System.out.println("Get CustomerName: "+ o1.getCus().getCname()+ " Get OrderNum: "+o1.getOrdNum() + " Get OrderDate: "+o1.getOrdDate());
		}
	}
	
	public static void main(String[] args) {
		OneToMany ot = new OneToMany();
		
//		ot.saveCustomerOrders();
		ot.getOders();
	}

}
