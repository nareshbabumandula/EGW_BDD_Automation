package pages;

import base.BaseClass;
import common.CommonFunctions;
import io.cucumber.java.Scenario;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class StoreSearchPage {

    WebDriver driver;
    CommonFunctions commonfunctions;
    WaitUtils waitutils;
    BasePage basePage = new BasePage(driver);

    @FindBy(id = "inputStoreValue")
    private WebElement txtStoreSearch;

    @FindBy(xpath = "//button[contains(text(),'Find a Store')]")
    private WebElement btnSearch;
    
    @FindBy(xpath="//h2[@class='hide12']/span[@class='reccount']")
    private WebElement noOfLocationsNearStore;
    
    @FindBy(xpath="(//a[contains(text(),'Get Directions ')])[1]")
    private WebElement getDirections;
    
    @FindBy(xpath="(//a[contains(text(),'Schedule Exam')])[1]")
    private WebElement scheduleExam;
    
    @FindBy(xpath="(//a[contains(text(),'Visit Store Page')])[1]")
    private WebElement visitStorePage;
    
    @FindBy(xpath="(//div[contains(text(),'Eye exams provided by')])[1]")
    private WebElement eyeExamProvidedBy;
         
        		
    public void enterStore(String store) {
    	basePage.enterText(txtStoreSearch, store);
    }
    
    public void clickFindaStore() {
    	basePage.clickElement(btnSearch);
    }
    
    public void verifySearchResults(Scenario scenario) {
        waitutils.waitForElementToBeVisible(noOfLocationsNearStore);
        String noLocations = noOfLocationsNearStore.getText();
        
        System.out.println("No of locations near searched store are: " + noLocations);

        // Check if scenario is null before attaching logs
        if (scenario != null) {
            scenario.attach("No of locations near searched store: " + noLocations, "text/plain", "Store Count");
        } else {
            System.out.println("WARNING: Scenario is null, skipping attach.");
        }

        // Verify elements and log output
        verifyElementDisplayed(getDirections, "Get Directions", scenario);
        verifyElementDisplayed(scheduleExam, "Schedule Exam", scenario);
        //verifyElementDisplayed(visitStorePage, "Visit Store Page", scenario);
        verifyElementDisplayed(eyeExamProvidedBy, "Eye Exam Provided By", scenario);
    }

    private void verifyElementDisplayed(WebElement element, String elementName, Scenario scenario) {
        boolean isDisplayed = basePage.isElementDisplayed(element);

        if (isDisplayed) {
            System.out.println(elementName + " is displayed.");
            if (scenario != null) {
                scenario.attach(elementName + " is displayed.", "text/plain", elementName);
            }
        } else {
            System.out.println(elementName + " is NOT displayed!");
            if (scenario != null) {
                scenario.attach(elementName + " is NOT displayed!", "text/plain", elementName);
            }
        }

        Assert.assertTrue(elementName + " should be displayed.", isDisplayed);
    }

              
    public StoreSearchPage() {
        this.driver = BaseClass.getDriver();
        this.waitutils = new WaitUtils(driver);
        this.commonfunctions = new CommonFunctions(driver);
        PageFactory.initElements(driver, this);
    }
    
       
    
}
