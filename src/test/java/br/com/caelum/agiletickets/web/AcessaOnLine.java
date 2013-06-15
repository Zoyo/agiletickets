package br.com.caelum.agiletickets.web;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AcessaOnLine {
	@Test
	public void verificaSenhaInvalida() {
		WebDriver navegador = new FirefoxDriver();
		navegador.get("http://online.caelum.com.br");
		navegador.findElement(By.name("email")).sendKeys("email@email.com.br");
		navegador.findElement(By.name("password")).sendKeys("shibataNoBalde");
//		navegador.findElement(By.className("form-login")).submit();
		navegador.findElement(By.className("login")).findElement(By.cssSelector("[value='Entrar']")).click();
		String text = navegador.findElement(By.className("errors")).findElement(By.tagName("li")).getText();
		
		Assert.assertEquals("Email ou senha inválida!", text);
		
		navegador.close();
	}
}
