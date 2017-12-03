package TestCases;

import PageObjects.HomePage;
import PageObjects.WebDriverRun;
import org.testng.annotations.Test;

public class ErrorPageVerificationTestCase extends WebDriverRun{

    /*
    1. Open Home Page (in Before Method)
    2. Click on Error icon
    3. Check response code
    4. Check '404' is mentioned in page title
     */

    @Test(groups = {"DoclerTestCases"})
    public void clickOnErrorBtnAndCheckResponseCode()throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.clickOnErrorBtnAndCheckResponseCodeInTitle(driver);
        homePage.clickOnErrorBtnAndCheckResponseCode(driver);
    }

}
