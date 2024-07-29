import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
public class loginoutPractice {

	public static void main(String[] args) throws InterruptedException {
		String name = "Trexaii";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\geckodriver.exe");
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\Trexie\\Documents\\Installers\\Work\\Drivers\\msedgedriver.exe");
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		//maximize browser size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login correct data
		String password = getPassword(driver);
;		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("input[id*='name']")).sendKeys("Trexaii");// CssSelector contains syntaxt (partial text of attribute only)
		driver.findElement(By.name("inputPassword")).sendKeys(password); // input by name
		
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//input[@id=\"chkboxTwo\"]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); // redugal exp xpath contains syntaxt (partial text of attribute only)
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " +name+",");
		Thread.sleep(1000);
		driver.findElement(By.className("logout-btn")).click();
//		driver.close();
		
	}
	public static String getPassword (WebDriver driver) throws InterruptedException {
		//extract password
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click(); // click on a link
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		
		//get text
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText= (driver.findElement(By.cssSelector("form p")).getText());
		//get text in a sentence (Please use temporary password 'rahulshettyacademy' to Login.)
		String [] passwordArray = passwordText.split("'");
		//set as index from "'". 0th index - PLease use temporary password
		//1st index- 'rahulshettyaccademy' to login
		
		String password= passwordArray[1].split("'")[0];
		//'rahulshettyaccademy' to login
		//0th index - rahulshettyaccademy
		//1st index - to login
		return password; //to return use string in declaration not public void
}
}
