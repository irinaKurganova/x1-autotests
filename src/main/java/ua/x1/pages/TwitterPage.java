package ua.x1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ua.x1.blocks.TwitterLoginBlock;

public class TwitterPage {

    private TwitterLoginBlock twitterLoginBlock;

    @Name("Login error box")
    @FindBy(xpath = "//div[@class='message-inside']")
    private HtmlElement loginError;

    public TwitterPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public TwitterLoginBlock getTwitterLoginBlock() {
        return twitterLoginBlock;
    }

    public HtmlElement getLoginError() {
        return loginError;
    }

}
