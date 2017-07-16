package org.it.discovery.training.hibernate.model;

import java.util.function.Function;

import org.hibernate.Session;
import org.it.discovery.training.hibernate.util.HibernateUtil;

public class BookStatistics {
	
	private Long booksCount;
	
	

	public BookStatistics(Long booksCount) {
		super();
		this.booksCount = booksCount;
	}

	public long getBooksCount() {
//		return query(session ->
//        session.createNamedQuery(Book.QUERY_FIND_ALL_BOOKS_COUNT, Long.class).getSingleResult());
		
		return this.booksCount;
           
	}

	public void setBooksCount(Long booksCount) {
		this.booksCount = booksCount;
	}
	
	public Long query(Function<Session, Long> function) {
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
	
	

}
