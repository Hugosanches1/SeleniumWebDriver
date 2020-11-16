package br.com.SeleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteWait {
	static WebDriver driver;

	public static void main(String[] args) {
		TesteImplicitWait();
	}

	public static void TesteImplicitWait() {
		
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		driver.findElement(By.xpath("//button")).click();
		WebElement texto = driver.findElement(By.xpath("//div[@id='finish']/h4"));
		System.out.println(texto.getAttribute("innerText").toString());
	}
public static void TesteWaitExplicito() {
		
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.xpath("//button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement texto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='finish']/h4")));
		
		texto.click();
		
		System.out.println(texto.getAttribute("innerText").toString());
	}

}
