package onliner.steps;

import framework.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObjects.pages.CataloguePage;
import onliner.pageObjects.pages.ListOfProductsPage;
import onliner.pageObjects.pages.MainPage;
import org.testng.asserts.SoftAssert;

public class SearchDeviceSteps {

    private static Browser browser;
    SoftAssert softAssert = new SoftAssert();

    @Given("browser is launched")
    public void browserIsLaunched() {
        browser = Browser.getInstance();
    }

    @And("Onliner web-site start page is opened")
    public void onlinerWebSiteStartPageIsOpened() {
        browser.navigateToURL("baseUrl");
    }

    @When("user navigates to the menu section {string}")
    public void userNavigatesToTheMenuSection(String menuSection) {
        MainPage mainPage = new MainPage();
        mainPage.getHeader().navigateSection(menuSection);
    }

    @And("user navigates to the catalogue section {string}")
    public void userNavigatesToTheCatalogueSection(String catalogueSection) {
        CataloguePage cataloguePage = new CataloguePage();
        cataloguePage.navigateCatalogueSection(catalogueSection);
    }

    @And("user chooses catalogue sub section {string}")
    public void userChoosesCatalogueSubSection(String catalogueSubSection) {
        CataloguePage cataloguePage = new CataloguePage();
        cataloguePage.navigateCatalogueSubSection(catalogueSubSection);
    }

    @And("user chooses sub section entity {string}")
    public void userChoosesSubSectionEntity(String subSectionEntity) {
        CataloguePage cataloguePage = new CataloguePage();
        cataloguePage.navigateSubSectionEntity(subSectionEntity);
    }


    @And("user chooses {string} in the checkbox list {string}")
    public void userChoosesInTheCheckboxList(String optionOfCheckbox, String nameOfCheckbox) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.chooseOptionOfCheckBox(nameOfCheckbox, optionOfCheckbox);
    }

    @And("user sets {string} and {string} in the range inputs {string}")
    public void userSetsAndInTheRangeInputs(String minValueOfInput, String maxValueOfInput, String nameOfInput) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.setValuesInRangeInput(nameOfInput, minValueOfInput, maxValueOfInput);
    }

    @And("user sets {string} and {string} in the dropdown {string}")
    public void userSetsAndInTheDropdown(String minSize, String maxSize, String nameOfDropdown) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.setValuesInDropdown(nameOfDropdown, minSize, maxSize);
    }

    @Then("the producer of the product should be {string}")
    public void theProducerShouldBe(String modelOfTV) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.checkingTheModelOfTV(modelOfTV);
    }

    @And("the resolution of the product should be {string}")
    public void theResolutionShouldBe(String resolutionOfTV) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.checkingTheResolutionOfTV(resolutionOfTV);
    }

    @And("the price of the product should be between {string} and {string}")
    public void thePriceShouldBeBetweenAnd(String minPrice, String maxPrice) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.checkingThePriceOfTV(minPrice, maxPrice);
    }

    @And("the size of the product should be between {string} and {string}")
    public void theSizeShouldBeBetweenAnd(String minSize, String maxSize) {
        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.checkingSizeOfTV(minSize, maxSize);
    }

    @And("user closes browser")
    public void userClosesBrowser() {
        softAssert.assertAll();
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
