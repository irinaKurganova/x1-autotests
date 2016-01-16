package ua.x1.tests;

import static ua.x1.commonmethods.CommonMethod.*;
import static ua.x1.constants.Constants.*;

import org.junit.Before;
import org.junit.Test;

import ua.x1.pages.GoogleMainPage;

public class KreditechTest extends BaseTest {

	@Before
	public void before() {
		GoogleMainPage googleMainPage = new GoogleMainPage(driver);
		googleMainPage.getSearchBlock().searchFor(QUERY_STRING);

		clickOnLinkThatContainsText(googleMainPage.getSearchResultsBlock()
				.getListOfCiteLinks(), KREDITECH_PAGE_URL);
	}

	@Test
	public void navigateByEachBarItem() {

	}

}
