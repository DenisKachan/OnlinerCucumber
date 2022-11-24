package framework.baseElement;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class TextBox extends BaseElement {

    public TextBox(By loc, String name) {
        super(loc, name);
    }

    public void sendKeys(String keys) {
        elementIsPresent();
        log.info("Send text {} to the textBox", keys);
        element.sendKeys(keys);
    }
}
