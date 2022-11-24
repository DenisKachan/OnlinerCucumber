package onliner.pageObjects.pages;

import framework.baseElement.*;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ListOfProductsPage extends BaseOnlinerPage {

    private static String pageLocator = "//h1[contains(@class,'schema-header')]";
    private Label lblTitleOfProduct = new Label(By.xpath("//div[@class='schema-product__title']/child::a[contains(text(),'')]"), "Title of the product");
    private Label lblPriceOfProduct = new Label(By.xpath("//div[@class='schema-product__price']/child::a"), "Price of the product");
    private Label lblDescriptionOfProduct = new Label(By.xpath("//div[@class='schema-product__description']/child::span[contains(text(),'частота матрицы')]"), "Description of the product");
    private String commonLocatorForCheckboxList = "//span[text()='%s']/following::ul[@class='schema-filter__list']";
    private String commonLocatorForCheckboxOption = "/descendant::span[contains(text(),'%s')]";
    private String commonLocatorForMinValueRangeInput = "//span[text()='%s']/following::div[@class='schema-filter__group']/child::div/input[contains(@data-bind,'value: facet.value.from')]";
    private String commonLocatorForMaxValueRangeInput = "//span[text()='%s']/following::div[@class='schema-filter__group']/child::div/input[contains(@data-bind,'value: facet.value.to')]";
    private String commonLocatorForMinValueDropdown = "//span[text()='%s']/following::div[@class='schema-filter__group']/child::div/select[contains(@data-bind,'value: facet.value.from')]";
    private String commonLocatorForMaxValueDropdown = "//span[text()='%s']/following::div[@class='schema-filter__group']/child::div/select[contains(@data-bind,'value: facet.value.to')]";
    SoftAssert softAssert = new SoftAssert();

    public ListOfProductsPage() {
        super(By.xpath(pageLocator), "ListOfProductsPage");
    }

    public void chooseOptionOfCheckBox(String nameOfCheckboxList, String optionForCheckbox) {
        Checkbox cbxOptionOfDevice = new Checkbox(By.xpath(String.format(commonLocatorForCheckboxList, nameOfCheckboxList).concat(String.format(commonLocatorForCheckboxOption, optionForCheckbox))), "Device option checkbox");
        cbxOptionOfDevice.scrollIntoView();
        cbxOptionOfDevice.clickAndWait();
    }

    public void setValuesInRangeInput(String nameOfInput, String minimumValue, String maximumValue) {
        TextBox tbxMinValueOptionOfDevice = new TextBox(By.xpath(String.format(commonLocatorForMinValueRangeInput, nameOfInput)), "TextBox with minimum value");
        TextBox tbxMaxValueOptionOfDevice = new TextBox(By.xpath(String.format(commonLocatorForMaxValueRangeInput, nameOfInput)), "TextBox with maximum value");
        tbxMinValueOptionOfDevice.scrollIntoView();
        tbxMinValueOptionOfDevice.sendKeys(minimumValue);
        tbxMaxValueOptionOfDevice.sendKeys(maximumValue);
    }

    public void setValuesInDropdown(String nameOfDropdown, String minimumValue, String maximumValue) {
        Dropdown drdMinValueOptionOfDevice = new Dropdown(By.xpath(String.format(commonLocatorForMinValueDropdown, nameOfDropdown)), "Dropdown with minimum value");
        Dropdown drdMaxValueOptionOfDevice = new Dropdown(By.xpath(String.format(commonLocatorForMaxValueDropdown, nameOfDropdown)), "Dropdown with maximum value");
        drdMinValueOptionOfDevice.scrollIntoView();
        if (nameOfDropdown.equals("Диагональ")) {
            drdMinValueOptionOfDevice.selectValueByText(minimumValue + "\"");
            drdMaxValueOptionOfDevice.selectValueByText(maximumValue + "\"");
        } else {
            drdMinValueOptionOfDevice.selectValueByText(minimumValue);
            drdMaxValueOptionOfDevice.selectValueByText(maximumValue);
        }
    }

    public void checkingTheModelOfTV(String modelOfTv) {
        lblTitleOfProduct.waitStalenessOfElement();
        BaseElements listOfProductTitles = new BaseElements(lblTitleOfProduct.getListOfElements(), "List of product titles");
        for (int i = 0; i < listOfProductTitles.getSize(); i++) {
            String result = listOfProductTitles.getTextFromTheElement(i);
            softAssert.assertTrue(result.contains(modelOfTv), "The models are different");
        }

    }

    public void checkingThePriceOfTV(String minPriceOfTV, String maxPriceOfTV) {
        BaseElements listOfProductPrices = new BaseElements(lblPriceOfProduct.getListOfElements(), "List of product prices");
        for (int i = 0; i < listOfProductPrices.getSize(); i++) {
            String result = listOfProductPrices.getTextFromTheElement(i);
            String[] arrayResult = result.split(" ");
            String priceResult = arrayResult[1].replaceAll("[,]", ".");
            double parseResult = Double.parseDouble(priceResult);
            double parseMinPrice = Double.parseDouble(minPriceOfTV);
            double parseMaxPrice = Double.parseDouble(maxPriceOfTV);
            softAssert.assertTrue(parseResult >= parseMinPrice && parseResult <= parseMaxPrice, "The prices are different");
        }
    }

    public void checkingTheResolutionOfTV(String resolutionOfTv) {
        BaseElements listOfProductDescriptions = new BaseElements(lblDescriptionOfProduct.getListOfElements(), "List of product description");
        for (int i = 0; i < listOfProductDescriptions.getSize(); i++) {
            String result = listOfProductDescriptions.getTextFromTheElement(i);
            softAssert.assertTrue(result.contains(resolutionOfTv), "The resolutions are different ");
        }
    }

    public void checkingSizeOfTV(String minSizeOfTV, String maxSizeOfTV) {
        BaseElements listOfProductDescriptions = new BaseElements(lblDescriptionOfProduct.getListOfElements(), "List of product description");
        for (int i = 0; i < listOfProductDescriptions.getSize(); i++) {
            String result = listOfProductDescriptions.getTextFromTheElement(i);
            String[] arrayResult = result.split("\"");
            String sizeResult = arrayResult[0];
            int parseResult = Integer.parseInt(sizeResult);
            int parseMinSize = Integer.parseInt(minSizeOfTV);
            int parseMaxSize = Integer.parseInt(maxSizeOfTV);
            softAssert.assertTrue(parseResult >= parseMinSize && parseResult <= parseMaxSize, "The sizes are different ");
        }
    }
}
