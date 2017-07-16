package org.it.discovery.training.jpa.bootstrap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAStarter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			em.getTransaction().commit();
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
