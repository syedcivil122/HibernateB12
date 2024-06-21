package com.tejait.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Employee;

public class EmployeeTest {

public void saveEmployee() {
	Session session = HibernateUtil.getSeesion();
	
	Employee e1 = new Employee();
		     e1.setName("semi");
		     e1.setAge(21);
		     e1.setSalary(25000);
		     e1.setDept("java");
		     
		     
		     session.save(e1);   // insert into employee(name,age,salary,dept) values();
	Transaction tx = session.beginTransaction();  // we are initilate the transaction
	tx.commit();	
			
		}

public void updateEmployee() {
	Session session = HibernateUtil.getSeesion();
	
	Employee e1 = new Employee();
	         e1.setEid(2);
		     e1.setName("semi");
		     e1.setAge(21);
		     e1.setSalary(25000);
		     e1.setDept("python");
		     
		     session.update( e1);   // insert into employee(name,age,salary,dept) values();
	Transaction tx = session.beginTransaction();  // we are initilate the transaction
	tx.commit();	
			
		}

public void deleteEmployee() {
	Session session = HibernateUtil.getSeesion();
	
	Employee e1 = new Employee();
	         e1.setEid(3);
		     
		     session.delete(e1);   // insert into employee(name,age,salary,dept) values();
	Transaction tx = session.beginTransaction();  // we are initilate the transaction
	tx.commit();	
			
		}


public void getEmpolyeeId() {
	Session session=HibernateUtil.getSeesion();
	Employee emp=session.load(Employee.class, 2);
//	Employee emp1=session.get(Employee.class,5);
	System.out.println(emp);
//	System.out.println("Employee name: "+emp.getName()+" Employee Age: "+emp.get);
	
}

public void getAllEmployees() {
	Session session=HibernateUtil.getSeesion();
	
	Query<Employee> query=session.createQuery("from Empolyee");
	List<Employee> list=query.list();
	
	for(Employee emp:list) {
		System.out.println(emp);
	}
}

public void findByDept() {
	Session session=HibernateUtil.getSeesion();
	List<Employee> list=session.createQuery("from Employee where dept='java'").list();
	for(Employee emp:list) {
		System.out.println(emp);
	}
}
	public void finMaxSalary() {
		Session session=HibernateUtil.getSeesion();
		Object maxSalary = (Object)session.createQuery("select max(salary) from Employee").uniqueResult();
		System.out.println(maxSalary);
	}
	
	public void groupby() {
		Session session=HibernateUtil.getSeesion();
		List<Object[]> list=session.createQuery("select dept,count(*) from Employee group by dept").list();
		for(Object[] obj:list) {
		System.out.println(obj[0]+" "+obj[1]);
		}
	}

public static void main(String[] args) {
	EmployeeTest et = new EmployeeTest();
//	et.saveEmployee();
//	et.updateEmployee();
//	et.deleteEmployee();
//	et.getAllEmployees();
//	et.getEmpolyeeId();
//	et.findByDept();
	et.finMaxSalary();
	
}
}
