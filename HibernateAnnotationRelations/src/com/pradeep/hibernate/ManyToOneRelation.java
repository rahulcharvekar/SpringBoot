/**
 * 
 */
package com.pradeep.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneRelation {
	public static void main(String[] args) {
		SessionFactory sessFact = null;
		Session sess = null;
		try {
			sessFact=new Configuration().configure().buildSessionFactory();
			sess=sessFact.openSession();
			Story story = (Story)sess.load(Story.class, 1);
			
			System.out.println(story.getInfo());
			
			Group group = story.getGroup();
			System.out.println("Group Name: "+group.getName());
		}
		catch (HibernateException he){
			System.out.println(he.getMessage());
		}
		finally{
	 			sessFact.close();
			sess.close();
		}
	}
}