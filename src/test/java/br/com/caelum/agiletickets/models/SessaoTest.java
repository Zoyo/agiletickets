package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

	private Sessao sessao;

	@Before
	public void inicializa() {
		sessao = new Sessao();
	}
	
	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		sessao.setTotalIngressos(2);
        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		sessao.setTotalIngressos(2);
		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveVenderTodosOsIngressos(){
		sessao.setTotalIngressos(5);
		assertTrue(sessao.podeReservar(5));
	}
	
	@Test
	public void naoDeveReservarQuantidadeNegativa(){
		sessao.setTotalIngressos(5);
		assertFalse(sessao.podeReservar(-3));
	}
	
	@Test
	public void naoDeveReservarQuantidadeZero(){
		sessao.setTotalIngressos(5);
		assertFalse(sessao.podeReservar(0));
	}
	
}
