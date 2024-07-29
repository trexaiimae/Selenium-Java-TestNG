import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CebPacPractice {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		//maximize browser size
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.cebupacificair.com/en-PH/");
		
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).click();
		driver.findElement(By.cssSelector("img[alt=\"Clear\"]")).click();
		WebElement from= driver.findElement(By.id("originFormControl-0"));
		from.click();
		from.clear();
		Thread.sleep(2000);
		from.sendKeys("Cgy");
		
		List<WebElement> options = driver.findElements(By.cssSelector("div[class=\"content ng-tns-c20-18\"]")); // List all the elements find in the container
		for(WebElement option  : options)	
		{
			if (option.getText().equalsIgnoreCase("Cagayan de Oro"))
				{
					option.click();
					break; // if goal is met, break the loop
		
				}
	
		}
		
		
	}

}
