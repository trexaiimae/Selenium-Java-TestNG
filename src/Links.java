import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize browser size
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
	
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size()); //get the count of the links on the page //a proper tagname of links
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size()); //get count of links in the footer only
		
		WebElement Coloumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));	
		System.out.println(Coloumn.findElements(By.tagName("a")).size());
		
		//click on each link in the coloumn and check if the pages are opening dynamic
		for(int i =1; i<Coloumn.findElements(By.tagName("a")).size();i++) 
		{
			//open each link in the colmn
			String CtrlKeys = Keys.chord(Keys.CONTROL,Keys.ENTER);		
			Coloumn.findElements(By.tagName("a")).get(i).sendKeys(CtrlKeys);
			
		}
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
			
		while (it.hasNext())// check if there's a window in the next tab 
				{
				
					driver.switchTo().window(it.next());//if true move to that next tab
					System.out.println(driver.getTitle()); // get the title in each tab
				}
			
					
	}

}
