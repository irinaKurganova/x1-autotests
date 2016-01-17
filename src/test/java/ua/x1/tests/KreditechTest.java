package ua.x1.tests;

import static ua.x1.commonmethods.and.steps.CommonMethods.closeCurrentWindow;
import static ua.x1.commonmethods.and.steps.CommonMethods.getPageTitle;
import static ua.x1.commonmethods.and.steps.CommonMethods.switchToFrame;
import static ua.x1.commonmethods.and.steps.CommonMethods.switchToWindow;
import static ua.x1.commonmethods.and.steps.CommonMethods.takeScreenshotAndSaveFile;
import static ua.x1.commonmethods.and.steps.CommonMethods.waitUntilPageLoad;
import static ua.x1.constants.Constants.BLOG_LINK_HREF;
import static ua.x1.constants.Constants.CAREERS_LINK_HREF;
import static ua.x1.constants.Constants.CONTACT_LINK_HREF;
import static ua.x1.constants.Constants.FACEBOOK_EMAIL;
import static ua.x1.constants.Constants.IMAGES_FOLDER_PATH;
import static ua.x1.constants.Constants.IMAGE_EXTENSION;
import static ua.x1.constants.Constants.INVESTOR_RELATIONS_LINK_HREF;
import static ua.x1.constants.Constants.KREDITECH_PAGE_URL;
import static ua.x1.constants.Constants.NEWS_LINK_HREF;
import static ua.x1.constants.Constants.QUERY_STRING;
import static ua.x1.constants.Constants.TWITTER_EMAIL;
import static ua.x1.constants.Constants.TWITTER_PASSWORD;
import static ua.x1.constants.Constants.WHAT_WE_DO_LINK_HREF;
import static ua.x1.constants.Constants.WHO_WE_ARE_LINK_HREF;
import static ua.x1.constants.Constants.XPATH_FOR_FACEBOOK_IFRAME;
import static ua.x1.constants.Constants.XPATH_FOR_TWITTER_IFRAME;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ua.x1.utils.BaseTest;

@RunWith(Parameterized.class)
public class KreditechTest extends BaseTest {

    private String textOfHrefOfEachItemBar;
    private String pageTitle = null;

    @Before
    public void before() {
        googleSteps.searchRequest(QUERY_STRING);
        log.info("Send request: "+ QUERY_STRING);
        googleSteps.listOfCiteLinksShouldBeDisplayed();

        googleSteps.clickOnKreditechPageUrl();
        log.info("Click on Kreditech url");
        kreditechMainSteps.kreditechImageShouldBeOnThePage();
    }

    public KreditechTest(String textOfHrefOfEachItemBar) {
        this.textOfHrefOfEachItemBar = textOfHrefOfEachItemBar;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                 { "" }, // for Kreditech Home Page
                 { WHAT_WE_DO_LINK_HREF },
                 { WHO_WE_ARE_LINK_HREF },
                 { CAREERS_LINK_HREF },
                 { INVESTOR_RELATIONS_LINK_HREF },
                 { NEWS_LINK_HREF },
                 { BLOG_LINK_HREF },
                 { CONTACT_LINK_HREF }
                });
    }

    @Test
    public void navigateSaveScreenshotOnItemBarAndSharePostViaSocNet() {
        kreditechMainSteps.kreditechNavigationBarLinksShouldDisplayOnThePage();
        String fullHref = KREDITECH_PAGE_URL+textOfHrefOfEachItemBar;
        kreditechMainSteps.clickOnKreditechItemBarByLinkHref(fullHref);
        log.info("Click on Kreditech Navigation Item Bar by link "+fullHref);
        waitUntilPageLoad(driver);
        kreditechMainSteps.kreditechNavigationBarLinksShouldDisplayOnThePage();
        pageTitle = getPageTitle(driver);
        
        kreditechMainSteps.scrollDownToKreditechFooter(driver);
        takeScreenshotAndSaveFile(driver, IMAGES_FOLDER_PATH, pageTitle+IMAGE_EXTENSION);
        log.info("Scroll down to Kreditech footer and take a screenshot");
        Set<String> oldWindowHandles = driver.getWindowHandles();
        switchToFrame(driver, XPATH_FOR_FACEBOOK_IFRAME);

        kreditechMainSteps.clickOnFacebookShareButtonAndSwitchToNewWindow(driver, oldWindowHandles);
        log.info("Click on Facebook share button");
        facebookSteps.login(FACEBOOK_EMAIL, FACEBOOK_EMAIL);
        log.info("Log in Facebook");
        waitUntilPageLoad(driver);
        facebookSteps.shouldSeeLoginErrorBox();
        log.info("Should see login error box on Facebook login page");
        closeCurrentWindow(driver);

        switchToWindow(driver, oldWindowHandles.iterator().next());
        oldWindowHandles = driver.getWindowHandles();
        switchToFrame(driver, XPATH_FOR_TWITTER_IFRAME);

        kreditechMainSteps.clickOnTwitterShareButton(driver, oldWindowHandles);
        log.info("Click on Twitter share button");
        twitterSteps.login(TWITTER_EMAIL, TWITTER_PASSWORD);
        log.info("Log in Twitter");
        waitUntilPageLoad(driver);
        twitterSteps.shouldSeeLoginErrorBox();
        log.info("Should see login error box on Facebook login page");
    }

    @After
    public void after() {
        closeCurrentWindow(driver);
    }

}
