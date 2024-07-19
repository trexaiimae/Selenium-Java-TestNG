import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://practice.expandtesting.com/radio-buttons");
		
		System.out.println(driver.findElement(By.id("black")).isSelected());
		driver.findElement(By.id("black")).click();
		System.out.println(driver.findElement(By.id("black")).isSelected());
	}

}
