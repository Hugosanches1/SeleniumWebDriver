package br.com.SeleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteComandosBrowser{
   
	static WebDriver driver;
	
	public static void main(String[] args) {
		comandosBrowser();
	}
	public static void comandosBrowser(){
		
		System.setProperty("webdriver.gecko.driver", "C:/Devtools/Drivers/geckodriver.exe");

	    WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		System.out.println("Titulo: " + driver.getTitle());
		
		System.out.println("Endereço da janela: " + driver.getCurrentUrl());
		
		//System.out.println("Codigo Fonte: " + driver.getPageSource());
		
		driver.quit();
	}
}
