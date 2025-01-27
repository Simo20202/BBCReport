package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SportIn2023Page {
    WebDriver driver;

    @FindBy(xpath = "(//div[contains(.,'Abu Dhabi Grand Prix, Yas MarinaAbu Dhabi Grand Prix, Yas Marina,26 November 2023')])[11]")
    WebElement AbuDhabiGrandPrixYasMarinaLink_xpath;

    @FindBy(xpath = "(//button[@class='ssrcss-1lo9cqs-Button eoocusk1'])[2]")
    public WebElement LVGrandPrixbutton;

    @FindBy(xpath = "(//tr[@class='ssrcss-dhlz6k-TableRowBody e1icz100'])[6]")
    private WebElement sergioParent;

    @FindBy(xpath = " (//button[@aria-expanded])[2]")
    private WebElement aria_expanded;
    @FindBy(xpath = "//span[@data-js-text='true'][contains(.,'Las Vegas Grand Prix, Las Vegas Street Circuit')]")
    WebElement LasVegasGrandPrixResults_xpath;

    @FindBy(xpath = "(//th[contains(@class,'ssrcss-1jdu2ly-StyledTableHeading ep4g78u0')])[2]")
    WebElement resultsTable_xpath;

    @FindBy(xpath = "(//span[@aria-hidden='true'][contains(.,'1')])[12]")
    public WebElement TablePosition_xpath;

    @FindBy(xpath = "(//span[@class='ssrcss-1hf3wfc-FullName e1dzfgvv0'][contains(.,'Max Verstappen')])[2]")
    public WebElement DriverName_xpath;

    @FindBy(xpath = "(//span[@class='ssrcss-1hf3wfc-FullName e1dzfgvv0'])[5]")
    WebElement SecondDriver_Xpath;

    @FindBy(xpath = "(//span[@class='ssrcss-1hf3wfc-FullName e1dzfgvv0'])[83]")
    WebElement ThirdDriver_Xpath;


    public SportIn2023Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAbuDhabiGrandPrixYasMarina() {
        AbuDhabiGrandPrixYasMarinaLink_xpath.click();
    }

    public void clickLasVegasGrandPrixResults() {
        LasVegasGrandPrixResults_xpath.click();
    }

    public void verifyVisibilityOfResultsTable() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(resultsTable_xpath));
        resultsTable_xpath.isDisplayed();
    }

    public boolean VerifyFirstPositionDriver() {
        return ((TablePosition_xpath.getText().equals("1")) && (DriverName_xpath.getText().equalsIgnoreCase("Max Verstappen")));
    }


    public void validate2ndDriver() {
        String SecondDriver = SecondDriver_Xpath.getText();
        Assert.assertEquals(SecondDriver, "George Russell");
    }

    public void validateSergioPerezIs3rd() {
        String SecondDriver = ThirdDriver_Xpath.getText();
        Assert.assertEquals(SecondDriver, "Sergio Perez");
    }


}

