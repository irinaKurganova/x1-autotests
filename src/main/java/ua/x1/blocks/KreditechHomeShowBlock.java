package ua.x1.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Kreditech home show block")
@FindBy(xpath = "//div[@data-section='intro']")
public class KreditechHomeShowBlock extends HtmlElement {

    @Name("Kreditech image")
    @FindBy(xpath = ".//div[contains(@class,'show')]//img")
    private HtmlElement kreditechImage;

    public HtmlElement getKreditechImage() {
        return kreditechImage;
    }

}
