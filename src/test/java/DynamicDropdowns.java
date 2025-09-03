// testing with dropdown which is dependent to other dropdown. Example from and to

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		
		//select From destination
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // Container of the list
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@text='Bengaluru (BLR)']")).click();// // parent child xpath syntax
		Thread.sleep(1000);
		
		//select to destination
		WebElement element = driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@text='Chennai (MAA)']"));
		System.out.println("Element found: " + element.getText());
		element.click();
		Thread.sleep(3000);
		
		//select first calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(3000);
		
		//check if second calendar is enabled
//		WebElement SecondCalendar =driver.findElement(By.name("ctl00$mainContent$view_date2"));
	

		

	}

}
