package com.pradeep.hibernate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class ManyToManyRelation {
	public static void main(String[] args) {
		SessionFactory sessFact = null;
		Session session = null;
		try {
			sessFact=new Configuration().configure().buildSessionFactory();
			session=sessFact.openSession();
			Transaction tr = session.beginTransaction();
			//One author and many books
			Author a1=new Author();
			a1.setAuthorName("Sachin");
			Book b1=new Book();
			Book b2=new Book();
			Book b3=new Book();
			b1.setBookName("The First Pakistan Tour");
			b2.setBookName("Cricket And Life");
			b3.setBookName("The Unforgettable Don Bradman");
			Book b4=new Book();
			b4.setBookName("World Cup 2011 An Unforgettable Experience");
			Set<Book> bookSet=new HashSet<Book>();
			bookSet.add(b1);
			bookSet.add(b2);
			bookSet.add(b3);
			bookSet.add(b4);
			a1.setBooks(bookSet);
			
		Serializable authorId=session.save(a1);
		session.flush();
			
		
		
		
		//One Book Many Authors
			Book b5=new Book();
			b5.setBookName("Our Experiments With Cricket");
			Set<Author>authSet=new HashSet<Author>();
			Author a2=new Author();
			a2.setAuthorName("Zahir");
			Author a3=new Author();
			a3.setAuthorName("Harbhajan");
			Author a4=new Author();
			a4.setAuthorName("Viru");
			
			authSet.add(a1);
			authSet.add(a2);
			authSet.add(a3);
			authSet.add(a4);
			
			b5.setAuthors(authSet);
	      	Serializable bookId=session.save(b5);
			
	      	session.flush();
			

			//Get All books of One author
			Author a=(Author)session.get(Author.class,authorId);
			System.out.println(a.getAuthorName());
			Set<Book> books=a.getBooks();
			for(Book b : books){
				System.out.println(b.getBookName());
			}

		
			
			
			//Get all authors of one book
			Book bk=(Book)session.get(Book.class,bookId);
			System.out.println(bk.getBookName());
			Set<Author>auths=bk.getAuthors();
			for(Author at : auths){
				System.out.println(at.getAuthorName());	
			}
			
			
			tr.commit();
			System.out.println("Done");
		}
		catch(HibernateException He){
			System.out.println(He.getMessage());
		    He.printStackTrace();
		
		}
		finally{
			
			session.close();
		}
	}
}