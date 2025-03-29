package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.ConfigReader;
import java.util.Map;

public class BaseClass {
    private static WebDriver driver;

    private BaseClass() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browserType");
        if (driver == null) {
            switch (browser.toLowerCase().trim()) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-save-password-bubble");
                    options.addArguments("--disable-autofill-keyboard-accessory-view");

                    // Disable Chrome autofill features
                    options.setExperimentalOption("prefs", Map.of(
                            "profile.default_content_setting_values.notifications", 2,
                            "credentials_enable_service", false,
                            "profile.password_manager_enabled", false,
                            "autofill.credit_card_enabled", false,
                            "excludeSwitches", new String[]{"enable-automation"}
                    ));
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> {
                    EdgeOptions options = new EdgeOptions();
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    driver = new EdgeDriver(options);
                }
            }
            assert driver != null;
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
