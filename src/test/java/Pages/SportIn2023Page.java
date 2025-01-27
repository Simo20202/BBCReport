package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "(//span[contains(.,'George Russell')])[1]")
    WebElement georgeRussell;



    public SportIn2023Page(WebDriver driver) {
        this.driver = driver;
    }

        public void clickAbuDhabiGrandPrixYasMarina() {
            AbuDhabiGrandPrixYasMarinaLink_xpath.click();
        }

    public boolean validateSergioPerezIs3rd(){
      String number3rd = "3"; // 3rd place number
      String nameOfPlayer = "Sergio Perez"; // Name of the player
        String isExpanded = LVGrandPrixbutton.getAttribute("aria-expanded"); //getting the value of attribute aria-expanded

        //checking if the LVGrandPrixbutton is expanded
        if(!isExpanded.equals("true")){
            LVGrandPrixbutton.click();
        }
        //Check of the element sergioParent exist
        if (sergioParent == null) {
            return false;
        } else {
            //getting text of element
            sergioParent.getText();
        }
        //remove empty spaces
        String actualPlayerParent = sergioParent.getText().trim();

        //getting the first character on the parent
        String firstCharOfPlayerParent = String.valueOf(actualPlayerParent.charAt(0));
        //checking if the first is equals to the number3rd and the actualPlayerParent contains the name of the player
        return firstCharOfPlayerParent.equals(number3rd) && actualPlayerParent.contains(nameOfPlayer);
    }


    public boolean validate2ndDriver(){
        String secondPlace = "1"; // 2nd place number
        String playerName = "George Russell"; // Name of the player
        String isExpanded = LVGrandPrixbutton.getAttribute("aria-expanded"); //getting the value of attribute aria-expanded

        //checking if the LVGrandPrixbutton is expanded
        if(!isExpanded.equals("true")){
            LVGrandPrixbutton.click();
        }
        //Check of the element George Russell exist
        if (georgeRussell == null) {
            return false;
        } else {
            //getting text of element
            georgeRussell.getText();
        }
        //remove empty spaces
        String actualPlayerParent = georgeRussell.getText().trim();

        //getting the first character on the parent
        String firstChar = String.valueOf(actualPlayerParent.charAt(0));
        //checking if the first is equals to the number2nd and the actualPlayerParent contains the name of the player
        return firstChar.equals(secondPlace) && actualPlayerParent.contains(playerName);
    }

}

