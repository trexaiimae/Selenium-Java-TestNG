import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//work only with select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));//state which element we can found the dropdown
		
		//dropdown with select tag
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);//selecting index USD
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//select by text
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//select by value
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		Thread.sleep(2000L);
		//Select passenger and add quantity
		driver.findElement(By.id("divpaxinfo")).click();
	
		
		//apply while loop in clicking multiple times
//		int i= 1;
//		while (i<5)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();//4 times
//			i++;
//		}
		
		//or for loop
		for(int i=1;i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();//4 times
			
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}

}
