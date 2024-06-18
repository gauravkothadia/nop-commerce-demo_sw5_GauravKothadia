package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    //logout link
    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logoutLink;

    //logout link
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink;

    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        Reporter.log("Getting the Welcome text " + welcomeText.toString());
        CustomListeners.test.log(Status.PASS, "Getting the Welcome text " + welcomeText.toString());
        return message;
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        Reporter.log("Enter email ID " + emailField.toString() + "  data: " + email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password " + passwordField.toString() + "  data: " + password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Clicking on Login link " + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
        Reporter.log("Getting the error Message " + errorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get errorMessage");
        return message;
    }

    public String getTextFromLogoutLink() {
        String logoutText = getTextFromElement(logoutLink);
        Reporter.log("Get text from logout link " + logoutLink.toString());
        CustomListeners.test.log(Status.PASS, "Get logout text");
        return logoutText;
    }

    public void clickOnLogoutLink() {
        clickOnElement(logoutLink);
        Reporter.log("Click on logout button " + logoutLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on logout link");
    }

    public String getTextFromLoginLink() {
        String loginText = getTextFromElement(loginLink);
        Reporter.log("Get text from login link " + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Get login text");
        return loginText;
    }
}
