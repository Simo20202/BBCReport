package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SportIn2023Page {
    WebDriver driver;

    @FindBy(xpath = "(//div[contains(.,'Abu Dhabi Grand Prix, Yas MarinaAbu Dhabi Grand Prix, Yas Marina,26 November 2023')])[11]")
    WebElement AbuDhabiGrandPrixYasMarinaLink_xpath;

    @FindBy(xpath = "//span[@data-js-text='true'][contains(.,'Las Vegas Grand Prix, Las Vegas Street Circuit')]")
    WebElement LasVegasGrandPrixResults_xpath;

    @FindBy(xpath = "(//th[contains(@class,'ssrcss-1jdu2ly-StyledTableHeading ep4g78u0')])[2]")
    WebElement resultsTable_xpath;

    public SportIn2023Page(WebDriver driver) {
        this.driver = driver;
    }

        public void clickAbuDhabiGrandPrixYasMarina() {
            AbuDhabiGrandPrixYasMarinaLink_xpath.click();
        }

        public void clickLasVegasGrandPrixResults() {
            LasVegasGrandPrixResults_xpath.click();
        }

        public void verifyVisibilityOfResultsTable(){
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(resultsTable_xpath));
            resultsTable_xpath.isDisplayed();
        }
    }