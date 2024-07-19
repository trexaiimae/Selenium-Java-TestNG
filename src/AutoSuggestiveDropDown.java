import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement autosuggestInput = driver.findElement(By.id("autosuggest"));
		autosuggestInput.sendKeys("Ind");
		
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"]")); // List all the elements find in the container
		
			for(WebElement option  : options)	
				{
					if (option.getText().equalsIgnoreCase("India"))
						{
							option.click();
							break; // if goal is met, break the loop
				
						}
			
				}
		
			String selectedCountry = autosuggestInput.getAttribute("value"); // get the selected country
			System.out.println("The selected country is " + selectedCountry);
			driver.close();
		
	}

}
