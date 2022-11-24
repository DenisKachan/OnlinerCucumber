package onliner.pageObjects.pages;

import framework.BasePage;
import onliner.pageObjects.baseComponents.Header;
import org.openqa.selenium.By;

public class BaseOnlinerPage extends BasePage {

    protected BaseOnlinerPage(By locator, String name) {
        super(locator, name);
    }

    public Header getHeader() {
        return new Header();
    }
}
