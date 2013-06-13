package br.com.caelum.agiletickets.models;

public class Item {
	private double valor;
	
	public Item(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
