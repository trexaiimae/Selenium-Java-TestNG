import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetE2E {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
			
			
			//Select to and from
			
			//select From destination
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // Container of the list
			driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@text='Bengaluru (BLR)']")).click();// // parent child xpath syntax
			Thread.sleep(1000);
			
			//select to destination
			WebElement element = driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@text='Chennai (MAA)']"));
			System.out.println("Element found: " + element.getText());
			element.click();
			

			//select first calendar
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
			//click on count
			driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(2000);
			for(int i=1;i<5; i++) {
				driver.findElement(By.id("hrefIncAdt")).click();//4 times
				
			}			
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
			 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnclosepaxoption"))).click();
			 
			 //Select currency
			 WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));//state which element we can found the dropdown
			 	Select dropdown = new Select(staticDropdown);			
			 	dropdown.selectByVisibleText("AED");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				Thread.sleep(3000);
				driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
				driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected();
				driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
				
				
				
	
	}
	
	

}
