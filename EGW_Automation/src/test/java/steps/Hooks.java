package steps;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Starting a new scenario..!");
        BaseClass.getDriver();
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on Failure");
        }
    }

    @After
    public void quitDriver() throws InterruptedException {
        if (BaseClass.getDriver() != null) {
            System.out.println("Quitting browser...");
            Thread.sleep(6000);
            BaseClass.quitDriver();
            System.out.println("Browser closed.");
        } else {
            System.out.println("Driver is already null.");
        }
    }
}
