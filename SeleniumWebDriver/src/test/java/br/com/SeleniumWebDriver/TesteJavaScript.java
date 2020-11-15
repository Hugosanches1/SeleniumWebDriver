package br.com.SeleniumWebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteJavaScript {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		javaScriptTest2();

	}

	public static void submarino() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://submarino.com.br/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("document.getElementById('h_search-input').value='livros';");
		
		System.out.println("Escrevi: Livros na busca...");
		
		Thread.sleep(1500);
		
		js.executeScript("document.getElementById('h_search-btn').click();");
		
		System.out.println("Cliquei em buuscar...");
		
		Thread.sleep(6500);
		
		js.executeScript("window.scrollBy(0,300);");
		
		System.out.println("Rolei...");
			
		Thread.sleep(1500);
		
		WebElement livro = driver.findElement(By.xpath("//div[h2='Livro - Capão Pecado']"));
		
		js.executeScript("arguments[0].click();", livro);
		
	}
	public static void javaScriptTest2() throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("http://the-internet.herokuapp.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement linkCheck = driver.findElement(By.linkText("Checkboxes"));
		
		js.executeScript("arguments[0].click();", linkCheck);
		
		String titulo = js.executeScript("return document.title").toString();
		System.out.println(titulo);
				
		Thread.sleep(1500);
		WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
		
		Thread.sleep(1500);
		
		js.executeScript("arguments[0].checked=true", checkbox);
		Thread.sleep(1500);
		js.executeScript("alert('O elemento foi checado!');");
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
		Thread.sleep(1500);
		js.executeScript("arguments[0].checked=false", checkbox);
		
		js.executeScript("history.go(0);");
		
	}

}
