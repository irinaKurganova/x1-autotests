package ua.x1.pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ua.x1.blocks.SearchBlock;
import ua.x1.blocks.SearchResultsBlock;

public class GoogleMainPage {

    private SearchBlock searchBlock;

    private SearchResultsBlock searchResultsBlock;

    public GoogleMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public SearchBlock getSearchBlock() {
        return searchBlock;
    }

    public SearchResultsBlock getSearchResultsBlock() {
        return searchResultsBlock;
    }

}
