package ua.x1.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search block")
@FindBy(xpath = "//div[@class='tsf-p']")
public class SearchBlock extends HtmlElement {

	@Name("Search textField")
	@FindBy(xpath = ".//input[@id='lst-ib']")
	private TextInput searchTextField;

	@Name("Search button")
	@FindBy(xpath = ".//button[@type='submit']")
	private Button searchButton;

	public void searchFor(String request) {
		searchTextField.clear();
		searchTextField.sendKeys(request);
		searchButton.click();
	}

	public TextInput getSearchTextField() {
		return searchTextField;
	}

	public Button getSearchButton() {
		return searchButton;
	}

}
