package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutomationAnywhereTest {
    public static void main(String[] args) {
        // Set the path of chromedriver.exe based on your machine
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Create an instance of WebDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));


        // Navigate to the URL
        driver.get("https://www.automationanywhere.com/");
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler")); // replace with the actual ID or other locator
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Handle exception if the "Accept All Cookies" button is not found
            System.out.println("No Accept All Cookies button found.");
        }

        try {
            // Perform mouse-over on "Products"
            WebElement productsMenu = driver.findElement(By.xpath("//a[normalize-space()='Products']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(productsMenu).build().perform();

            // Click on "Process Discovery"
            WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[@class='coh-link js-coh-menu-item-link '][normalize-space()='Process Discovery']"));
            processDiscoveryLink.click();

            // Verify the URL
            String expectedURL = "https://www.automationanywhere.com/products/process-discovery";
            String actualURL = driver.getCurrentUrl();

            if (actualURL.equals(expectedURL)) {
                System.out.println("Navigation to Process Discovery successful.");
            } else {
                System.out.println("Navigation to Process Discovery failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
