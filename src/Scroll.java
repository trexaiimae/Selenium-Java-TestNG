import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		js.executeAsyncScript("window.scrollBy(0,1200)");//scroll to the element you want to navigate
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");//scroll on a table (component)

		//xpath= //td[4] or css= td:nth-child(4)
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		
		for (int i =0;i<values.size();i++)
		{
			sum = sum+ Integer.parseInt(values.get(i).getText()); //convert string to integer
			
		}
		System.out.println(sum);
		int total= Integer.parseInt(driver.findElement(By.xpath("(//div[@class='totalAmount'])[1]")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		
	}

}
