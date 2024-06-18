package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {

    //processor
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processor;

    //RAM
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ram;

    //HDD 320 GB
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'320 GB')]/preceding-sibling::input")
    WebElement hdd320GB;

    //HDD 400 GB
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'400 GB')]/preceding-sibling::input")
    WebElement hdd400GB;

    //OS Vista Home
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'Vista Home')]/preceding-sibling::input")
    WebElement osVistaHome;

    //OS Vista Premium
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'Vista Premium')]/preceding-sibling::input")
    WebElement osVistaPremium;

    //software MS Office
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'Microsoft Office')]/preceding-sibling::input")
    WebElement softwareCheckboxMSOffice;

    //software Acrobat Reader
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'Acrobat Reader')]/preceding-sibling::input")
    WebElement softwareCheckboxAcrobatReader;

    //software Total Commander
    @CacheLookup
    @FindBy(xpath = "//label[contains(normalize-space(),'Total Commander')]/preceding-sibling::input")
    WebElement softwareCheckboxTotalCommander;

    //Add to cart
    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCart;

    //Add to cart
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productAddSuccessMessage;


    public void selectProcessorFromDropdown(String valueOfProcessor) {
        selectByVisibleTextFromDropDown(processor, valueOfProcessor);
        Reporter.log("Get value of processor: " + valueOfProcessor + "from dropdown " + processor.toString());
        CustomListeners.test.log(Status.PASS, "Get title text for computers page");

    }

    public void selectRamFromDropdown(String valueOfRam) {
        selectByVisibleTextFromDropDown(ram, valueOfRam);
        Reporter.log("Get value of ram: " + valueOfRam + "from dropdown " + ram.toString());
        CustomListeners.test.log(Status.PASS, "Get title text for computers page");
    }

    public void clickOnHdd(String hddInfo) {
        switch (hddInfo.split("\\[")[0].trim()) {
            case "320 GB": {
                clickOnElement(waitForElementWithFluentWait(hdd320GB,10,2));
                Reporter.log("Click on HDD " + hddInfo + " " + hdd320GB.toString());
                CustomListeners.test.log(Status.PASS, "Click on HDD " + hddInfo);
                break;
            }
            case "400 GB": {
                clickOnElement(waitForElementWithFluentWait(hdd400GB,10,2));
                Reporter.log("Click on HDD " + hddInfo + " " + hdd400GB.toString());
                CustomListeners.test.log(Status.PASS, "Click on HDD " + hddInfo);
                break;
            }
            default: {
                Reporter.log("HDD is not in catalogue " + hddInfo);
                CustomListeners.test.log(Status.FAIL, "HDD is not in the catalogue " + hddInfo);
            }
        }
    }

    public void clickOnOs(String osInfo) {
        switch (osInfo.split("\\[")[0].trim()) {
            case "Vista Home": {
                clickOnElement(waitForElementWithFluentWait(osVistaHome,10,2));
                Reporter.log("Click on OS " + osInfo + " " + osVistaHome.toString());
                CustomListeners.test.log(Status.PASS, "Click on OS " + osInfo);
                break;
            }
            case "Vista Premium": {
                clickOnElement(waitForElementWithFluentWait(osVistaPremium,10,2));
                Reporter.log("Click on OS " + osInfo + " " + osVistaPremium.toString());
                CustomListeners.test.log(Status.PASS, "Click on OS " + osInfo);
                break;
            }
            default: {
                Reporter.log("OS is not in catalogue " + osInfo);
                CustomListeners.test.log(Status.FAIL, "OS not in the catalogue " + osInfo);
            }
        }
    }

    public void clickOnSoftwareCheckbox(String software) {
        switch (software.split("\\[")[0].trim()) {
            case "Microsoft Office": {
                if (!softwareCheckboxMSOffice.isSelected()) {
                    clickOnElement(waitForElementWithFluentWait(softwareCheckboxMSOffice,10,2));
                }
                Reporter.log("software " + software + " is selected " + softwareCheckboxMSOffice.toString());
                CustomListeners.test.log(Status.PASS, "software selected : " + software);
                break;
            }
            case "Acrobat Reader": {
                if (softwareCheckboxMSOffice.isSelected()) { //-------to untick default tick when page is loaded-----
                    clickOnElement(waitForElementWithFluentWait(softwareCheckboxMSOffice,10,2));
                }
                if (!softwareCheckboxAcrobatReader.isSelected()) {
                    clickOnElement(waitForElementWithFluentWait(softwareCheckboxAcrobatReader,10,2));
                }
                Reporter.log("software " + software + " is selected " + softwareCheckboxAcrobatReader.toString());
                CustomListeners.test.log(Status.PASS, "software selected : " + software);
                break;
            }
            case "Total Commander": {
                if (softwareCheckboxMSOffice.isSelected()) { //-------to untick default tick when page is loaded-----
                    clickOnElement(waitForElementWithFluentWait(softwareCheckboxMSOffice,10,2));
                }
                if (!softwareCheckboxTotalCommander.isSelected()) {
                    clickOnElement(waitForElementWithFluentWait(softwareCheckboxTotalCommander,10,2));
                }
                Reporter.log("software " + software + " is selected " + softwareCheckboxTotalCommander.toString());
                CustomListeners.test.log(Status.PASS, "software selected : " + software);
                break;
            }
            default: {
                Reporter.log("Software is not in catalogue " + software);
                CustomListeners.test.log(Status.FAIL, "Software not in the catalogue " + software);
            }
        }
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
        Reporter.log("Click on add to cart button " + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "Click on add to cart");
    }

    public String getTextFromProductAddSuccessMessage() {
        String name = getTextFromElement(productAddSuccessMessage);
        Reporter.log("Get text from product added success message " + productAddSuccessMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get text from product added success message");
        return name;
    }
}
