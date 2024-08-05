package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssAutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement autosuggestInput = driver.findElement(By.id("autocomplete"));
		autosuggestInput.sendKeys("Ind");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item")); // List all the elements find in the container
		
		Actions actions = new Actions(driver);
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				actions.moveToElement(option).click().perform();
				break;
			}
		}
	
		String selectedCountry = autosuggestInput.getAttribute("value"); // get the selected country
		System.out.println("The selected country is " + selectedCountry);
		driver.close();
	}

}