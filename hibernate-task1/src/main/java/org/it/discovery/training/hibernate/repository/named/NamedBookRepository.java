package org.it.discovery.training.hibernate.repository.named;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class NamedBookRepository implements BookRepository {

	@Override
	public List<Book> findAll() {
		Session s = null;
		
		try {
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.getTransaction().begin();
			
			return s.createNamedQuery(Book.QUERY_FIND_ALL, Book.class).getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			s.getTransaction().rollback();
			
			throw ex;
			
		} finally {
			if ( s != null) {
				s.getTransaction().commit();
			}
			
		}

	}

	@Override
	public List<Book> findWithName(String name) {

Session s = null;
		
		try {
			s = HibernateUtil.getSessionFactory().getCurrentSession();
			s.beginTransaction();
			TypedQuery<Book> query = s.createNamedQuery(Book.QUERY_FIND_ALL_WITH_NAME, Book.class);
			query.setParameter("name", name);
			return query.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			s.getTransaction().rollback();
			
			throw ex;
			
		} finally {
			if ( s != null) {
				s.getTransaction().commit();
			}
		}
		
	}

	@Override
	public List<Book> findWithHits() {

		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> findSortedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
