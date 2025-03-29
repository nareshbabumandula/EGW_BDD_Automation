package util;

import base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertUtils {


    public AlertUtils(WebDriver driver) {
        driver = BaseClass.getDriver();
    }

    // Waits for alert to appear and accepts it
    public static void waitForAlertAndAccept(WebDriver driver, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert appeared within " + timeoutInSeconds + " seconds.");
        }
    }

    // Waits for alert to appear and dismisses it
    public static void waitForAlertAndDismiss(WebDriver driver, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("No alert appeared within " + timeoutInSeconds + " seconds.");
        }
    }

    // Waits for alert and returns its text without accepting/dismissing
    public static String getAlertText(WebDriver driver, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (Exception e) {
            return "No alert appeared within " + timeoutInSeconds + " seconds.";
        }
    }
}
