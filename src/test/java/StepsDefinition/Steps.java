package StepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Steps extends Base {


    @Given("The user is in the BBC Landing page")
    public void the_user_is_in_the_bbc_landing_page() {
        bbcLandingPage.verifyThatBBCIsDisplayed();
    }
    @And("The user has selected the Formula one")
    public void the_user_has_selected_the_formula_one() {
        bbcLandingPage.clickFormula1();
    }
    @And("The user has selected the Results")
    public void the_user_has_selected_the_results() {
        bbcLandingPage.clickResults();
    }
    @And("The user has selected the year to report on")
    public void the_user_has_selected_the_year_to_report_on() throws InterruptedException {

        bbcLandingPage.selectYear("2023");
        Thread.sleep(5000);
    }
    @And("The user collapse the currently opened results")
    public void the_user_collapse_the_currently_opened_results() {
        sportIn2023PagePage.clickAbuDhabiGrandPrixYasMarina();
//      Tlhogi
    }
    @When("The user click on the Las Vegas Grand Prix, Las Vegas Street Circuit")
    public void the_user_click_on_the_las_vegas_grand_prix_las_vegas_street_circuit() {
//      T-MAN
    }
    @Then("The Results table should be displayed")
    public void the_results_table_should_be_displayed() {
//      T-MAN
    }
    @And("The user validate that Max Verstappen took 1st place")
    public void the_user_validate_that_max_verstappen_took_1st_place() {
//     Sandile
    }
    @And("The user validate that George Russell finished 2nd")
    public void the_user_validate_that_george_russell_finished_2nd() {
//    Papas
    }
    @And("The user validate that Sergio Perez secured 3rd place")
    public void the_user_validate_that_sergio_perez_secured_3rd_place() {
//      Mamo
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","image");
        }

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
