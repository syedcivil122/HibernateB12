package com.tejait.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Employee;

public class EmployeeTest1 {
	public void saveEmployee() {
		Session session = HibernateUtil.getSeesion();
		
		Employee e1 = new Employee();
			     e1.setName("sonu");
			     e1.setAge(21);
			     e1.setSalary(29000);
			     e1.setDept("hql");
			     
			     
			     session.save(e1);   // insert into employee(name,age,salary,dept) values();
		Transaction tx = session.beginTransaction();  // we are initilate the transaction
		tx.commit();	
				
			}

	public void updateEmployee() {
		Session session = HibernateUtil.getSeesion();
		
		Employee e1 = new Employee();
		         e1.setEid(7);
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
		         e1.setEid(2);
			     
			     session.delete(e1);   // insert into employee(name,age,salary,dept) values();
		Transaction tx = session.beginTransaction();  // we are initilate the transaction
		tx.commit();	
				
			}

	public void getEmployeeId() {
		Session session=HibernateUtil.getSeesion();
//		Employee emp=session.load(Employee.class, 1);
		Employee emp=session.get(Employee.class,7);
		System.out.println(emp);
//		System.out.println("Employee name: "+emp.getName()+" Employee Age: "+emp.get);
		
	}
	
	public void getAllEmployees() {
		Session session=HibernateUtil.getSeesion();
		
		Query<Employee> query=session.createQuery("from Employee ");
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
	public void findmaxSalary() {
		Session session=HibernateUtil.getSeesion();
		Object maxSalary=session.createQuery("select max(salary) from Employee").uniqueResult();
		System.out.println(maxSalary);
	}
	
	public void findMinSalary() {
		Session session=HibernateUtil.getSeesion();
		Object minSalary = session.createQuery("select min(salary) from Employee").uniqueResult();
		System.out.println(minSalary);
	}
	
	public void groupby() {
		Session session=HibernateUtil.getSeesion();
		List<Object[]> list=session.createQuery("select dept,count(*) from Employee group by dept").list();
		for(Object[] obj:list) {
		System.out.println(obj[0]+" "+obj[1]);
		}
	}
	
	public void seclectData() {
		Session session=HibernateUtil.getSeesion();
		List<Employee> list=session.createQuery("from Employee where eid=eid").list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	public void orderbyAsc() {
		Session session=HibernateUtil.getSeesion();
		List<Employee> list=session.createQuery("from Employee order by salary asc").list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	public void orderbyDesc() {
		Session session=HibernateUtil.getSeesion();
		List<Employee> list=session.createQuery("from Employee order by salary desc").list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	public void getAnd() {
		Session session=HibernateUtil.getSeesion ();
		Query<Employee> query=session.createQuery("from Employee where dept= dept and age=25");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
		
	}
	
	public void getAndAgeGreater() {
		Session session=HibernateUtil.getSeesion();
		Query<Employee> query=session.createQuery("from Employee where dept='java' and age>20");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	public void getOr() {
		Session session = HibernateUtil.getSeesion();
		List<Employee> list=session.createQuery("from Employee where dept='java' or dept='.net'").list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
		}
	
	public void getBetwwen() {
		Session session = HibernateUtil.getSeesion();
		List<Employee> list=session.createQuery("from Employee where age between 22 and 24").list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	public void getLike() {
		Session session = HibernateUtil.getSeesion();
		List<Employee> list=session.createQuery("from Employee where name like '%s%'").list();
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	
	public static void main(String[] args) {
		EmployeeTest1 et = new EmployeeTest1();
//		et.saveEmployee();
//		et.updateEmployee();
	//	et.deleteEmployee();
//		et.getEmployeeId();
//		et.getAllEmployees();
//		et.findByDept();
//		et.findmaxSalary();
//		et.groupby();
//		et.findMinSalary();
//		et.seclectData();
//		et.getAnd();
//		et.getAndAgeGreater();
//		et.getOr();
//		et.getBetwwen();
//		et.getLike();
//		et.orderbyAsc();
		et.orderbyDesc();
		
		
	}
}
