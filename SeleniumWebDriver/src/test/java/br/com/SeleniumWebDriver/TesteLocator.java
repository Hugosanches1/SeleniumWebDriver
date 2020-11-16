package br.com.SeleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteLocator {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		testeCssSelectorSubstring();
	}

	public static void testeGoogle() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://www.youtube.com");

		List<WebElement> lista = driver.findElements(By.tagName("a"));

		for (WebElement elemento : lista) {
			System.out.println("Link: " + elemento.getText());
		}
		driver.quit();
	}
	
	public static void testeCssSelectorID() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("hugosanches1@hotmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("helaynn");
		driver.findElement(By.cssSelector("button#u_0_b")).click();

	}
	
	public static void testeCssSelectorClass() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("hugosanches1@hotmail.com");
		driver.findElement(By.cssSelector("button._42ft")).click();

	}
	
	public static void testeCssSelectorAtributo() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.cssSelector("input[type=text]")).sendKeys("hugosanches1@hotmail.com");
		driver.findElement(By.cssSelector("input[type=password]")).sendKeys("helaynn");
		driver.findElement(By.cssSelector("button[type=submit]")).click();

	}
	
	public static void testeCssSelectorSubstring() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.id("u_0_2")).click();
		
		Thread.sleep(3000);
		
		//procura pelo começo do texto
		driver.findElement(By.cssSelector("input[name^='first']")).sendKeys("Fulano");
		//procura pelo final do texto
		driver.findElement(By.cssSelector("input[id$='_d']")).sendKeys("Sanches");
		//procura qualquer parte
		driver.findElement(By.cssSelector("input[name*='eg_em']")).sendKeys("email@hotmail.com");

	}



}
