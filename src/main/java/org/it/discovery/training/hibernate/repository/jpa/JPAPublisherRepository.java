package org.it.discovery.training.hibernate.repository.jpa;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;


public class JPAPublisherRepository implements PublisherRepository, AutoCloseable {
	
	private final EntityManagerFactory emf;
	
	public JPAPublisherRepository() {
		emf = Persistence.createEntityManagerFactory("library");
	}
	
	private void accept(Consumer<EntityManager> consumer) { // to save or delete data
		EntityManager em = null;
        try {
        	
        	em = emf.createEntityManager();
        	em.getTransaction().begin();
          

        	consumer.accept(em);

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException(ex);
        } finally {
           if (em != null) {
                em.getTransaction().commit();
            }
        }
    }
	
	
	public <T> T execute(Function<EntityManager, T> function) {
		EntityManager em = null;
        try {
        	
        	em = emf.createEntityManager();
        	em.getTransaction().begin();

            return function.apply(em);

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException(ex);
        } finally {
           if (em != null) {
                em.getTransaction().commit();
            }
        }
    }

	@Override
	public void save(Publisher publisher) {
		
		accept(em -> em.persist(publisher));
	}

	@Override
	public void saveAll(List<Publisher> publishers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int publisherId) {
	
		 accept(em -> Optional.ofNullable(em.find(Publisher.class, publisherId))
		                         .ifPresent(p -> em.remove(p)));
	}

	@Override
	public Publisher findById(int publisher) {
		return execute(em -> em.find(Publisher.class, publisher));
	}

	@Override
	public void close() throws Exception {
		emf.close();
		
	}

}
