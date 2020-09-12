package br.com.SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TesteComandosNavegacao {
	
	public static void main(String[] args) throws InterruptedException {
		navegacao();
	}
	public static void navegacao() throws InterruptedException{
			
			System.setProperty("webdriver.gecko.driver", "C:/Devtools/Drivers/geckodriver.exe");
		    WebDriver driver = new FirefoxDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.youtube.com");
		    
		    driver.navigate().to("https://www.google.com");
		    driver.findElement(By.name("q")).sendKeys("smartphone");
		    Actions act = new Actions(driver);
		    act.sendKeys(Keys.ENTER).build().perform();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//a[contains(text(),'Shopping')]")).click();
		    driver.navigate().back();
		    driver.navigate().forward();
		    driver.navigate().refresh();
		    
		    driver.close();
			
	}
}	
