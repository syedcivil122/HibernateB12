package com.tejait.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Student;

public class StudentTest {

	public void saveStudent() {
		Session session = HibernateUtil.getSeesion();
		
		Student e1 = new Student();
			     e1.setName("semi");
			     e1.setAge(21);
			     e1.setSalary(25000);
			     e1.setDept("java");
			     
			     
			     session.save(e1);   // insert into employee(name,age,salary,dept) values();
		Transaction tx = session.beginTransaction();  // we are initilate the transaction
		tx.commit();	
				
			}

	public void updateStudent() {
		Session session = HibernateUtil.getSeesion();
		
		Student e1 = new Student();
		         e1.setEid(4);
			     e1.setName("semi");
			     e1.setAge(21);
			     e1.setSalary(25000);
			     e1.setDept("python");
			     
			     session.update( e1);   // insert into employee(name,age,salary,dept) values();
		Transaction tx = session.beginTransaction();  // we are initilate the transaction
		tx.commit();	
				
			}

	public void deleteStudent() {
		Session session = HibernateUtil.getSeesion();
		
		Student e1 = new Student();
		         e1.setEid(4);
			     
			     session.delete(e1);   // insert into employee(name,age,salary,dept) values();
		Transaction tx = session.beginTransaction();  // we are initilate the transaction
		tx.commit();	
				
			}

		public static void main(String[] args) {
		StudentTest st = new StudentTest();
		st.saveStudent();
//		st.updateStudent();
//		st.deleteStudent();
	}
	}


