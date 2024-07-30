import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        // maximize browser size
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	        
	        driver.findElement(By.cssSelector(".blinkingText")).click();
	        Set<String> windows =   driver.getWindowHandles(); //get all windows open
	        Iterator<String> it = windows.iterator();
	        String parentId = it.next(); // first window
	        String childId = it.next(); //second window
	        driver.switchTo().window(childId);// switch parent to second window
	        
	        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText()); 
	        driver.findElement(By.cssSelector(".im-para.red")).getText();
	        String emailId=  driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0].trim();//get the creds from second windows
	        driver.switchTo().window(parentId);//go to first window
	        driver.findElement(By.id("username")).sendKeys(emailId);//paste the extracted creds
	      
	      
	}

}
