package com.tejait.hibernate.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Customer;
import com.tejait.hibernate.model.Iteams;

public class ManyToMany {

	
	public void saveCustomerIteams() {
		Session session=HibernateUtil.getSeesion();
		  Customer c1 = session.load(Customer.class, 1);
		  Customer c2 = session.load(Customer.class, 2);
		  
//		  List<Customer> list=new ArrayList<Customer>();
//		                 list.add(c1);
//		                 list.add(c2);
		  
		  List<Customer> list=Arrays.asList(c1,c2);
		  
		   Iteams i1 = new Iteams();
		          i1.setName("Bottle");
		          i1.setPrice(100);
		          i1.setCustom(list);
		          
		   Iteams i2 = new Iteams();
		          i2.setName("mobile");
		          i2.setPrice(12000);
		          i2.setCustom(list);    
		          
		   Iteams i3 = new Iteams();
		          i3.setName("laptop");
		          i3.setPrice(40000);
		          i3.setCustom(list);
		    
		   List<Iteams> items=Arrays.asList(i1,i2,i3);
		   
		   for(Iteams item:items) {
			   session.save(item);
		   }
		   
		   session.beginTransaction().commit();
	}
	
	
	public void getCustomersItems() {
		Session session=HibernateUtil.getSeesion();
		
//		Query<Customer> query = session.createQuery("select distinct c from Customer c join fetch c.items", Customer.class);
//        List<Customer> customers = query.getResultList();
//        for (Customer customer : customers) {
//            System.out.println("Customer: " + customer.getCname());
//            for (Iteams item : customer.getItms()) {
//                System.out.println("  Item: " + item.getName() + ", Price: " + item.getPrice());
//            }
//        }
		List<Iteams> list=session.createQuery("from Iteams").getResultList();
		for(Iteams item:list) {
			for(Customer customer:item.getCustom()) {
				System.out.println("Get ItemId: "+item.getIid()+" |"+" Get Cid: "+customer.getCid());
			}
		}
	}
	
	public void getAllItems() {
		Session session=HibernateUtil.getSeesion();
		
		List<Iteams> list=session.createQuery("from Iteams").list();
		for(Iteams item:list) {
			System.out.println(item.getIid()+ " "+item.getName()+"  "+item.getPrice());
			for(Customer customer:item.getCustom()) {
				System.out.println(customer.getCid()+ "  "+customer.getCname());
			}
		}
	}
	public static void main(String[] args) {
		ManyToMany mt = new ManyToMany();
//		mt.saveCustomerIteams();
//		mt.getCustomersItems();
		mt.getAllItems();
	}

}
