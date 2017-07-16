package org.it.discovery.training.spring.bootstrap;

import org.it.discovery.training.spring.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarter {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(
				PersistenceConfig.class)) {
			Starter server = context.getBean(Starter.class);
			server.start();		
		}
	}

}
