package TestCases;

import PageObjects.HomePage;
import PageObjects.WebDriverRun;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TitleAndLogoTestCase extends WebDriverRun{


    /*
    1. Open link from 'Links' Data Provider
    2. Check that page title correspond to ecpected
    3. Check that site logo is present on the page
    */

    @Test(groups = {"DoclerTestCases"}, dataProvider = "links",dataProviderClass = PageObjects.DataProvider.class)
    public void clickOnHomeButtonAndCheckURL(String link)throws Exception{
        HomePage homePage = new HomePage(driver);
        homePage.openLink(driver, link);
        homePage.verifyPageTitle(driver);
        homePage.verifyLogoIsPresent(driver);
    }
}
