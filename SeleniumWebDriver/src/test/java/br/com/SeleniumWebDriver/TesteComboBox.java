package br.com.SeleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteComboBox {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		checkeBox();

	}
	public static void combobox() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Select Dropdown List")).click();
		Select diaSemana = new Select(driver.findElement(By.id("select-demo")));
		diaSemana.selectByIndex(3);
		Thread.sleep(2000);
		diaSemana.selectByValue("Monday");
		Thread.sleep(2000);
		diaSemana.selectByVisibleText("Tuesday");
	}
	public static void radioButton() {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='Male']")).getAttribute("checked").toString());
		
	}
	public static void checkeBox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);");
		
		List<WebElement> labels = driver.findElements(By.xpath("//label"));
		for (int i =0; i < labels.size(); i++) {
			if (labels.get(i).getAttribute("innerText").contentEquals("Option 2")) {
				labels.get(i).click();
			}
		}
		
		
	}
}
