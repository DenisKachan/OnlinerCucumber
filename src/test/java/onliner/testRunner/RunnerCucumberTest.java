package onliner.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"html:target/cucumber-report/", "json:target/cucumber.json"},
        features = "src/test/java/onliner/features",
        glue = "onliner.steps")
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {
}
