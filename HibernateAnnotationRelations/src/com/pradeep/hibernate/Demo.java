package com.pradeep.hibernate;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
//Goups and Stories
public class Demo {
	//Group and Multiple Stories
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessFact = null;
		Session session = null;
		try {
			sessFact=new Configuration().configure().buildSessionFactory();
			
			session=sessFact.openSession();
			Transaction tr = session.beginTransaction();
			
			//Group g = (Group) session.load(Group.class, 1);
			
		    Group g1 = (Group) session.get(Group.class, 1);
			
		    System.out.println("Group loaded..");
		    
		 System.out.println(g1.getStories());
			
		    
			/*System.out.println("Group Name:" + g.getName());
		    List listStories = g.getStories();
		    Iterator storiesIter = listStories.iterator();
		    while(storiesIter.hasNext()) {
		    	Story story = (Story)storiesIter.next();
		    	System.out.println("Story Info:" + story.getInfo());
		    }		    
		    */tr.commit();
		}
		catch (HibernateException he){
			he.printStackTrace();
			
			System.out.println(he.getMessage());
		}
		finally{
			//Session close
			session.close();
			//SessionFactory close 
			sessFact.close();
		}
	}
}
