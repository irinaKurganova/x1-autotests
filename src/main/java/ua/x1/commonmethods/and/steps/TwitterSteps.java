package ua.x1.commonmethods.and.steps;

import org.openqa.selenium.WebDriver;

import ua.x1.pages.TwitterPage;

public class TwitterSteps extends CommonMethods {

    private TwitterPage twitterPage;

    public TwitterSteps(WebDriver driver) {
        twitterPage = new TwitterPage(driver);
    }

    public void login(String email, String password) {
        enterText(twitterPage.getTwitterLoginBlock().getEmailTextfield(), email);
        enterText(twitterPage.getTwitterLoginBlock().getPasswordTextfield(), password);
        clickOnButton(twitterPage.getTwitterLoginBlock().getLoginButton());
    }

    public void shouldSeeLoginErrorBox() {
        elementShouldExistOnThePage(twitterPage.getLoginError().getWrappedElement());
    }
}
