package ua.x1.tests;

import static ua.x1.commonmethods.and.steps.CommonMethods.*;
import static ua.x1.constants.Constants.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class KreditechTest extends BaseTest {

    private String textOfHrefOfEachItemBar;
    private String pageTitle = null;

    @Before
    public void before() {
        googleSteps.searchRequest(QUERY_STRING);
        googleSteps.listOfCiteLinksShouldBeDisplayed();

        googleSteps.clickOnKreditechPageUrl();
        kreditechMainSteps.kreditechImageShouldBeOnThePage();
    }

    public KreditechTest(String textOfHrefOfEachItemBar) {
        this.textOfHrefOfEachItemBar = textOfHrefOfEachItemBar;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                // { "" }, // for Kreditech Home Page
                { WHAT_WE_DO_LINK_HREF },
                // { WHO_WE_ARE_LINK_HREF },
                // { CAREERS_LINK_HREF },
                // { INVESTOR_RELATIONS_LINK_HREF },
                { NEWS_LINK_HREF }
        // ,
        // { BLOG_LINK_HREF },
        // { CONTACT_LINK_HREF }
                });
    }

    @Test
    public void navigateOnEachItemBarPage() {
        kreditechMainSteps.kreditechNavigationBarLinksShouldDisplayOnThePage();
        String fullHref = KREDITECH_PAGE_URL.concat(textOfHrefOfEachItemBar);
        kreditechMainSteps.clickOnKreditechItemBarByLinkHref(fullHref);
        kreditechMainSteps.kreditechNavigationBarLinksShouldDisplayOnThePage();
        pageTitle = getPageTitle(driver);
    }

    @After
    public void savingScreenShot() {
        kreditechMainSteps.scrollDownToKreditechFooter(driver);
        takeScreenshotAndSaveFile(driver, IMAGE_FOLDER_PATH, pageTitle.concat(IMAGE_EXTENSION));
        Set<String> oldWindowHandles = driver.getWindowHandles();
        switchToFrame(driver, 0);

        kreditechMainSteps.clickOnFacebookShareButtonAndSwitchToNewWindow(driver, oldWindowHandles);
        facebookSteps.login(FACEBOOK_EMAIL, FACEBOOK_EMAIL);
        facebookSteps.shouldSeeLoginErrorBox();
        closeCurrentWindow(driver);

        switchToWindow(driver, oldWindowHandles.iterator().next());
        oldWindowHandles = driver.getWindowHandles();
        switchToFrame(driver, 1);

        kreditechMainSteps.clickOnTwitterShareButton(driver, oldWindowHandles);
        twitterSteps.login(TWITTER_EMAIL, TWITTER_PASSWORD);
        twitterSteps.shouldSeeLoginErrorBox();
        closeCurrentWindow(driver);

    }

}
