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
public class OneToManyRelation {
	//Group and Multiple Stories
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessFact = null;
		Session session = null;
		try {
			sessFact=new Configuration().configure().buildSessionFactory();
			
			session=sessFact.openSession();
			Transaction tr = session.beginTransaction();
			//Group Object
			Group group = new Group("Sports11");
			//Array list to hold stories
			ArrayList<Story> list = new ArrayList<Story>();
			
			// Create Stories
			Story s1 = new Story();
			s1.setInfo("The allegations");
			list.add(s1);
			// Create Stories
			Story s2 = new Story();
			s2.setInfo("The Cancer of Match Fixing");
			list.add(s2);
			// Create Stories
			Story s3 = new Story();
			s3.setInfo("The Master Blaster - Sachin");
			list.add(s3);
			//Add the list to Group object
			group.setStories(list);
		    //Save group
		 
			Serializable id=session.save(group);
		    session.flush();
		    //Load the group class
		    Group g = (Group) session.load(Group.class, id);
		    System.out.println("Group Name:" + g.getName());
		    List listStories = g.getStories();
		    Iterator storiesIter = listStories.iterator();
		    while(storiesIter.hasNext()) {
		    	Story story = (Story)storiesIter.next();
		    	System.out.println("Story Info:" + story.getInfo());
		    }		    
		    tr.commit();
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
