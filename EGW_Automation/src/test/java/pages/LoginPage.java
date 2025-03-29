package pages;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

import java.util.List;

public class LoginPage {
    WebDriver driver;
    WaitUtils waitutils;
    BasePage basePage = new BasePage(driver);

    // Using @FindBy annotation for Page Factory
    @FindBy(xpath = "//button[contains(text(),'SIGN IN/UP')]")
    private WebElement loginButton;

    @FindBy(id="number")
    private WebElement cellPhoneNumber;

    @FindBy(xpath = "//input[@placeholder='Enter Your Number']")
    private List<WebElement> offlineMobileNumber;

    @FindBy(id="submit_authorise")
    private WebElement getOTP;

    @FindBy(id="submit_otp")
    private WebElement signIn;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private List<WebElement> continueOffline;

    public LoginPage() {
    	this.driver = BaseClass.getDriver();
        this.waitutils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
   

    public void clickLoginButton() {
    	basePage.clickElement(loginButton);
    }

    public void enterMobileNumber(String mobileNumber){
    	basePage.enterText(cellPhoneNumber, mobileNumber);
    }
   

}

