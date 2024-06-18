package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.excelutility.ExcelUtility;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelData.xlsx";
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @BeforeClass(alwaysRun = true)
    public void setExcel() {
        //Tell the code the location of the excel file
        try {
            ExcelUtility.setExcelFile(FILE_PATH, "ProductTests");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getDate() {
        return ExcelUtility.getTestData("Invalid_Product");
    }

    @Test(groups = {"regression", "sanity"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputersMenuLink();
        //Verify "Computer" text
        Assert.assertEquals(computerPage.getTextFromMenuPageTitle(), "Computers", "Page is not redirected properly.");
    }

    @Test(groups = {"regression", "sanity", "smoke"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputersMenuLink();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Verify "Desktops" text
        Assert.assertEquals(desktopsPage.getTextFromMenuPageTitle(), "Desktops", "Page is not redirected properly.");
    }

    @Test(dataProvider = "dataFromExcel", groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) throws InterruptedException {
        //Click on Computer tab
        homePage.clickOnComputersMenuLink();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Click on product name "Build your own computer"
        desktopsPage.clickOnProductName();
        //Select processor "processor"
        buildYourOwnComputerPage.selectProcessorFromDropdown(processor);
        //Select RAM "ram"
        buildYourOwnComputerPage.selectRamFromDropdown(ram);
        //Select HDD "hdd"
        buildYourOwnComputerPage.clickOnHdd(hdd);
        //Select OS "os"
        buildYourOwnComputerPage.clickOnOs(os);
        //Select Software "software"
        buildYourOwnComputerPage.clickOnSoftwareCheckbox(software);
        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCart();
        Thread.sleep(3000);
        //Verify message "The product has been added to your shopping cart"
        Assert.assertEquals(buildYourOwnComputerPage.getTextFromProductAddSuccessMessage(), "The product has been added to your shopping cart", "Product is not added into shopping cart");
    }
}
