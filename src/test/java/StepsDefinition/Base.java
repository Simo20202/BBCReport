package StepsDefinition;

import Pages.BBCLandingPage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

   BrowserFactory browserFactory = new BrowserFactory();
   final WebDriver driver = browserFactory.startBrowser("chrome","https://www.bbc.com/sport");

   BBCLandingPage accountPage = PageFactory.initElements(driver, BBCLandingPage.class);
}
