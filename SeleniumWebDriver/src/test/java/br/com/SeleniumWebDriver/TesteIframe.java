package br.com.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteIframe {

	static WebDriver driver;

	public static void main(String[] args) {
		testeIrame();
	}

	public static void testeIrame() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='mceu_34']/button[@role='presentation']")).click();
		driver.switchTo().frame("mce_0_ifr");
		
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Testando frame");
		
		//voltar para o frame principal
		driver.switchTo().parentFrame();
		
		driver.findElement(By.linkText("Elemental Selenium")).click();
		

	}
}
