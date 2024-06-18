package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {

    //product
    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']/a")
    WebElement product;

    //desktops Text
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;

    public void clickOnProductName(){
        clickOnElement(product);
        Reporter.log("Click on product name " + product.toString());
        CustomListeners.test.log(Status.PASS, "Click on product name");
    }

    public String getTextFromMenuPageTitle(){
        String name = getTextFromElement(desktopsText);
        Reporter.log("Get title text for desktops page " + desktopsText.toString());
        CustomListeners.test.log(Status.PASS, "Get title text for desktops page");
        return name;
    }
}
