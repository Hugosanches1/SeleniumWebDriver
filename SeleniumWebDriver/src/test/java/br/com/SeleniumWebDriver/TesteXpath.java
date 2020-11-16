package br.com.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteXpath {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		testeXpathRelativo();
	}

	public static void testeXpathAbsoluto() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.magazineluiza.com.br");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div[1]/header/div/div[1]/div/div/div[2]/div[2]/div/input")).sendKeys("celular");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div[1]/header/div/div[1]/div/div/div[2]/div[2]/div/span")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,600);");
	
	}
	public static void testeXpathRelativo() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.magazineluiza.com.br");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='inpHeaderSearch']")).sendKeys("celular");
		driver.findElement(By.xpath("//span[@title='Buscar']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,600);");
		
		driver.findElement(By.xpath("//li/a[@title='Smartphone Motorola One Fusion+ 128GB Branco']")).click();
	
	}


}
