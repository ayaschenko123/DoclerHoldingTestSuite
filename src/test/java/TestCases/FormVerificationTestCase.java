package TestCases;

import PageObjects.HomePage;
import PageObjects.WebDriverRun;
import org.testng.annotations.Test;

public class FormVerificationTestCase extends WebDriverRun{

    /*
    1. Open Home Page (in Before Method)
    2. Click on Form icon
    3. Check that all needed form alements are displayed
    */

    @Test(groups = {"DoclerTestCases"})
    public void checkFormElementsAreDisplayed()throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.checkFormElementsArePresent(driver);
    }

    /*
    1. Open Home Page (in Before Method)
    2. Click on Form icon
    3. Enter name into name field and click on 'Go' button
    4. Check that thank you texts correspond to expected
    5. Check that Logo and Title are displayed and correspond to expected
    */

    @Test(groups = {"DoclerTestCases"}, dataProvider = "names", dataProviderClass = PageObjects.DataProvider.class)
    public void checkFormSubmissionWorks(String names)throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.openHomePageLink(driver);
        homePage.formSubmissionVerification(driver, names);
        homePage.verifyPageTitle(driver);
        homePage.verifyLogoIsPresent(driver);

    }


}
