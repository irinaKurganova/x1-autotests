package ua.x1.commonmethods.and.steps;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import ua.x1.pages.KreditechMainPage;

public class KreditechMainSteps extends CommonMethods {

    private KreditechMainPage kreditechMainPage;

    public KreditechMainSteps(WebDriver driver) {
        kreditechMainPage = new KreditechMainPage(driver);
    }

    public void kreditechImageShouldBeOnThePage() {
        elementShouldExistOnThePage(kreditechMainPage.getKreditechHomeShowBlock().getKreditechImage());
    }

    public void kreditechNavigationBarLinksShouldDisplayOnThePage() {
        listOfElementsShouldDisplayOnThePage(kreditechMainPage.getKreditechNavigationBarBlock()
                .getListOfNavigationItems());
    }

    public void clickOnKreditechItemBarByLinkHref(String linkHref) {
        clickOnLinkThatEqualText(kreditechMainPage.getKreditechNavigationBarBlock().getListOfNavigationItems(),
                linkHref);
    }

    public void scrollDownToKreditechFooter(WebDriver driver) {
        scrollDownAndWaithUntilElementVisible(driver, kreditechMainPage.getKreditechFooterBlock().getCopyrightElement());
    }

    public void clickOnFacebookShareButtonAndSwitchToNewWindow(WebDriver driver, Set<String> oldWindowHandles) {
        clickOnButton(kreditechMainPage.getFacebookShareButton());
        waitUntilPageLoad(driver);
        switchToWindow(driver, getNewWindowHandle(driver, oldWindowHandles));
//        maximizeWindow(driver);
    }

    public void clickOnTwitterShareButton(WebDriver driver, Set<String> oldWindowHandles) {
        clickOnHtmlElement(kreditechMainPage.getTwitterShareLink());
        waitUntilPageLoad(driver);
        switchToWindow(driver, getNewWindowHandle(driver, oldWindowHandles));
        maximizeWindow(driver);
    }

}
