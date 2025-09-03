package ECommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoCart {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); //create wait object
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// expected
		String[] itemsNeeded = { "Cucumber", "Carrot", "Beetroot", "Brinjal" };// list the veg you want to add
		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//example you want to apply explicit wait in the target step below
	
		w.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("span.promoInfo"))));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.quit();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;// initialize to check if the count of arraylist is achieved
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));// find product by name

		for (int i = 0; i < products.size(); i++) {// iterate the list

			String[] name = products.get(i).getText().split("-");// get the items every iteration and split
			String splittedName = name[0].trim();// store the final name in the splittedName Var

			// check if the name extracted is present in the arraylist syntax
			List itemsNeededList = Arrays.asList(itemsNeeded);// convert array to array list for easy search

			if (itemsNeededList.contains(splittedName)) // if during iteration the arrraylist from search is equal to
														// the splitted name go inside the for loop
			{
				j++;// if 1 condition true; iterate +1

				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();// click on add
																										// to cart using
																										// sibling xpath
																										// syntax

				if (j == itemsNeeded.length) // if arraylist count is achieved go to the for loop and break the
												// iteration
				{
					break;
				}
			}
		}
	}
}
