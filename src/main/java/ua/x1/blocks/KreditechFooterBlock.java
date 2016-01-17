package ua.x1.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Kreditech footer block")
@FindBy(xpath = "//div[@id='footer']")
public class KreditechFooterBlock extends HtmlElement {

    @Name("Copyright")
    @FindBy(xpath = ".//span[contains(text(),'Copyright')]")
    private HtmlElement copyrightElement;

    public HtmlElement getCopyrightElement() {
        return copyrightElement;
    }

}
