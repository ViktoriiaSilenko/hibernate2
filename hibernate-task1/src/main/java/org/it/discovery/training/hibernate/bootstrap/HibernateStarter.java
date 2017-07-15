package org.it.discovery.training.hibernate.bootstrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class HibernateStarter {

	public static void main(String[] args) {
		Session session = null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {

			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Person author = new Person();
			author.setName("Test");
			
			Book book = new Book();
			book.setName("Test book");
			book.setAuthor(author);
			book.setYear(2017);
			// Persistent operations
			
			session.persist(book);

			session.getTransaction().commit();
			
			System.out.println("bookId = " + book.getId());
			System.out.println("authorId = " + author.getId());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

	}

}
