package Assignments;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // maximize browser size
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid")).sendKeys("Trexaii Mae");
        driver.findElement(By.name("email")).sendKeys("trexaiimae@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password123");
        driver.findElement(By.xpath("//input [@type=\"checkbox\"]")).click();

        // Select the dropdown
        driver.findElement(By.id("exampleFormControlSelect1")).click();

        // Get all the options of Gender
        List<WebElement> options = driver.findElements(By.cssSelector("option")); 

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Female")) {
                option.click();
                break; // if goal is met, break the loop
              
                
            }
        }
        String Gender = driver.findElement(By.id("exampleFormControlSelect1")).getAttribute("value");
        System.out.println("User Gender is " + Gender);
        Assert.assertEquals(Gender, "Female");
        
        
        
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("06/08/1998");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        
        String Message = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        System.out.println(Message);
//        
//        
//        Thread.sleep(3000);
//        driver.close();
    }
}