package onliner.testRunner;

import framework.Browser;
import framework.utils.PropertyReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        plugin = {"html:target/cucumber-report/", "json:target/cucumber.json"},
        features = "src/test/java/onliner/features",
        glue = "onliner.steps")
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {

    protected static Browser browser;

    @BeforeMethod
    public void before() {
        browser = Browser.getInstance();
        browser.navigateToURL(new PropertyReader("config.properties").getProperty("baseUrl"));
    }

    @AfterMethod
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
