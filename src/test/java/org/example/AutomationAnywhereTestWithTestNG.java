package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class AutomationAnywhereTestWithTestNG {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {


        // Create an instance of WebDriver
        driver = new ChromeDriver();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        // Navigate to the URL
        driver.get("https://www.automationanywhere.com/");
        acceptCookies();
    }

    @Test
    public void testProcessDiscoveryNavigation() {
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
            Assert.assertEquals(actualURL, expectedURL, "Navigation to Process Discovery failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void acceptCookies() {
        // Attempt to locate and click the "Accept All Cookies" button
        try {
            WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler")); // replace with the actual ID or other locator
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Handle exception if the "Accept All Cookies" button is not found
            System.out.println("No Accept All Cookies button found.");
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

