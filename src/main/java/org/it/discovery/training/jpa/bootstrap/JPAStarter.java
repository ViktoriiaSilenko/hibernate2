package org.it.discovery.training.jpa.bootstrap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.it.discovery.training.hibernate.model.Address;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.jpa.JPAPublisherRepository;

public class JPAStarter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			em.getTransaction().commit();
			
			Publisher publisher = new Publisher();
			publisher.setName("aa");
			
			Address a = new Address();
			a.setCity("city");
			a.setStreet("street");
			
			publisher.setAddress(a);
			
			PublisherRepository repository = new JPAPublisherRepository();
			repository.save(publisher);
			
			repository.delete(publisher.getId());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if (em != null) {
				em.getTransaction().rollback();
			}
		} finally {
			 em.close();
			 emf.close();
		}

	}

}
