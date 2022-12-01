package onliner.pageObjects.pages;

import framework.baseElement.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

public class CataloguePage extends BaseOnlinerPage {

    private static String pageLocator = "//div[@class='catalog-navigation__title']";
    private String commonLocatorForCatalogueSection = "//ul[@class='catalog-navigation-classifier ']/descendant::" +
            "span[text()='%s']";
    private String commonLocatorForCatalogueSubSection = "//div[@class='catalog-navigation-list__aside-title']" +
            "[contains(" + NORMALIZE_SPACE_XPATH + "," + Quotes.escape("%s") + ")]";
    private String commonLocatorForSubSectionEntity = "//div[@class='catalog-navigation-list__aside-item " +
            "catalog-navigation-list__aside-item_active']//span[contains(text(),'%s')]";
    private static final String NORMALIZE_SPACE_XPATH = "normalize-space(translate(string(.),'\t\n\r\u00a0','    '))";

    public CataloguePage() {
        super(By.xpath(pageLocator), "Catalogue Page");
    }

    public void navigateCatalogueMenuSection(String nameOfTheSection) {
        Label lblCatalogueSection = new Label(By.xpath(String.format(commonLocatorForCatalogueSection,
                nameOfTheSection)), "Catalogue Section");
        lblCatalogueSection.click();
    }

    public void navigateCatalogueMenuSubSection(String nameOfTheSubSection) {
        Label lblCatalogueSubSection = new Label(By.xpath(String.format(commonLocatorForCatalogueSubSection,
                nameOfTheSubSection)), "Catalogue SubSection");
        lblCatalogueSubSection.mouseMoveToElement();
    }

    public void navigateMenuSubSectionEntity(String nameOfSubSectionEntity) {
        Label lblSubSectionEntity = new Label(By.xpath(String.format(commonLocatorForSubSectionEntity,
                nameOfSubSectionEntity)), "SubSection Entity");
        lblSubSectionEntity.clickAndWait();
    }
}
