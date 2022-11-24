package onliner.pageObjects.pages;

import org.openqa.selenium.By;

public class MainPage extends BaseOnlinerPage {

    private static String pageLocator = "//header[contains(@class,'main-page-blocks-header')]";

    public MainPage() {
        super(By.xpath(pageLocator), "MainPage");
    }
}
