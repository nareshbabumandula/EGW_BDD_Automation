package pages;

import base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = BaseClass.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    //  Reusable method for entering text
    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    //  Reusable method for clicking elements
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Reusable method for clicking elements using JavaScriptExecutor
    public void clickElementUsingJS(WebElement element) {
        try {
            if (element != null) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                System.out.println("Clicked using JavaScriptExecutor.");
            } else {
                System.out.println("Element is null. Cannot click using JavaScriptExecutor.");
            }
        } catch (Exception e) {
            System.out.println("Failed to click using JavaScriptExecutor. " + e.getMessage());
        }
    }


    // Click element only if it exists and is clickable
    public void clickElementIfExists(WebElement element) {
        try {
            if (element != null && element.isDisplayed() && element.isEnabled()) {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Element clicked successfully.");
            } else {
                System.out.println("Element exists but is not visible or enabled.");
            }
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Element does not exist, skipping click.");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is stale, trying to locate again.");
        }
    }



    //  Reusable method for selecting from dropdowns by visible text
    public void selectDropdownByText(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Select(element).selectByVisibleText(value);
    }

    //  Reusable method for selecting from dropdowns by index
    public void selectDropdownByIndex(WebElement element, int index) {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Select(element).selectByIndex(index);
    }

    //  Reusable method for selecting from dropdowns by value
    public void selectDropdownByValue(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Select(element).selectByValue(value);
    }

    //  Reusable method for getting text from an element
    public String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    //  Reusable method for checking if element is displayed
    public boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //  Reusable method for checking if element is enabled
    public boolean isElementEnabled(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Reusable method for waiting until an element is present
    public void waitForElementToBePresent(WebElement element) {
        wait.until(ExpectedConditions.presenceOfElementLocated((org.openqa.selenium.By) element));
    }

    // Reusable method for waiting until an element is invisible
    public void waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void selectCheckbox(WebElement checkbox, boolean shouldSelect){
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        if(checkbox.isSelected()!=shouldSelect){
            checkbox.click();
        }
    }


    // Reusable method to switch to an iframe by WebElement
    public void switchToIframe(WebElement iframeElement) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
    }

    // Reusable method to switch to an iframe by index
    public void switchToIframeByIndex(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    // Reusable method to switch to an iframe by name or ID
    public void switchToIframeByNameOrId(String nameOrId) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
    }

    // Reusable method to switch back to the default content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Reusable method to switch to the parent frame
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
}
