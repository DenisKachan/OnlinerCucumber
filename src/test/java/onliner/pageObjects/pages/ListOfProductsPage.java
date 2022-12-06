package onliner.pageObjects.pages;

import framework.baseElement.*;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ListOfProductsPage extends BaseOnlinerPage {

    private static String pageLocator = "//h1[contains(@class,'schema-header')]";
    private Label lblTitleOfProduct = new Label(By.xpath("//div[@class='schema-product__title']/child::" +
            "a[contains(text(),'')]"), "Title of the product");
    private Label lblPriceOfProduct = new Label(By.xpath("//div[@class='schema-product__price']/child::a"),
            "Price of the product");
    private Label lblDescriptionOfProduct = new Label(By.xpath("//div[@class='schema-product__description']/child::span" +
            "[contains(text(),'частота матрицы')]"), "Description of the product");
    private String commonLocatorForCheckbox = "//span[text()='%s']/following::ul[@class='schema-filter__list']" +
            "/descendant::span[contains(text(),'%s')]";
    private String commonLocatorForInput = "//span[text()='%s']/following::div[@class='schema-filter__group']/child::" +
            "div/input[contains(@data-bind,'value: facet.value.";
    private String commonLocatorForDropdown = "//span[text()='%s']/following::div[@class='schema-filter__group']/child::" +
            "div/select[contains(@data-bind,'value: facet.value.";
    SoftAssert softAssert = new SoftAssert();

    public ListOfProductsPage() {
        super(By.xpath(pageLocator), "ListOfProductsPage");
    }

    public void chooseOptionOfCheckBox(String nameOfCheckboxList, String optionForCheckbox) {
        Checkbox cbxOptionOfDevice = new Checkbox(By.xpath(String.format(commonLocatorForCheckbox,nameOfCheckboxList,
                optionForCheckbox)),"Device option checkbox");
        cbxOptionOfDevice.scrollIntoView();
        cbxOptionOfDevice.clickAndWait();
    }

    private void setInputValue(String categoryOfValue, String nameOfInput, String value) {
        switch (categoryOfValue) {
            case ("min") -> categoryOfValue = "from')]";
            case ("max") -> categoryOfValue = "to')]";
        }
        TextBox tbxValue = new TextBox(By.xpath(String.format(commonLocatorForInput.concat(categoryOfValue),
                nameOfInput)), "TextBox with value");
        tbxValue.scrollIntoView();
        tbxValue.sendKeys(value);
    }

    public void setMinAndMaxInputValues(String nameOfInput, String minValue, String maxValue) {
        setInputValue("min", nameOfInput, minValue);
        setInputValue("max", nameOfInput, maxValue);
    }

    private void setDropdownValue(String categoryOfValue, String nameOfDropdown, String value) {
        switch (categoryOfValue) {
            case ("min") -> categoryOfValue = "from')]";
            case ("max") -> categoryOfValue = "to')]";
        }
        Dropdown drdValue = new Dropdown(By.xpath(String.format(commonLocatorForDropdown.concat(categoryOfValue),
                nameOfDropdown)), "Dropdown with value");
        drdValue.scrollIntoView();
        drdValue.selectValueByText(value);
    }

    public void setMinAndMaxDropdownValues(String nameOfDropdown, String minValue, String maxValue) {
        setDropdownValue("min", nameOfDropdown, minValue);
        setDropdownValue("max", nameOfDropdown, maxValue);
    }

    public void checkingTheModelOfTV(String modelOfTv) {
        lblTitleOfProduct.waitStalenessOfElement();
        BaseElements listOfProductTitles = new BaseElements(lblTitleOfProduct.getListOfElements(),
                "List of product titles");
        for (int i = 0; i < listOfProductTitles.getSize(); i++) {
            String result = listOfProductTitles.getTextFromTheElement(i);
            softAssert.assertTrue(result.contains(modelOfTv), "The models are different");
        }
    }

    public void checkingThePriceOfTV(String minPriceOfTV, String maxPriceOfTV) {
        BaseElements listOfProductPrices = new BaseElements(lblPriceOfProduct.getListOfElements(),
                "List of product prices");
        for (int i = 0; i < listOfProductPrices.getSize(); i++) {
            String result = listOfProductPrices.getTextFromTheElement(i);
            String[] arrayResult = result.split(" ");
            String priceResult = arrayResult[1].replaceAll("[,]", ".");
            double parseResult = Double.parseDouble(priceResult);
            double parseMinPrice = Double.parseDouble(minPriceOfTV);
            double parseMaxPrice = Double.parseDouble(maxPriceOfTV);
            softAssert.assertTrue(parseResult >= parseMinPrice && parseResult <= parseMaxPrice,
                    "The prices are different");
        }
    }

    public void checkingTheResolutionOfTV(String resolutionOfTv) {
        BaseElements listOfProductDescriptions = new BaseElements(lblDescriptionOfProduct.getListOfElements(),
                "List of product description");
        for (int i = 0; i < listOfProductDescriptions.getSize(); i++) {
            String result = listOfProductDescriptions.getTextFromTheElement(i);
            softAssert.assertTrue(result.contains(resolutionOfTv), "The resolutions are different ");
        }
    }

    public void checkingSizeOfTV(String minSizeOfTV, String maxSizeOfTV) {
        BaseElements listOfProductDescriptions = new BaseElements(lblDescriptionOfProduct.getListOfElements(),
                "List of product description");
        for (int i = 0; i < listOfProductDescriptions.getSize(); i++) {
            String result = listOfProductDescriptions.getTextFromTheElement(i);
            String[] arrayResult = result.split("\"");
            String sizeResult = arrayResult[0];
            int parseResult = Integer.parseInt(sizeResult);
            int parseMinSize = Integer.parseInt(minSizeOfTV.replaceAll("[\"]", ""));
            int parseMaxSize = Integer.parseInt(maxSizeOfTV.replaceAll("[\"]", ""));
            softAssert.assertTrue(parseResult >= parseMinSize && parseResult <= parseMaxSize,
                    "The sizes are different ");
        }
    }
}
