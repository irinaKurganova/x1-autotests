package ua.x1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ua.x1.blocks.KreditechFooterBlock;
import ua.x1.blocks.KreditechHomeShowBlock;
import ua.x1.blocks.KreditechNavigationBarBlock;

public class KreditechMainPage {

    private KreditechNavigationBarBlock kreditechNavigationBarBlock;

    private KreditechHomeShowBlock kreditechHomeShowBlock;

    private KreditechFooterBlock kreditechFooterBlock;
    
    
    @Name("Facebook share button")
    @FindBy(xpath = "//a[contains(@href,'/sharer/')]")
    private Button facebookShareButton;

    @Name("Twitter share link")
    @FindBy(xpath = "//a[contains(@class,'follow-button')]")
    private HtmlElement twitterShareLink;

    @Name("Youtube share link")
    @FindBy(xpath = "//button[contains(@class,'ytp-share-button')]")
    private HtmlElement youtubeShareLink;

    public KreditechMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public KreditechNavigationBarBlock getKreditechNavigationBarBlock() {
        return kreditechNavigationBarBlock;
    }

    public KreditechHomeShowBlock getKreditechHomeShowBlock() {
        return kreditechHomeShowBlock;
    }

    public KreditechFooterBlock getKreditechFooterBlock() {
        return kreditechFooterBlock;
    }

    
    public Button getFacebookShareButton() {
        return facebookShareButton;
    }

    public HtmlElement getTwitterShareLink() {
        return twitterShareLink;
    }

    public HtmlElement getYoutubeShareLink() {
        return youtubeShareLink;
    }
}
