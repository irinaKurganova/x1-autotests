package ua.x1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;
import ua.x1.blocks.SearchBlock;

public class GoogleMainPage {

	
//	private WebDriver driver;
	
    private SearchBlock searchBlock;
	
    public GoogleMainPage(CustomElementLocatorFactory elementLocatorFactory) {
        HtmlElementLoader.populatePageObject(this, elementLocatorFactory);
    }
    
    public GoogleMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

	public SearchBlock getSearchBlock() {
		return searchBlock;
	}

//    public SearchPage searchFor(String request) {
//        this.searchArrow.searchFor(request);
//        return new SearchPage(driver);
//    }
	
	
}
