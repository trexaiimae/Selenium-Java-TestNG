package Streams;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class StreamsFilterTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
        driver.findElement(By.id("search-field")).sendKeys("Rice");//search rice in the search bar
        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]")); //get the result in the list
        
        //1 results
       List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).
        collect(Collectors.toList());//filter the list based in rice contains using streams

       //1 result
       Assert.assertEquals(veggies.size(), filteredList.size()); //check of the search functionality of the system is worling as expected

	}

}
