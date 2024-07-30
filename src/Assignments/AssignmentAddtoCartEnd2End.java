package Assignments;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentAddtoCartEnd2End {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// extract password and username from text label
		By xpath = By.xpath("//p[contains(text(),'(username is')]"); // Locate text contains creds
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)); // wait for element to be clickable
		String[] creds = getCreds(driver, xpath);
		String userName = creds[0];
		String passwordFinal = creds[1];
		System.out.println("Username: " + userName);
		System.out.println("Password: " + passwordFinal);

		// apply the extracted creds in the login form
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passwordFinal);
		driver.findElement(By.xpath("//label[@class=\"customradio\"][2]/span[@class=\"checkmark\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("okayBtn")))); // wait for element
																									// to be clickable
		driver.findElement(By.id("okayBtn")).click();
//        driver.switchTo().alert().accept();
		WebElement terms = driver.findElement(By.id("terms"));
		terms.click();
		Assert.assertTrue(terms.isSelected());

		driver.findElement(By.id("signInBtn")).click();
		driver.findElement(By.cssSelector("select[class=\"form-control\"]")).click();
		option(driver); // pass the driver instance to the option method
		Thread.sleep(5000);
		addItems(driver);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[class=\"nav-link btn btn-primary\"]")))); // wait for element
		driver.findElement(By.cssSelector("a[class=\"nav-link btn btn-primary\"]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

	public static String[] getCreds(WebDriver driver, By xpath) {
		String[] creds = driver.findElement(xpath).getText().split(" ");
		String userName = creds[2].trim(); // corrected index
		String password = creds[6].trim(); // corrected index
		String text = password;
		String passwordFinal = text.replace(")", ""); // remove the ) in learning)
		return new String[] { userName, passwordFinal };
	}

	public static void option(WebDriver driver) {
		WebElement dropdown = driver.findElement(By.cssSelector("select[class=\"form-control\"]")); // find the dropdown
																									// element
		dropdown.click(); // click the dropdown to open the options
		List<WebElement> options = dropdown.findElements(By.cssSelector("option")); // find the options within the
																					// dropdown
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Consultant")) {
				option.click();
				break; // if goal is met, break the loop
			}
		}
	}

	public static void addItems(WebDriver driver) {
		List<WebElement> products = driver.findElements(By.cssSelector("div.card"));
		System.out.println("Number of products: " + products.size());
		// Add all products to the cart
		for (WebElement product : products) {
			WebElement addToCartButton = product.findElement(By.cssSelector("button[class=\"btn btn-info\"]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
			addToCartButton.click();

		}

		
	}
}