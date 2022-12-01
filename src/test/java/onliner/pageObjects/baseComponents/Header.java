package onliner.pageObjects.baseComponents;

import framework.BasePage;
import framework.baseElement.Label;
import org.openqa.selenium.By;

public class Header extends BasePage {

    private static String pageLocator = "//input[@class='fast-search__input']";
    private String commonLocatorForHeaderSection = "//a[@class='b-main-navigation__link']/descendant::span[text()='%s']";

    public Header() {
        super(By.xpath(pageLocator), "Header");
    }

    public void navigateSection(String nameOfTheSection) {
        Label lblGenreOffersCategory = new Label(By.xpath(String.format(commonLocatorForHeaderSection,
                nameOfTheSection)), "Category of The Header");
        lblGenreOffersCategory.clickAndWait();
    }
}
