import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTraverse {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Sibling - child to parent traverse syntax
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());// Header>div>button[1]>
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		//or
		//child to parent syntaxt
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).click();
		
	}

}
