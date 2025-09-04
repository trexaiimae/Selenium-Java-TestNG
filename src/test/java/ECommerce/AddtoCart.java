package ECommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoCart {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Test
    public void testAddItemsAndVerifyCart() throws InterruptedException {
        String[] itemsNeeded = { "Cucumber", "Carrot", "Beetroot", "Brinjal" };
        addItems(itemsNeeded);

        // Open cart and proceed to checkout
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        assertCart(itemsNeeded);// Assert items in cart and validate totals

        // Add promo code and apply
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")))
                .sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Assert promo code applied message
        WebElement promoInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        String promoMessage = promoInfo.getText().trim();
        Assert.assertEquals(promoMessage, "Code applied ..!", "Promo code message did not match");
        validateDiscountedTotal();// Validate discounted total

		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		// Select a country from dropdown
    	WebElement countryDropdown = wait.until(
   		ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
		org.openqa.selenium.support.ui.Select selectCountry = new org.openqa.selenium.support.ui.Select(countryDropdown);
		selectCountry.selectByVisibleText("Philippines");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click(); // Checkout the order

		// Small delay since thank you page closes quickly
		try {
    	Thread.sleep(1500); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement thankYouMessage = driver.findElement(By.cssSelector("div.wrapperTwo span"));
		String actualText = thankYouMessage.getText().trim();// Grab the thank-you message
		actualText = actualText.replaceAll("\\s+", " ");// replace multiple spaces/newlines with a single space to avoid message mismatch
		String expectedText = "Thank you, your order has been placed successfully You'll be redirected to Home page shortly!!";// Expected text (single line)

		Assert.assertEquals(actualText, expectedText);
		System.out.println("Thank You message verified: " + actualText);
		Thread.sleep(5000); // Just to see the message before closing
    }

    public void addItems(String[] itemsNeeded) {
        List<String> itemsNeededList = Arrays.stream(itemsNeeded)
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toList());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name")));
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int itemsAdded = 0;

        for (int i = 0; i < products.size(); i++) {
            products = driver.findElements(By.cssSelector("h4.product-name")); // Refresh list
            String productName = products.get(i).getText().split("-")[0].trim().toLowerCase();

            if (itemsNeededList.contains(productName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                itemsAdded++;
                if (itemsAdded == itemsNeeded.length) break;
            }
        }
    }

    public void assertCart(String[] itemsNeeded) {
        // Wait for cart products
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("p.product-name")));
        List<WebElement> cartProducts = driver.findElements(By.cssSelector("p.product-name"));

        List<String> actualItems = cartProducts.stream()
                .map(e -> e.getText().split("-")[0].trim().toLowerCase())
                .collect(Collectors.toList());

        List<String> expectedItems = Arrays.stream(itemsNeeded)
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toList());

        System.out.println("Expected items: " + expectedItems);
        System.out.println("Actual items in cart: " + actualItems);

        for (String expected : expectedItems) {
            Assert.assertTrue(actualItems.contains(expected), "Expected item not found: " + expected);
        }

        // Wait for table rows to be visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("table tbody tr")));
        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        double calculatedTotal = 0;

        for (WebElement row : rows) {
            // Get last <p.amount> in the row (row total)
            List<WebElement> amounts = row.findElements(By.cssSelector("p.amount"));
            double rowTotal = Double.parseDouble(amounts.get(amounts.size() - 1).getText().trim());
            calculatedTotal += rowTotal;
        }

        // Get displayed total
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.totAmt")));
        double displayedTotal = Double.parseDouble(totalElement.getText().trim());

        System.out.println("Calculated total from rows: " + calculatedTotal);
        System.out.println("Displayed total: " + displayedTotal);

        Assert.assertEquals(calculatedTotal, displayedTotal, 0.01, "Total amount mismatch!");
    }

    public void validateDiscountedTotal() {
        // Fetch discount percentage
        WebElement discountPercElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.discountPerc")));
        double discountPerc = Double.parseDouble(discountPercElement.getText().replace("%", "").trim());
        System.out.println("Discount percentage: " + discountPerc);

        // Calculate expected discounted total
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.totAmt")));
        double total = Double.parseDouble(totalElement.getText().trim());
        double expectedDiscountedTotal = total - (total * discountPerc / 100);
        System.out.println("Calculated Total After Discount: " + expectedDiscountedTotal);

        // Fetch actual discounted total displayed
        WebElement discountedTotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.discountAmt")));
        double actualDiscountedTotal = Double.parseDouble(discountedTotalElement.getText().trim());
        System.out.println("Displayed Total After Discount: " + actualDiscountedTotal);

        Assert.assertEquals(actualDiscountedTotal, expectedDiscountedTotal, 0.01,
                "Discounted total does not match expected calculation");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
