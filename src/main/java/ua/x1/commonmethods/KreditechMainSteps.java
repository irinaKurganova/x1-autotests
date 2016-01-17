package ua.x1.commonmethods;

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

}
