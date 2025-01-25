package StepsDefinition;

import Pages.BBCLandingPage;
import Pages.SportIn2023Page;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

   BrowserFactory browserFactory = new BrowserFactory();
   final WebDriver driver = browserFactory.startBrowser("edge","https://www.bbc.com/sport");

   BBCLandingPage bbcLandingPage = PageFactory.initElements(driver, BBCLandingPage.class);
   SportIn2023Page sportIn2023PagePage = PageFactory.initElements(driver, SportIn2023Page.class);
}
