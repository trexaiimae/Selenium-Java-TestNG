import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsAssignment {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
	        
	        // maximize browser size
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	        Thread.sleep(3000);
	        
	        WebElement FirstButton = driver.findElement(By.id("checkBoxOption1"));
	        FirstButton.click();
	        Assert.assertTrue( driver.findElement(By.id("checkBoxOption1")).isSelected());   
	        FirstButton.click();
	        Assert.assertFalse( driver.findElement(By.id("checkBoxOption1")).isSelected());   
	}

}
