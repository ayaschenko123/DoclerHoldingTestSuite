package Waiter;

import PageObjects.WebDriverRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter extends WebDriverRun{



    public void waitForElementToShowUp(WebElement elementLocator, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(elementLocator));
    }

}
