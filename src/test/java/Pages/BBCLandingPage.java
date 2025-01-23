package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BBCLandingPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@id='product-navigation-menu']/div[2]/ul/li/a/span")
    WebElement homeLink_xpath;

    @FindBy(xpath = "//div[@id='product-navigation-menu']/div[2]/ul/li[4]/a/span")
    WebElement formulaOneLink_xpath;

    @FindBy(xpath = "//span[contains(.,'Results')]")
    WebElement resultsLink_xpath;




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

}
