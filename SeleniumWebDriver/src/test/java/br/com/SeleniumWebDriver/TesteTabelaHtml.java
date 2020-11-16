package br.com.SeleniumWebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteTabelaHtml {

	static WebDriver driver;
	
	public static void main(String[] args) {
		TesteTabela();

	}
	public static void TesteTabela(){
		System.setProperty("webdriver.gecko.driver", "C:/DevTools/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://scrud.whirlwind.nl/");
		driver.manage().window().maximize();
		
		List<WebElement> linhas = driver.findElements(By.xpath("//table[@id='table_companies']/tbody/tr"));
		
		System.out.println(linhas.size());
		
		List<WebElement> colunas = driver.findElements(By.xpath("//table[@id='table_companies']/tbody/tr/td"));
		
		System.out.println(colunas.size());
		
		String empresa = "Mercado Pagliasi";
		for(int i=0; i<linhas.size(); i++ ){
			for(int j=0; i<colunas.size();j++){
				if(colunas.get(j).getText().contentEquals(empresa)){
					driver.findElement(By.xpath("//li[@class='function_edit']/a[@data-name='" + empresa + "']")).click();
					break;
				}
			}
			break;
		}
	}
	

}
