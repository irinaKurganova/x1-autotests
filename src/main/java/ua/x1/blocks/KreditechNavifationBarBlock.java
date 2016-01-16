package ua.x1.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Kreditech navigation bar block")
@FindBy(xpath = "//ul[@id='menu-main']")
public class KreditechNavifationBarBlock extends HtmlElement {

	@Name("'Home' link")
	@FindBy(xpath = ".//a[text()='Home']")
	private Link homeLink;

	@Name("'What we do' link")
	@FindBy(xpath = ".//a[@title='what']")
	private Link whatWeDoLink;

	@Name("'Who we are' link")
	@FindBy(xpath = ".//a[@title='who']")
	private Link whoWeAreLink;

	@Name("'Careers' link")
	@FindBy(xpath = ".//a[@title='work']")
	private Link careersLink;

	@Name("'Investor Relations' link")
	@FindBy(xpath = ".//a[text()='Investor Relations']")
	private Link investorRelationsLink;

	@Name("'Press' link")
	@FindBy(xpath = ".//a[contains(@href,'news')]")
	private Link pressLink;

	@Name("'Blog' link")
	@FindBy(xpath = ".//a[contains(@href,'blog')]")
	private Link blogLink;

	@Name("'Contact' link")
	@FindBy(xpath = ".//a[@title='contact']")
	private Link contactLink;

	public Link getHomeLink() {
		return homeLink;
	}

	public Link getWhatWeDoLink() {
		return whatWeDoLink;
	}

	public Link getWhoWeAreLink() {
		return whoWeAreLink;
	}

	public Link getCareersLink() {
		return careersLink;
	}

	public Link getInvestorRelationsLink() {
		return investorRelationsLink;
	}

	public Link getPressLink() {
		return pressLink;
	}

	public Link getBlogLink() {
		return blogLink;
	}

	public Link getContactLink() {
		return contactLink;
	}

}
