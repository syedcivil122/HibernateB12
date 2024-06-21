package com.tejait.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.User;




public class UserTest {
	Session session=HibernateUtil.getSeesion();
	Transaction tx = session.beginTransaction();
public void saveEmployee() {
     User user = new User();
     user.setName("BBB");
     user.setAge(10000);
     

     session.persist(user);
     tx.commit();
}
@SuppressWarnings("unchecked")
public void getAll() {
	List<?> list=session.createQuery("from User").list();
	list.stream().forEach(System.out::println);

	Criteria crtr=session.createCriteria(User.class);
	List<User> list2=crtr.addOrder(Order.asc("age")).list();
	list2.stream().forEach(System.out::println);

}
public static void main(String[] args) {
	UserTest ut=new UserTest();
	ut.saveEmployee();
//	ut.getAll();
}
}
