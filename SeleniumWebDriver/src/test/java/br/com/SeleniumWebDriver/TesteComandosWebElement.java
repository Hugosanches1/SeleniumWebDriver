package br.com.SeleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteComandosWebElement {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
	}
	public static void webElement(){
		System.setProperty("webdriver.gecko.driver", "C:/Devtools/Drivers/geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.youtube.com");
	}
}
