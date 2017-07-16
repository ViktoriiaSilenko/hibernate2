package org.it.discovery.training.hibernate.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.it.discovery.training.hibernate.model.Publisher;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private static SessionFactory buildSessionFactory() {
		try {
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(loadProperties()).build();

			MetadataSources sources = new MetadataSources(registry);

			sources.addAnnotatedClass(Publisher.class);

			return sources.buildMetadata().buildSessionFactory();
		} catch (HibernateException ex) {
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static Properties loadProperties() {
		try {

			InputStream in = HibernateUtil.class.getClassLoader().getResourceAsStream("application.properties");
			Properties properties = new Properties();
			properties.load(in);

			return properties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}