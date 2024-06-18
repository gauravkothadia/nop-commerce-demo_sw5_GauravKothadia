package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToLoginPage() {
        //Click on login link
        homePage.clickOnLoginLink();
        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //  Enter EmailId
        loginPage.enterEmailId("prime1234@gmail.com");
        //  Enter Password
        loginPage.enterPassword("prime123abc");
        //  Click on Login Button
        loginPage.clickOnLoginButton();
        //  Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailId("prime123@gmail.com");
        //Enter Password
        loginPage.enterPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that LogOut link is display
        Assert.assertEquals(loginPage.getTextFromLogoutLink(), "Log out", "Page is not redirected properly");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully(){
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailId("prime123@gmail.com");
        //Enter Password
        loginPage.enterPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Click on LogOut Link
        loginPage.clickOnLogoutLink();
        //Verify that LogIn Link Display
        Assert.assertEquals(loginPage.getTextFromLoginLink(), "Log in", "Logout not working");
    }
}
