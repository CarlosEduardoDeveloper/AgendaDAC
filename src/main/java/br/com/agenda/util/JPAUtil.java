package br.com.agenda.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("AgendaDAC");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
