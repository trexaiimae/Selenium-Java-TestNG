import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowsersNavigations {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");//from google open this url
		driver.navigate().back();//navigate back to google.com
		driver.navigate().forward();//back to url
		
		
		
	}
	

}
