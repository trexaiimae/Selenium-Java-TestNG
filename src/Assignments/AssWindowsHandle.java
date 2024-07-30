package Assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssWindowsHandle {

	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/");
	        
	       
	        driver.findElement(By.xpath("//a[@href=\"/windows\"]")).click(); //click on multiple window by href
	        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
	        
	        Set<String> windows =   driver.getWindowHandles();
	        Iterator<String> it = windows.iterator();
	        String parentId = it.next(); // first window
	        String childId = it.next(); //second window
	        driver.switchTo().window(childId);// switch parent to second window
	        
	        System.out.println(driver.findElement(By.cssSelector(".example")).getText());
	        driver.switchTo().window(parentId);// switch parent to second window
	        System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());

	}

}
