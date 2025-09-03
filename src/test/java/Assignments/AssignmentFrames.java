package Assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFrames {
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

        
        driver.switchTo().frame("frame-top");// Switch to the top frame  
        driver.switchTo().frame("frame-middle");// Switch to the middle frame
        WebElement middleTextElement = driver.findElement(By.xpath("//body"));  // Get the middle text
        String middleText = middleTextElement.getText();

        System.out.println("Middle text is: " + middleText);

        driver.quit();
    }
}