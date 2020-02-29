package com.pradeep.hibernate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class OneToOneRelation {
	public static void main(String[] args) {
		SessionFactory sessFact=null;
		Session sess=null;
		try{
			
			
			
			sessFact=new Configuration().configure().buildSessionFactory();
			
			sess=sessFact.openSession();
			
			System.out.println("sess:"+sess);
			//Create Customer Object
			Employee emp = new Employee();		
			emp.setId(2);
			emp.setName("Pradeep");
			
			//Create address object
			EmployeeAddress a1=new EmployeeAddress();
			a1.setCountry("USA");
			a1.setAddress("Delhi");
			a1.setEmpid(emp.getId());
			
			emp.setAddress(a1);
			 
			a1.setEmployee(emp);
			
			
			Transaction tr = sess.beginTransaction();
			sess.save(emp);
			sess.flush();
			tr.commit();
			Query query=sess.createQuery("from Employee");
			List<Employee>list=query.list();
			for(Employee e : list){
				System.out.println(e.getId()+" : "+e.getName()+" : "+e.getAddress().getAddress()+" : "+
			e.getAddress().getCountry());
			}
			System.out.println("Done");
		}
		catch (HibernateException he){
			System.out.println(he.getMessage());
		he.printStackTrace();
		
		}
		finally{
			//SessionFactory close 
			sessFact.close();
			//Session close
			sess.close();
		}
	}
}
