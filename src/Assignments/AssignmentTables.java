package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentTables {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.scrollBy(0,400)");
//		Thread.sleep(2000);
	
		
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		int numberOfRows = rows.size(); //get number of rows
		System.out.println("Number of rows: " + numberOfRows);
		
		List <WebElement> cell = driver.findElements(By.cssSelector(".table-display th"));
		int numberofColumn = cell.size();
		System.out.println("Number of Column: " +numberofColumn);
		
		String secrowval= driver.findElement(By.cssSelector("tr:nth-child(3)")).getText();
		System.out.println(secrowval);
	}

}

