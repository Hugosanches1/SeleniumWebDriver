package br.com.SeleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestesActions {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		TesteClicarSegurar();
	}

	public static void TesteTeclado() {

		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get(
				"https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-n-en&flowName=GlifWebSignIn&flowEntry=SignUp");

		WebElement primeiroNome = driver.findElement(By.id("firstName"));
		WebElement ultimoNome = driver.findElement(By.id("lastName"));

		Actions act = new Actions(driver);

		act.sendKeys(primeiroNome, "Hugosanches").build().perform();

		act.keyDown(ultimoNome, Keys.SHIFT).build().perform();
		act.sendKeys("c").build().perform();

		act.keyUp(ultimoNome, Keys.SHIFT).build().perform();
		act.sendKeys("orreia").build().perform();

		// driver.quit();
	}

	public static void TesteActionsMouse() {

		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.eggradients.com/tool/double-click-test");

		Actions act = new Actions(driver);

		// WebElement pesquisa = driver.findElement(By.name("q"));
		// WebElement estouComSorte =
		// driver.findElement(By.xpath("//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[3]/center[1]/input[2]"));

		WebElement btn = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[4]"));

		act.doubleClick(btn).build().perform();

		// act.sendKeys(pesquisa, "onde fica o cú da cobra").build().perform();;
		// act.click(estouComSorte).build().perform();

	}

	public static void TesteDireito() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		Actions act = new Actions(driver);

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement btn = driver.findElement(By.cssSelector("span.context-menu-one"));

		act.contextClick(btn).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
	}

	public static void TesteClicarSegurar() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");

		driver = new FirefoxDriver();

		Actions act = new Actions(driver);

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement btn = driver.findElement(By.cssSelector("span.context-menu-one"));
		
		act.clickAndHold(btn).build().perform();
	}
}
