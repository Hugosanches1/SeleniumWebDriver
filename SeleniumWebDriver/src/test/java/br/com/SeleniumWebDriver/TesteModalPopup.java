package br.com.SeleniumWebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteModalPopup {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		janela();

	}
	public static void modal() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://uitestpractice.com/Students/Switchto");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("button[data-target='#myModal']")).click();
		WebElement botaoOK = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary")));
		botaoOK.click();
	}
	
	public static void janela() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://uitestpractice.com/Students/Switchto");
		driver.manage().window().maximize();
		String janelaPrinciapl = driver.getWindowHandle();
		System.out.println("Janela Principal: " + janelaPrinciapl);
		System.out.println("Url Principal: " + driver.switchTo().window(janelaPrinciapl).getCurrentUrl());
		driver.findElement(By.linkText("Opens in a new window")).click();
		Thread.sleep(3000);
		Set<String> todasJanelas = driver.getWindowHandles();
		for (String janela : todasJanelas) {
			if(!janela.contentEquals(janelaPrinciapl)) {
				System.out.println(driver.switchTo().window(janela).getCurrentUrl());
			}
		}
		driver.switchTo().window(janelaPrinciapl);
	}

}
