import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginPage extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException  {

//		System.setProperty("wendriver.chrome.driver", "C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/locatorspractice/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Trexaii");// input by id
		driver.findElement(By.name("inputPassword")).sendKeys("tester"); // input by name
		driver.findElement(By.className("signInBtn")).click(); // click button, using classname
		System.out.println (driver.findElement(By.cssSelector("p.error")).getText()); // get text using css selector classname
		
		driver.findElement(By.linkText("Forgot your password?")).click(); // click on a link		
		driver.findElement(By.xpath("//input[@placeholder ='Name']")).sendKeys("Trexaii"); //xpath normal syntax
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("tester@gmail.com"); // css selector index syntax
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("093625162"); // xpath parent child syntax
		
		Thread.sleep(3000);// add delayto display the form first before clicking on reset button
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println (driver.findElement(By.cssSelector("form p")).getText());//cssSelector parent child syntax
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		
		//login correct data
		driver.findElement(By.cssSelector("input[id*='name']")).sendKeys("Trexaii");// CssSelector contains syntaxt (partial text of attribute only)
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy"); // input by name
		
		Thread.sleep(3000);// add delayto display the form first before clicking on reset button
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//input[@id=\"chkboxTwo\"]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); // redugal exp xpath contains syntaxt (partial text of attribute only)
		Thread.sleep(3000);
		driver.findElement(By.className("logout-btn")).click();
	}

}




//locators samples
//<input type = "text" placeholder= "Username" value ="test"
//css selector syntax = input [placeholder = "Username"]

//css selector classname (<p class ="error">* Incorrect username or password </p>
	//driver.findelement(By.cssSelector("p.error"))

//xpath syntaxt =  //Tagname[@attrubute="value"]

// cssSelector contins or partial text syntaxt cssSelector = input[attribute*='value']

//xpath two words name = //button[contains(@class,"submit')]

//combination syntax = div[@class='forgot-pwd-btn-container']/button[1] 

//div[class="login-container"] h2 parent (space) child
