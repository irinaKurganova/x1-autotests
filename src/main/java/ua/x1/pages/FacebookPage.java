package ua.x1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ua.x1.blocks.FacebookLoginBlock;

public class FacebookPage {

    private FacebookLoginBlock facebookLoginBlock;

    @Name("Login button")
    @FindBy(xpath = "//input[@name='login']")
    private Button loginButton;

    @Name("Login error box")
    @FindBy(xpath = "//div[contains(@class,'login_error_box')]")
    private HtmlElement loginError;

    public FacebookPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public FacebookLoginBlock getFacebookLoginBlock() {
        return facebookLoginBlock;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public HtmlElement getLoginError() {
        return loginError;
    }

}
