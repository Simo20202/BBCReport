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

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/strong[1]")
    WebElement welcomeTitle_xpath;
    @FindBy(xpath = "//button[contains(.,'Deposit')]")
    WebElement deposit_xpath;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount_xpath;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Deposit')]")
    WebElement depositButton_xpath;

    @FindBy(xpath = "//span[contains(.,'Deposit Successful')]")
    WebElement depositSuccess_xpath;

    // Scenario 2
    @FindBy(xpath = "//select[@id='accountSelect']")
    WebElement accNumber_xpath;

    // Scenario 3
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/strong[2]")
    WebElement accBalance_xpath;

    @FindBy(xpath = "//button[contains(.,'Transactions')]")
    WebElement transactions_xpath;

    @FindBy(xpath = "//td[contains(.,'Credit')]")
    WebElement creditTransactions_xpath;

    @FindBy(xpath = "//button[contains(.,'Back')]")
    WebElement backButton_xpath;

    @FindBy(xpath = "//button[contains(.,'Withdrawl')]")
    WebElement withdrawl_xpath;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Withdraw')]")
    WebElement withdrawButton_xpath;

    @FindBy(xpath = "//span[contains(.,'Transaction successful')]")
    WebElement withdrawSuccess_xpath;

    @FindBy(xpath = "//td[contains(.,'Debit')]")
    WebElement debitTransaction_xpath;



    public BBCLandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatTheCustomerSuccessfulLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(welcomeTitle_xpath));
        welcomeTitle_xpath.isDisplayed();
    }

    public void clickDeposit() {
        deposit_xpath.click();
    }

    public void enterAmountTobeDeposited(String deposit) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(amount_xpath));
        amount_xpath.sendKeys(deposit);
    }

    public void clickDepositButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(depositButton_xpath));
        depositButton_xpath.click();
    }

    public void verifyThatTheDepositWasSuccessful() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(depositSuccess_xpath));
        depositSuccess_xpath.isDisplayed();
    }

    // Scenario 2
    public void selectAccountNumberTwo() {
        Select dropdown = new Select(accNumber_xpath);
        dropdown.selectByVisibleText("1005");
    }

    public void selectAccountNumberThree() {
        Select dropdown = new Select(accNumber_xpath);
        dropdown.selectByVisibleText("1006");
    }

    // Scenario 3
    public void clickTransactions() {
        transactions_xpath.click();

    }

    public void verifyThatTheCreditTransactionsAppears() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(creditTransactions_xpath));
        creditTransactions_xpath.isDisplayed();

    }

    public void clickBackButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(backButton_xpath));
        backButton_xpath.click();
    }

    public void verifyThatTheAccountPageIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(welcomeTitle_xpath));
        welcomeTitle_xpath.isDisplayed();
    }

    public void clickWithdrawl(){
        withdrawl_xpath.click();

    }

    public void enterAmountTobeWithdrawn(String deposit) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(amount_xpath));
        amount_xpath.sendKeys(deposit);
    }

    public void clickWithdrawButton(){
        withdrawButton_xpath.click();
    }

    public void verifyThatTheWithdrawWasSuccessful() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(withdrawSuccess_xpath));
        withdrawSuccess_xpath.isDisplayed();
    }

    public void verifyThatTheCurrentBalanceIsTheSameAsOriginalBalance() {

        int currentBalance = Integer.parseInt(accBalance_xpath.getText());
        System.out.println(currentBalance);
        int originalBalance = 0;

        Assert.assertEquals(currentBalance,originalBalance);
//
//        int originalBalance = 1;
//        if (originalBalance == currentBalance) {
//            System.out.println("Test Passed: Current balance is the same as original balance.");
//        } else {
//            System.out.println("Test Failed: Current balance is not the same as original balance.");
//        }
    }

    public void verifyThatTheDebitTransactionsAppears() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(debitTransaction_xpath));
        debitTransaction_xpath.isDisplayed();

    }

}
