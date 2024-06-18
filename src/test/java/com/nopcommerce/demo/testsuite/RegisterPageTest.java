package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"regression","sanity", "smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Verify "Register" text
        Assert.assertEquals(registerPage.getTextOfRegister(), "Register", "Page not redirected successfully");
    }
    @Test(groups = {"regression", "smoke"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() throws InterruptedException {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        Thread.sleep(3000);
        //Verify the error message "First name is required."
        Assert.assertEquals(registerPage.getTextOfFirstName(), "First name is required.","Page is not redirected successfully");
        //Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.getTextOfLastName(), "Last name is required.","Page is not redirected successfully");
        //Verify the error message "Email is required."
        Assert.assertEquals(registerPage.getTextOfEmail(), "Email is required.","Page is not redirected successfully");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getTextOfPassword(), "Password is required.","Page is not redirected successfully");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getTextOfConfirmPassword(), "Password is required.","Page is not redirected successfully");
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Select gender "Female"
        registerPage.clickOnGenderFemale();
        //Enter firstname
        registerPage.enterValueToFirstNameField("abc");
        //Enter lastname
        registerPage.enterValueToLastNameField("xyz");
        //Select day
        registerPage.selectDay("4");
        //Select month
        registerPage.selectMonth("4");
        //Select year
        registerPage.selectYear("1944");
        //Enter email
        registerPage.enterValueToEmailField("a4bc@gmail.com");
        //Enter password
        registerPage.enterValueToPasswordField("123456");
        //Enter Confirm Password
        registerPage.enterValueToConfirmPasswordField("123456");
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        Thread.sleep(6000);
        //Verify message "Your registration completed"
        Assert.assertEquals(registerPage.getValueOfRegistrationSuccessMessage(), "Your registration completed", "Registration is not successful.");
    }
}
