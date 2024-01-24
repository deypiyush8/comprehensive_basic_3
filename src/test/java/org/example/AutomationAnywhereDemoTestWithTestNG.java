package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutomationAnywhereDemoTestWithTestNG {
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
    public void testRequestDemoButton() {
        // Click on Request Demo button
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[normalize-space()='Request demo']"));
        requestDemoButton.click();

        // Verify that the page is navigated to https://www.automationanywhere.com/request-live-demo
        String expectedURL = "https://www.automationanywhere.com/request-live-demo";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Navigation to Request Live Demo page failed.");

        // Verify the Label Names for First Name and Last Name
        WebElement firstNameLabel = driver.findElement(By.xpath("//label[@id='LblFirstName']"));
        WebElement lastNameLabel = driver.findElement(By.xpath("//label[@id='LblLastName']"));

        Assert.assertEquals(firstNameLabel.getText(), "First Name");
        Assert.assertEquals(lastNameLabel.getText(), "Last Name");
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
