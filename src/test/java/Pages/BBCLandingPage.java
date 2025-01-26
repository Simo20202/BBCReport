package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class BBCLandingPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@id='product-navigation-menu']/div[2]/ul/li/a/span")
    WebElement homeLink_xpath;

    @FindBy(xpath = "//div[@id='product-navigation-menu']/div[2]/ul/li[4]/a/span")
    WebElement formulaOneLink_xpath;

    @FindBy(xpath = "//span[contains(.,'Results')]")
    WebElement resultsLink_xpath;

    @FindBy(xpath = "//a[contains(@class, 'sp-c-date-picker-timeline__item')]//span[contains(text(),'2023')]")
    WebElement yearLink;



    public BBCLandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatBBCIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(homeLink_xpath));
        homeLink_xpath.isDisplayed();
    }

    public void clickFormula1() {
        formulaOneLink_xpath.click();
    }

    public void clickResults() {
        resultsLink_xpath.click();
    }

    public void selectYear(String year) throws InterruptedException {
        try {
            // First make sure we're on the results page
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.contains("/results")) {
                driver.get("https://www.bbc.com/sport/formula1/results");
            }
            
            // Wait for page load
            Thread.sleep(2000);
            
            // Try different possible selectors
            List<String> possibleXPaths = Arrays.asList(
                "//a[contains(@href, '/formula1/" + year + "/results')]",
                "//div[@class='gel-wrap']//a[contains(@href, '" + year + "')]",
                "//div[@role='main']//a[contains(text(), '" + year + "')]"
            );
            
            WebElement yearLink = null;
            for (String xpath : possibleXPaths) {
                try {
                    yearLink = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    if (yearLink != null) break;
                } catch (Exception e) {
                    continue;
                }
            }
            
            if (yearLink == null) {
                throw new NoSuchElementException("Could not find year link for: " + year);
            }
            
            // Scroll and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearLink);
            Thread.sleep(500);
            yearLink.click();
            
        } catch (Exception e) {
            System.out.println("Failed to find year: " + year);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            throw e;
        }
    }

}
