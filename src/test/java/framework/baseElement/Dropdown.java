package framework.baseElement;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class Dropdown extends BaseElement {

    public Dropdown(By loc, String name) {
        super(loc, name);
    }

    public void selectValueByText(String text) {
        elementIsPresent();
        Select select = new Select(element);
        log.info("Select a dropdown item by text {}", text);
        select.selectByVisibleText(text);
    }
}
