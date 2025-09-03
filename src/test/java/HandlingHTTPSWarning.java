import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingHTTPSWarning {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions(); //invoke chormoptions
		WebDriverManager.chromedriver().setup();	
		options.setAcceptInsecureCerts(true);//accept the warning https
	//	options.addExtensions(null); == add extension to chrome automation browser
		
		//Proxy proxy = new Proxy();/?invoke proxy to object
		//proxy.setHttpProxy("ipaddress:444:);
		//options.setCapability("proxy",proxy); // add proxy
				
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
