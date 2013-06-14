package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	@Test
	public void criaPeloMenosUmaSessao() {
		Espetaculo espetaculo = new Espetaculo();
		DateTime dateTime = new DateTime();
		List<Sessao> sessoes = espetaculo.criaSessoes(dateTime.toLocalDate(),
				dateTime.toLocalDate(), dateTime.toLocalTime(),
				Periodicidade.DIARIA);
		int qtd = sessoes.size();
		assertTrue(qtd > 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarSessoesEmDatasPassadas() {
		Espetaculo espetaculo = new Espetaculo();
		DateTime dateTime = new DateTime().minusDays(5);
		espetaculo.criaSessoes(dateTime.toLocalDate(), dateTime.toLocalDate(),
				null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarSessoesComInicioMenorQueFim() {
		Espetaculo espetaculo = new Espetaculo();
		DateTime data = new DateTime();
		DateTime plusDays = data.plusDays(5);
		espetaculo.criaSessoes(plusDays.toLocalDate(), data.toLocalDate(),
				null, null);
	}

	@Test
	public void deveCriarSessoesComIntervaloDiario() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		DateTime inicio = new DateTime();
		DateTime fim = inicio.plusDays(5);

		espetaculo.criaSessoes(inicio.toLocalDate(), fim.toLocalDate(),
				inicio.toLocalTime(), Periodicidade.DIARIA);

		int numeroDeSessoes = espetaculo.getSessoes().size();

		assertEquals(6, numeroDeSessoes);
	}

	@Test
	public void deveCriarUmaSessaoEmUmIntervaloSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();

		DateTime inicio = new DateTime();
		DateTime fim = inicio.plusDays(5);

		espetaculo.criaSessoes(inicio.toLocalDate(), fim.toLocalDate(),
				inicio.toLocalTime(), Periodicidade.SEMANAL);

		int numeroDeSessoes = espetaculo.getSessoes().size();

		assertEquals(1, numeroDeSessoes);

	}
	
	@Test
	public void deveValidarOConteudoDaSessaoDiario() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		
		DateTime inicio = new DateTime();
		DateTime fim = inicio.plusDays(2);

		espetaculo.criaSessoes(inicio.toLocalDate(), fim.toLocalDate(),
				inicio.toLocalTime(), Periodicidade.DIARIA);

		Sessao s1 = new Sessao();
		s1.setInicio(new DateTime());
		Sessao s2 = new Sessao();
		s2.setInicio(new DateTime().plusDays(1));
		Sessao s3 = new Sessao();
		s3.setInicio(new DateTime().plusDays(2));
		
		Assert.assertThat(espetaculo.getSessoes(), Matchers.contains(s1, s2, s3));
		
		
	}
	
	

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
}
