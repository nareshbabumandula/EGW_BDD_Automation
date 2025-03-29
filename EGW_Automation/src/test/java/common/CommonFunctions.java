package common;

import base.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WaitUtils;

import java.time.Duration;

public class CommonFunctions {

    private WebDriver driver;
    WaitUtils waitutils;

    public CommonFunctions(WebDriver driver) {
        this.driver = BaseClass.getDriver();
        this.waitutils = new WaitUtils(driver);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            waitutils.waitForElementToBeVisible(element);
            return element != null && element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Element not found or stale: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error checking element visibility: " + e.getMessage());
            return false;
        }
    }
}
