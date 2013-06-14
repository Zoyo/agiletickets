package br.com.caelum.agiletickets.persistencia;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import br.com.caelum.agiletickets.models.Sessao;

@Ignore
public class JPAEspetaculoDaoTest extends DataBaseTest{

	@Test
	public void testProximasSessoes() {

		em.getTransaction().begin();
		
		new Sessao();
		fail("Not yet implemented");
	}

}
