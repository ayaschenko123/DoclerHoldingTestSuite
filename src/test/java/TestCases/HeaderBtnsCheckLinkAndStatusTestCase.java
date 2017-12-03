package TestCases;

import PageObjects.HomePage;
import PageObjects.WebDriverRun;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HeaderBtnsCheckLinkAndStatusTestCase extends WebDriverRun{

     /*
    1. Open Home Page (in Before Method)
    2. Click on one of Header icon (depends on value in DataProvider)
    3. Check that link correspond to expected and icon status is active
    */

    @Test(groups = {"DoclerTestCases"}, dataProvider = "iconAndUrl", dataProviderClass = PageObjects.DataProvider.class)
    public void clickOnFormBtnCheckLinkAndStatus(String xpathOfElement, String iconName, String url) throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementAndCheckStatusAndLink(driver, xpathOfElement,iconName,url);
    }
}
