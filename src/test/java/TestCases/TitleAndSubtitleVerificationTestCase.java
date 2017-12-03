package TestCases;

import PageObjects.HomePage;
import PageObjects.WebDriverRun;
import org.testng.annotations.Test;

public class TitleAndSubtitleVerificationTestCase extends WebDriverRun{

     /*
    1. Open Home Page (in Before Method)
    2. Check that title text correspond to expected
    */

    @Test(groups = {"DoclerTestCases"})
    public void verifyTitleAndSubtitleOnHomePage()throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.checkTitleCorrespondToExpected(driver);
    }

     /*
    1. Open Home Page (in Before Method)
    2. Check that subtitle text correspond to expected
    */

    @Test(groups = {"DoclerTestCases"}, alwaysRun = true)
    public void verifySubTitleAndSubtitleOnHomePage()throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.checkSubTitleCorrespondToExpected(driver);
    }
}
