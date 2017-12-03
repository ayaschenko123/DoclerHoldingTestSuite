package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class WebDriverRun {
    public WebDriver driver;

    //Open Browser accordingly to parameter in xml file
    //Please run corresponding xml file - you can find it in 'resources' folder
    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType"})
    public void envSetUp(@NoInjection String browserType) throws Exception {

        if (browserType.equalsIgnoreCase("firefox")) {
            this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        } else if (browserType.equalsIgnoreCase("chrome")) {
            this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } else {
            this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new org.openqa.selenium.Dimension(1900, 1080));
        this.driver.get("http://uitest.duodecadits.com");
    }

    //Close browser after test run
    @AfterClass(alwaysRun = true)
        public void closeBR(){
        this.driver.quit();
    }

    //Make screenshot if test fails
    @AfterMethod(alwaysRun = true)
        public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/screenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
    }
}

