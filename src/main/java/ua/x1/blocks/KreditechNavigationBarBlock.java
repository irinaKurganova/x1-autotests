package ua.x1.blocks;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Kreditech navigation bar block")
@FindBy(xpath = "//ul[@id='menu-main']")
public class KreditechNavigationBarBlock extends HtmlElement {

    @Name("List of navigation items")
    @FindBy(xpath = ".//li//a[contains(@href,'https://www.kreditech.com/')]")
    private List<Link> listOfNavigationItems;

    public List<Link> getListOfNavigationItems() {
        return listOfNavigationItems;
    }

}
