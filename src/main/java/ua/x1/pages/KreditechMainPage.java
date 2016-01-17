package ua.x1.pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ua.x1.blocks.KreditechFooterBlock;
import ua.x1.blocks.KreditechHomeShowBlock;
import ua.x1.blocks.KreditechNavigationBarBlock;

public class KreditechMainPage {

    private KreditechNavigationBarBlock kreditechNavigationBarBlock;

    private KreditechHomeShowBlock kreditechHomeShowBlock;

    private KreditechFooterBlock kreditechFooterBlock;

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

}
