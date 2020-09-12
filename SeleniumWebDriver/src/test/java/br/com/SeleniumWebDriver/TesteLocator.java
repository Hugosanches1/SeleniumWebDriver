package br.com.SeleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteLocator {

	static WebDriver driver;

	public static void main(String[] args) {
		testeGoogle();
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

}
