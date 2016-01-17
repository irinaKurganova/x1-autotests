package ua.x1.tests;

import static ua.x1.commonmethods.and.steps.CommonMethods.maximizeWindow;
import static ua.x1.commonmethods.and.steps.CommonMethods.openPage;
import static ua.x1.constants.Constants.BROWSER_PROPERTY;
import static ua.x1.constants.Constants.CHROME_DRIVER;
import static ua.x1.constants.Constants.CHROME_DRIVER_NAME;
import static ua.x1.constants.Constants.FIREFOX_DRIVER;
import static ua.x1.constants.Constants.GOOGLE_PAGE_URL;
import static ua.x1.constants.Constants.WEBDRIVER_CHROME_SYSTEM_PROPERTY;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ua.x1.commonmethods.and.steps.FacebookSteps;
import ua.x1.commonmethods.and.steps.GoogleSteps;
import ua.x1.commonmethods.and.steps.KreditechMainSteps;
import ua.x1.commonmethods.and.steps.TwitterSteps;

public class BaseTest {

    protected WebDriver driver = null;

    protected GoogleSteps googleSteps = null;

    protected KreditechMainSteps kreditechMainSteps = null;
    
    protected FacebookSteps facebookSteps = null;
    
    protected TwitterSteps twitterSteps = null;

    @Before
    public void init() {
        if (FIREFOX_DRIVER.equals(System.getProperty(BROWSER_PROPERTY))) {
            driver = new FirefoxDriver();
        } else if (CHROME_DRIVER.equals(System.getProperty(BROWSER_PROPERTY))) {
            File file = new File(ClassLoader.getSystemClassLoader().getResource(CHROME_DRIVER_NAME).getFile());
            System.setProperty(WEBDRIVER_CHROME_SYSTEM_PROPERTY, file.getAbsolutePath());
            driver = new ChromeDriver();
        }
        maximizeWindow(driver);
        openPage(driver, GOOGLE_PAGE_URL);
        googleSteps = new GoogleSteps(driver);
        kreditechMainSteps = new KreditechMainSteps(driver);
        facebookSteps = new FacebookSteps(driver);
        twitterSteps = new TwitterSteps(driver);
    }

    @After
    public void killDriver() {
        driver.quit();
    }
}
