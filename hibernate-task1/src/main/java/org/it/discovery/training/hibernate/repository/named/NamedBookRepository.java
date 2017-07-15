package org.it.discovery.training.hibernate.repository.named;

import java.util.List;
import java.util.function.Function;

import org.hibernate.Session;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class NamedBookRepository implements BookRepository {
	
	 @Override
     public List<Book> findAll() {
        return query(session -> session.createNamedQuery(Book.QUERY_FIND_ALL, Book.class).setCacheable(true).getResultList());
     }

	 public List<Book> query(Function<Session, List<Book>> function) {
         Session session = null;
         try {
             session = HibernateUtil.getSessionFactory().getCurrentSession();
             session.beginTransaction();
 
             return function.apply(session);
 
         } catch (Exception ex) {
             ex.printStackTrace();
             session.getTransaction().rollback();
             throw new RuntimeException(ex);
         } finally {
            if (session != null) {
                 session.getTransaction().commit();
             }
         }
     }
	

	@Override
	public List<Book> findWithName(String name) {
		return query(session ->
		                session.createNamedQuery(Book.QUERY_FIND_ALL_WITH_NAME, Book.class)
		                        .setParameter("name", name).getResultList());
	}

	@Override
	public List<Book> findWithHits() {

		return query(session ->
        session.createNamedQuery(Book.QUERY_FIND_WITH_HITS, Book.class).getResultList());
	}
	
	@Override
	public List<Book> findWithoutHits() {

		return query(session ->
        session.createNamedQuery(Book.QUERY_FIND_WITHOUT_HITS, Book.class).getResultList());
	}

	@Override
	public List<Book> findWithMorePages(int pages) {

		return null;
	}

	@Override
	public List<Book> searchBooks(String name, int pages) {
		return null;
	}

	@Override
	public int findTotalPages() {
		return 0;
	}

	@Override
	public List<Book> findSortedBooks() {
		return null;
	}

}
