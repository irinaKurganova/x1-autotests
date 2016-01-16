package ua.x1.blocks;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

@Name("Search results block")
@FindBy(xpath = "//div[@class='srg']")
public class SearchResultsBlock extends HtmlElement {

	@Name("List of cite links")
	@FindBy(xpath = ".//h3/a")
	private List<Link> listOfCiteLinks;

	public List<Link> getListOfCiteLinks() {
		return listOfCiteLinks;
	}

}
