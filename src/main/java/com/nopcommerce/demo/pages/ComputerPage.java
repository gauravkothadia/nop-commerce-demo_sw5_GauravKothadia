package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {


    //computer Text
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computersText;

    //desktop link
    @CacheLookup
    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopsLink;



    public String getTextFromMenuPageTitle(){
        String name = getTextFromElement(computersText);
        Reporter.log("Get title text for computers page " + computersText.toString());
        CustomListeners.test.log(Status.PASS, "Get title text for computers page");
        return name;
    }

    public void clickOnDesktopsLink(){
        clickOnElement(desktopsLink);
        Reporter.log("Click on desktops link " + desktopsLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on desktops link");
    }
}
