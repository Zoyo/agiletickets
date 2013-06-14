package br.com.caelum.agiletickets.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;

public class DataBaseTest {
	
	protected EntityManager em;

	@BeforeClass
	public void test() {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("shibataNoBalde");
		em = managerFactory.createEntityManager();		
	}

}
