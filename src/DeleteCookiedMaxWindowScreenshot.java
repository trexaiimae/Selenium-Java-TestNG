import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class DeleteCookiedMaxWindowScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Documents\\Installers\\WEB AUTOMATION\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Screenshot store in src
		FileUtils.copyFile(src,new File("D:\\Screenshot\\SS.png"));

	}

}


//https://commons.apache.org/io/download_io.cgi if Fileutil not importing