package TestCases;

import PageObjects.HomePage;
import PageObjects.WebDriverRun;
import org.testng.annotations.Test;

public class UIBtnVerificationTestCase extends WebDriverRun {

    /*
    1. Open Home Page (in Before Method)
    2. Click on UI Testing icon
    3. Check that URL correspond to expected
    4. Check that Logo and Title are displayed and correspond to expected
    */

    @Test(groups = {"DoclerTestCases"})
    public void clickOnUIbuttonAndCheckURL()throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.clickOnUIBtnCheckURL(driver);
        homePage.verifyPageTitle(driver);
        homePage.verifyLogoIsPresent(driver);
    }

}
