package org.it.discovery.training.hibernate.bootstrap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
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
			
			Stream.generate(Hit::new).limit(5).forEach(book::addHit);
			// Persistent operations
			
			session.persist(book);
			
			System.out.println("bookId = " + book.getId());
			System.out.println("authorId = " + author.getId());
			
			Book book2 = new Book();
			book2.setName("Spring Data");
			//book2.setHits(Stream.generate(() -> new Hit(book2)).limit(5).collect(Collectors.toList()));
			Stream.generate(Hit::new).limit(5).forEach(book2::addHit);
			
			session.persist(book2);

			session.getTransaction().commit();
			
		
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Book> books = session.createQuery("from Book").getResultList();
			books.forEach(item -> item.getHits().forEach(hit -> System.out.println("Hit " + hit)));
			
			session.getTransaction().commit();
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

	}

}
