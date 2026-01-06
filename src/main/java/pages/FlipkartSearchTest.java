package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

public class FlipkartSearchTest {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws IOException, InterruptedException {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        openFlipkart();
        closeLoginPopup();
        searchProduct("laptop");
        clickFirstResult();
        switchToNewTab();
        validateProductPage();
        Thread.sleep(3000);
        takeScreenshot();

        
    }

    // Navigate to Flipkart
    public static void openFlipkart() {
        driver.get("https://www.flipkart.com");
    }

    // Close login popup

    public static void closeLoginPopup() {
        try {
            WebElement closeButton = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//button[contains(@class,'_2KpZ6l') and contains(@class,'_2doB4z')]")
                    )
            );
            closeButton.click();
            System.out.println("Login popup closed");
        } catch (Exception e) {
            System.out.println("Login popup not displayed");
        }
    }


    // Search product
    public static void searchProduct(String productName) {
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    // Click first product
    public static void clickFirstResult() {
        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[contains(@href,'/p/')])[1]")
                )
        );
        firstProduct.click();
    }

    // Switch to new tab
    public static void switchToNewTab() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    // Validate Add to Cart button
    public static void validateProductPage() {

        WebElement addToCartButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(text(),'Add to cart')]")
                )
        );

        // Add to Cart
        addToCartButton.click();
    }

    // Take screenshot
    
    public static void takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("FlipkartProductPage.png");
        FileUtils.copyFile(src, dest);
    }
}
