package com.tejait.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;

import com.tejait.hibernate.HibernateUtil;
import com.tejait.hibernate.model.Employee;

public class CriteriaTest {
	Session session= HibernateUtil.getSeesion();
	private boolean Employee;
	
	public void orderBy() {
		Criteria crtr = session.createCriteria(Employee.class);	
		//List<Employee> list=crtr.addOrder(Order.asc("salary")).list();
		List<Employee> list=crtr.addOrder(Order.desc("salary")).list();
			for(Employee emp:list) {
				System.out.println(emp);
			}
		
	}
	
	public void groupBy() {
		Criteria crtr = session.createCriteria(Employee.class);
		Long max=(Long) crtr.setProjection(Projections.max("salary")).uniqueResult();
		Long min=(Long) crtr.setProjection(Projections.min("salary")).uniqueResult();
		Double avg=(Double) crtr.setProjection(Projections.avg("salary")).uniqueResult();
		Long count=(Long) crtr.setProjection(Projections.count("salary")).uniqueResult();
		Long sum=(Long) crtr.setProjection(Projections.sum("salary")).uniqueResult();
		
	
		
		System.out.println("max salary is : "+max +
		                   ", min salary is : "+min +
		                   ", avg salary is : "+avg +
		                   ", count salary is : "+count +
		                   ", sum salary is : "+sum);
	}
	
	public void restictions() {
		Criteria crtr = session.createCriteria(Employee.class);
//		List<Employee> list = crtr.add(Restrictions.eq("dept", "java")).list();
//		List<Employee> list = crtr.add(Restrictions.lt("salary",25000L)).list();
//		List<Employee> list = crtr.add(Restrictions.gt("salary",20000L)).list();
//		List<Employee> list = crtr.add(Restrictions.between("salary",20000L,26000L)).list();
		List<Employee> list = crtr.add(Restrictions.like("name", "%s%")).list();
		
		for(Employee emp:list) {
			System.out.println("equal devp is :" + emp);
		}
	}
	
	public void restictionsLoop() {
		// Fetch list based on department 'java'
		Criteria crtr = session.createCriteria(Employee.class);
        List<Employee> list = crtr.add(Restrictions.eq("dept", "java")).list();
        
        // Fetch list based on salary less than 25000
        crtr = session.createCriteria(Employee.class); // reset criteria
        List<Employee> list1 = crtr.add(Restrictions.lt("salary", 25000L)).list();
        
        // Fetch list based on salary greater than 20000
        crtr = session.createCriteria(Employee.class); // reset criteria
        List<Employee> list2 = crtr.add(Restrictions.gt("salary", 20000L)).list();
        
        // Fetch list based on salary between 20000 and 26000
        crtr = session.createCriteria(Employee.class); // reset criteria
        List<Employee> list3 = crtr.add(Restrictions.between("salary", 20000L, 26000L)).list();
        
        // Fetch list based on name like '%s%'
        crtr = session.createCriteria(Employee.class); // reset criteria
        List<Employee> list4 = crtr.add(Restrictions.like("name", "%s%")).list();

        // Print the details of each list using for loop
        System.out.println("Employees in department 'java':");
        for (Employee emp : list) {
            System.out.println(emp);
        }

        System.out.println("\nEmployees with salary less than 25000:");
        for (Employee emp : list1) {
            System.out.println(emp);
        }

        System.out.println("\nEmployees with salary greater than 20000:");
        for (Employee emp : list2) {
            System.out.println(emp);
        }

        System.out.println("\nEmployees with salary between 20000 and 26000:");
        for (Employee emp : list3) {
            System.out.println(emp);
        }

        System.out.println("\nEmployees with name containing 's':");
        for (Employee emp : list4) {
            System.out.println(emp);
        }
		
	}
	

	
	public void inOperations() {
		Criteria crtr = session.createCriteria(Employee.class);
		List<String> deptlist = new ArrayList<String>();
		              deptlist.add("java");
		              deptlist.add("sql");
		              deptlist.add("python");
		              
		List<Employee> list=crtr.add(Restrictions.in("dept", deptlist)).list();
		               for(Employee emp:list) {
		            	   System.out.println(emp);
		               }
		            	   
	}
	
	public void andOr() {
		Criteria crtr = session.createCriteria(Employee.class);
		SimpleExpression lhs=Restrictions.eq("dept", "java");
		SimpleExpression rhs=Restrictions.gt("salary", 20000L);
		List<Employee> list=crtr.add(Restrictions.and(lhs, rhs)).list();
		
		for(Employee emp:list) {
			System.out.println("and Operator "+emp);
		}
		
		List<Employee> list1=crtr.add(Restrictions.or(lhs, rhs)).list();
		
		for(Employee emp:list1) {
			System.out.println("or Operator "+emp);
		}
	}
	
	public void sqlInjections(Long sal) { // dinamic sql query
//		Query<Employee> query = session.createQuery("from Employee where salary <26000L");
		Query<Employee> query = session.createQuery("from Employee where salary <:empsal");
		                query.setParameter("empsal", sal);
		List<Employee> list = query.list();
		  for(Employee emp:list){
			  System.out.println("Dynamic Query "+emp);
		  }
	}
	public static void main(String[] args) {
		CriteriaTest ct= new CriteriaTest();
		//ct.orderBy();
		//ct.groupBy();
		//ct.restictions();
		//ct.restictionsLoop();
		//ct.inOperations();
		//ct.andOr();
		ct.sqlInjections(26000L);
	}

}
