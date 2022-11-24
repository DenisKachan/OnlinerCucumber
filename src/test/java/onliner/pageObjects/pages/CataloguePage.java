package onliner.pageObjects.pages;

import framework.baseElement.Label;
import org.openqa.selenium.By;

public class CataloguePage extends BaseOnlinerPage {

    private static String pageLocator = "//div[@class='catalog-navigation__title']";
    private String commonLocatorForCatalogueSection = "//ul[@class='catalog-navigation-classifier ']/descendant::span[text()='%s']";
    private String commonLocatorForCatalogueSubSection = "//div[@class='catalog-navigation-list__aside-title'][contains(text(),'%s')]";
    private String commonLocatorForSubSectionEntity = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//span[contains(text(),'%s')]";

    public CataloguePage() {
        super(By.xpath(pageLocator), "Catalogue Page");
    }

    public void navigateCatalogueSection(String nameOfTheSection) {
        Label lblCatalogueSection = new Label(By.xpath(String.format(commonLocatorForCatalogueSection, nameOfTheSection)), "Catalogue Section");
        lblCatalogueSection.click();
    }

    public void navigateCatalogueSubSection(String nameOfTheSubSection) {
        Label lblCatalogueSubSection;
        if (nameOfTheSubSection.equals("Телевидение и видео")) {
            lblCatalogueSubSection = new Label(By.xpath(String.format(commonLocatorForCatalogueSubSection, nameOfTheSubSection.substring(0, 11))), "Catalogue SubSection");
        } else {
            lblCatalogueSubSection = new Label(By.xpath(String.format(commonLocatorForCatalogueSubSection, nameOfTheSubSection)), "Catalogue SubSection");
        }
        lblCatalogueSubSection.mouseMoveToElement();
    }

    public void navigateSubSectionEntity(String nameOfSubSectionEntity) {
        Label lblSubSectionEntity = new Label(By.xpath(String.format(commonLocatorForSubSectionEntity, nameOfSubSectionEntity)), "SubSection Entity");
        lblSubSectionEntity.clickAndWait();
    }
}
