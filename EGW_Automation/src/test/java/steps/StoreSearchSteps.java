package steps;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import common.CommonFunctions;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StoreSearchPage;
import util.ConfigReader;

public class StoreSearchSteps {

    private WebDriver driver = BaseClass.getDriver();
    CommonFunctions commonfunctions;
    ConfigReader reader;
    StoreSearchPage sp = new StoreSearchPage();
    private Scenario scenario;
    
    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;  // Assign scenario object
    }

    @Given("I access eyeglassworld portal")
    public void i_access_eyeglassworld_portal() {
        String url = reader.getProperty("baseURL");
    	driver.get(url);
    	driver.manage().window().maximize();
    }

    
    @When("I enter the city name as {string} in the store search text field")
    public void enterStoreCityStateZipcode(String string) {
        sp.enterStore(string);
    }
    
    @When("I click on search button")
    public void i_click_on_search_button() {
       sp.clickFindaStore();
    }
    
    @Then("I should see the appropriate search results")
    public void i_should_see_the_appropriate_search_results() {
        sp.verifySearchResults(scenario);
    }




}
