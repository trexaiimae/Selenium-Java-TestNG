// testing with dropdown which is dependent to other dropdown. Example from and to

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		
	
		
//		////a[@text='Chennai (MAA)'] xpath for chennai  (//a[@text='Chennai (MAA)'])[2]
//		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		driver.findElement(By.xpath("(//a[@text='Bengaluru (BLR)'])[1]")).click();
//		Thread.sleep(2000);
//		WebElement element = driver.findElement(By.xpath("(//a[@text='Chennai (MAA)'])[2]"));
//		System.out.println("Element found: " + element.getText());
//		element.click();
//		
		// other way to handle without using indexes
		///  //div[@id="glsctl00_mainContent_ddl_originStation1_CTNR"] //a[@text='Bengaluru (BLR)'] This is parent child way of locating Parent [Space] Child xpaths
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // Container of the list
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@text='Bengaluru (BLR)']")).click();// // parent child xpath syntax
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@text='Chennai (MAA)']"));
		System.out.println("Element found: " + element.getText());
		element.click();
		Thread.sleep(3000);
		driver.close();
		

	}

}
