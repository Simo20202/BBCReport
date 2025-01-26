package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportIn2023Page {
    WebDriver driver;

    @FindBy(xpath = "(//div[contains(.,'Abu Dhabi Grand Prix, Yas MarinaAbu Dhabi Grand Prix, Yas Marina,26 November 2023')])[11]")
    WebElement AbuDhabiGrandPrixYasMarinaLink_xpath;

    public SportIn2023Page(WebDriver driver) {
        this.driver = driver;
    }

        public void clickAbuDhabiGrandPrixYasMarina() {
            AbuDhabiGrandPrixYasMarinaLink_xpath.click();


        }
    }