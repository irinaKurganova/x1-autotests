package ua.x1.tests;

import static ua.x1.commonmethods.CommonMethods.getPageTitle;
import static ua.x1.commonmethods.CommonMethods.takeScreenshotAndSaveFile;
import static ua.x1.constants.Constants.BLOG_LINK_HREF;
import static ua.x1.constants.Constants.CAREERS_LINK_HREF;
import static ua.x1.constants.Constants.CONTACT_LINK_HREF;
import static ua.x1.constants.Constants.IMAGE_EXTENSION;
import static ua.x1.constants.Constants.IMAGE_FOLDER_PATH;
import static ua.x1.constants.Constants.INVESTOR_RELATIONS_LINK_HREF;
import static ua.x1.constants.Constants.KREDITECH_PAGE_URL;
import static ua.x1.constants.Constants.NEWS_LINK_HREF;
import static ua.x1.constants.Constants.QUERY_STRING;
import static ua.x1.constants.Constants.WHAT_WE_DO_LINK_HREF;
import static ua.x1.constants.Constants.WHO_WE_ARE_LINK_HREF;

import java.util.Arrays;
import java.util.Collection;

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
        takeScreenshotAndSaveFile(driver, IMAGE_FOLDER_PATH, pageTitle.concat(IMAGE_EXTENSION) );

    }

}
