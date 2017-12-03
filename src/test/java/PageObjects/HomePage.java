package PageObjects;

import Waiter.Waiter;
import com.gargoylesoftware.htmlunit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends WebDriverRun {
    Waiter wait = new Waiter();

    public HomePage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    //Home Page icon
    @FindBy(id = "home")
    WebElement homePageIcon;

    //Site Logo banner
    @FindBy(id = "dh_logo")
    WebElement siteLogo;

    //Form Page icon
    @FindBy(id = "form")
    WebElement formPageIcon;
    public WebElement elementFormPageIcon(){
        return formPageIcon;
    }

    //Error Page icon
    @FindBy(id = "error")
    WebElement errorPageIcon;

    //UI Page icon
    @FindBy(id = "site")
    WebElement uiTestingBtn;

    //Title container - title text
    @FindBy (xpath = ".//*[@class='ui-test']//h1")
    WebElement titleContainer;

    //Subtitle container - subtitle text
    @FindBy (xpath = ".//*[@class='ui-test']//p")
    WebElement subTitleContainer;

    //Form input - name field
    @FindBy (id = "hello-input")
    WebElement formInputField;

    //Form submit button
    @FindBy (id = "hello-submit")
    WebElement formSubmitButton;

    //Hello Text - appears after form submission
    @FindBy (id = "hello-text")
    WebElement submitText;

    //Active header icon
    @FindBy (xpath = ".//*[@class = 'active']")
    WebElement activeHeaderIcon;



    //Services and Functions

    public void openHomePageLink(WebDriver driver) {
        driver.get("http://uitest.duodecadits.com/");
    }

    public void openLink(WebDriver driver, String link) {
        driver.get(link);
    }

    //Verifying page title correspond to expected
    public void verifyPageTitle(WebDriver driver) {
        String actualTitle = driver.getTitle();
        String expectedTitle = "UI Testing Site";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Verifying Logo is present on the page
    public void verifyLogoIsPresent(WebDriver driver) {
        wait.waitForElementToShowUp(siteLogo, driver);
        siteLogo.isDisplayed();
    }

    //Click on one of header icons and verify user was redirected to corresponding URL and button became active
    public void clickOnElementAndCheckStatusAndLink(WebDriver driver, String xpathOfElement, String elementName, String url) throws Exception{
        WebElement element = driver.findElement(By.xpath(xpathOfElement));
        wait.waitForElementToShowUp(element, driver);
        element.click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, url);

        String iconStatus = driver.findElement(By.xpath(xpathOfElement)).getText();
        Assert.assertEquals(iconStatus, elementName);
    }

    //Click on UI Testing icon and verify user was redirected to corresponding URL and button became active
    public void clickOnUIBtnCheckURL(WebDriver driver) {
        wait.waitForElementToShowUp(uiTestingBtn,driver);
        uiTestingBtn.click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "http://uitest.duodecadits.com/");
    }


    //Click on Error icon and check response code is 404
    public void clickOnErrorBtnAndCheckResponseCode(WebDriver driver) throws Exception {
        WebClient webClient = new WebClient();
        try {
            int responseCode = webClient.getPage("http://uitest.duodecadits.com/error").getWebResponse().getStatusCode();
            Assert.assertEquals(responseCode, 404);
        } catch (FailingHttpStatusCodeException exception) {
            System.err.println("Looks like this page is unavailable - " + exception.getMessage());
        }
    }

    //Click on Error icon and check that 404 is in title
    public void clickOnErrorBtnAndCheckResponseCodeInTitle(WebDriver driver) throws Exception {
        errorPageIcon.click();
        Assert.assertTrue(driver.getTitle().contains("404"));
    }

    //Check that title text correspond to expected
    public void checkTitleCorrespondToExpected(WebDriver driver){
        wait.waitForElementToShowUp(titleContainer,driver);
        String title = titleContainer.getText();
        String expectedTitle = "Welcome to the Docler Holding QA Department";

        Assert.assertEquals(title, expectedTitle);
    }

    //Check that subtitle text correspond to expected
    public void checkSubTitleCorrespondToExpected(WebDriver driver){
        wait.waitForElementToShowUp(subTitleContainer,driver);
        String subTitle = subTitleContainer.getText();
        String expectedSubTitle = "This site is dedicated to perform some exercises and demonstrate automated web testing.";
        Assert.assertEquals(subTitle,expectedSubTitle);
    }

    //Open Form page and check form elements are present
    public void checkFormElementsArePresent(WebDriver driver){
        wait.waitForElementToShowUp(formPageIcon,driver);
        formPageIcon.click();
        wait.waitForElementToShowUp(formInputField, driver);
        formInputField.isDisplayed();
        formSubmitButton.isDisplayed();
    }

    //Submit for and check that thank you text correspond to expected
    public void formSubmissionVerification(WebDriver driver, String name){
        wait.waitForElementToShowUp(formPageIcon,driver);
        formPageIcon.click();
        wait.waitForElementToShowUp(formInputField, driver);
        formInputField.sendKeys(name);
        formSubmitButton.click();
        String helloText = submitText.getText();
        String expectedHelloText = "Hello "+ name + "!";
        Assert.assertEquals(helloText, expectedHelloText);
    }

}