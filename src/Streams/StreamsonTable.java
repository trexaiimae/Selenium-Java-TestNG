package Streams;
import java.util.List;

//include stream in pagination lesson

import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsonTable {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		Thread.sleep(2000);
		// click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all webelements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into new(original) list
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());//capture all values using stream and back to list instead of using for loop use stream for code optimazation

		// sort on the original list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;
		
		// scan the name column with getText ->Beans->print the price of the Rice
		do // use do while loop used to do if condition is true
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));//print each item present in the list
		
		if(price.size()<1) //means price is equal to 1 since rice exist in the list
		{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();//click on next button in pagination
		}
		}
		while(price.size()<1);//iterate again if rice is not yet found in the list
		
		}

		private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();// no need to write first sibling as it was stores already in s

		return pricevalue;


	}

}
