package ua.x1.tests;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ua.x1.commonmethods.GoogleSteps;
import ua.x1.commonmethods.KreditechMainSteps;
import static ua.x1.commonmethods.CommonMethods.*;
import static ua.x1.constants.Constants.*;

public class BaseTest {

    protected WebDriver driver = null;

    protected GoogleSteps googleSteps = null;

    protected KreditechMainSteps kreditechMainSteps = null;

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
    }

    @After
    public void killDriver() {
        driver.quit();
    }
}
