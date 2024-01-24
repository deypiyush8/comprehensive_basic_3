package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutomationAnywhereDemoTest {
    public static void main(String[] args) {


        // Create an instance of WebDriver
        WebDriver driver = new ChromeDriver();

        // Set implicit wait
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
            // Click on Request Demo button
            WebElement requestDemoButton = driver.findElement(By.xpath("//a[normalize-space()='Request demo']"));
            requestDemoButton.click();

            // Verify that the page is navigated to https://www.automationanywhere.com/request-live-demo
            String expectedURL = "https://www.automationanywhere.com/request-live-demo";
            String actualURL = driver.getCurrentUrl();

            if (actualURL.equals(expectedURL)) {
                System.out.println("Navigation to Request Live Demo page successful.");
            } else {
                System.out.println("Navigation to Request Live Demo page failed.");
            }

            // Verify the Label Names for First Name and Last Name
            WebElement firstNameLabel = driver.findElement(By.xpath("//label[@id='LblFirstName']"));
            WebElement lastNameLabel = driver.findElement(By.xpath("//label[@id='LblLastName']"));

            System.out.println("First Name Label: " + firstNameLabel.getText());
            System.out.println("Last Name Label: " + lastNameLabel.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

