package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentLoginPage {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid"))
              .sendKeys("Trexaii Mae");
        driver.findElement(By.name("email")).sendKeys("trexaiimae@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password123");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        // Select Gender dropdown
        driver.findElement(By.id("exampleFormControlSelect1")).click();
        List<WebElement> options = driver.findElements(By.cssSelector("option"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Female")) {
                option.click();
                break;
            }
        }

        String gender = driver.findElement(By.id("exampleFormControlSelect1")).getAttribute("value");
        System.out.println("User Gender is " + gender);
        Assert.assertEquals(gender, "Female");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("06/08/1998");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();

        String message = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains("Success"), "Form submission failed!");
    }
}