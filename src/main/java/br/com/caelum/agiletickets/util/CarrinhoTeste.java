package br.com.caelum.agiletickets.util;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.agiletickets.models.Carrinho;
import br.com.caelum.agiletickets.models.Item;

public class CarrinhoTeste {
	@Test
	public void retornaValorDoProdutoQuandoCarrinhoSoTemUmItem() throws Exception {
		Carrinho carrinho = new Carrinho(new Item(10.0));
		double maiorValor  = carrinho.getProdutoDeMaiorValor();
		
		assertEquals(10.0, maiorValor, 0.001);
	}
	
	@Test
	public void retornaMaiorValorDeUmCarrinhoComMaisDeUmItem() throws Exception {
		Carrinho carrinho = new Carrinho(new Item(5.0));
		carrinho.adiciona(new Item(20.0));
		double maiorValor = carrinho.getProdutoDeMaiorValor();
		
		assertEquals(20.0, maiorValor, 0.001);
	}
}
