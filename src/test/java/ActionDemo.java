import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		a.moveToElement(move).build().perform(); // move mouse to the element to hover
		a.moveToElement(move).contextClick().build().perform();// right click
		a.moveToElement(move);
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();//write in caps and doubleclick
		
			
	}

}
