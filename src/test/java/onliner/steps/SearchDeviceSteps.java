package onliner.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObjects.pages.CataloguePage;
import onliner.pageObjects.pages.ListOfProductsPage;
import onliner.pageObjects.pages.MainPage;
import org.testng.asserts.SoftAssert;

public class SearchDeviceSteps {

    private static MainPage mainPage;
    private static CataloguePage cataloguePage;
    private static ListOfProductsPage listOfProductsPage;
    SoftAssert softAssert = new SoftAssert();

    @Given("Onliner web-site start page is opened")
    public void onlinerWebSiteStartPageIsOpened() {
        mainPage = new MainPage();
    }

    @When("user navigates to the menu section {string}")
    public void navigateToTheMenuSection(String menuSection) {
        mainPage.getHeader().navigateSection(menuSection);
    }


    @And("user navigates from catalogue section {string} to the catalogue sub section {string} and chooses {string}")
    public void chooseCatalogueSubSectionEntity(String catalogueSection, String catalogueSubSection,
                                                String subSectionEntity) {
        cataloguePage = new CataloguePage();
        cataloguePage.navigateCatalogueMenuSection(catalogueSection);
        cataloguePage.navigateCatalogueMenuSubSection(catalogueSubSection);
        cataloguePage.navigateMenuSubSectionEntity(subSectionEntity);
    }

    @And("user sets {string} as {string}, {string} as {string}, {string} and {string} in the inputs of {string}, " +
            "{string} and {string} as {string}")
    public void setProductParameters(String optionOfCheckbox, String nameOfCheckbox, String optionOfCheckbox1,
                                     String nameOfCheckbox1, String minValueOfInput, String maxValueOfInput,
                                     String nameOfInput, String minValueOfDropdown, String maxValueOfDropdown,
                                     String nameOfDropdown) {
        listOfProductsPage = new ListOfProductsPage();
        listOfProductsPage.chooseOptionOfCheckBox(nameOfCheckbox, optionOfCheckbox);
        listOfProductsPage.chooseOptionOfCheckBox(nameOfCheckbox1, optionOfCheckbox1);
        listOfProductsPage.setMinAndMaxInputValues(nameOfInput,minValueOfInput,maxValueOfInput);
        listOfProductsPage.setMinAndMaxDropdownValues(nameOfDropdown,minValueOfDropdown,maxValueOfDropdown);
    }

    @Then("the product should meet established criteria of {string}, {string}, {string}, {string}, {string} and {string}")
    public void checkResultToMeetEstablishedCriteria(String model, String resolution, String minPrice, String maxPrice,
                                                     String minSize, String maxSize) {
        listOfProductsPage.checkingTheModelOfTV(model);
        listOfProductsPage.checkingTheResolutionOfTV(resolution);
        listOfProductsPage.checkingThePriceOfTV(minPrice, maxPrice);
        listOfProductsPage.checkingSizeOfTV(minSize, maxSize);
        softAssert.assertAll();
    }
}
