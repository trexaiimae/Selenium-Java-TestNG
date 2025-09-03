package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentRealTime {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // maximize browser size
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement buttons = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
        buttons.click();
        String text = (buttons.getAttribute("value"));
        
        
        //dropdown
       
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        dropdown.click();
        Select select = new Select(dropdown);

        String optionText = text.substring(0, 1).toUpperCase() + text.substring(1);
        select.selectByVisibleText(optionText);
        
        
        driver.findElement(By.id("name")).sendKeys(text);
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        String alert = (driver.switchTo().alert().getText());
      
        
        if (alert.toLowerCase().contains("option2")) {
            System.out.println("Alert text contains 'option2'");
        } else {
            System.out.println("Alert text does not contain 'option2'");
        }

        driver.switchTo().alert().accept();
		}
    
}