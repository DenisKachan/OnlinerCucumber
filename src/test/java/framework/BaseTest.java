package framework;

import framework.utils.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Log4j2
public abstract class BaseTest {

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
