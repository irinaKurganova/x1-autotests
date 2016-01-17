package ua.x1.commonmethods.and.steps;

import org.openqa.selenium.WebDriver;

import ua.x1.pages.FacebookPage;

public class FacebookSteps extends CommonMethods {

    private FacebookPage facebookPage;

    public FacebookSteps(WebDriver driver) {
        facebookPage = new FacebookPage(driver);
    }

    public void login(String email, String password) {
        enterText(facebookPage.getFacebookLoginBlock().getEmailTextfield(), email);
        enterText(facebookPage.getFacebookLoginBlock().getPasswordTextfield(), password);
        clickOnButton(facebookPage.getLoginButton());
    }

    public void shouldSeeLoginErrorBox() {
        elementShouldExistOnThePage(facebookPage.getLoginError().getWrappedElement());
    }
}
