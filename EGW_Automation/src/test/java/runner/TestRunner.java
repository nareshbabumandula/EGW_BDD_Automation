package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", glue = "steps", tags = "@smoke",monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"})
public class TestRunner {

}
