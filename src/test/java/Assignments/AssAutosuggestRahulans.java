package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssAutosuggestRahulans {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		  driver.findElement(By.id("autocomplete")).sendKeys("ind");

		    Thread.sleep(2000);

		    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

		   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 

		       

		       

		}

		
	

}
