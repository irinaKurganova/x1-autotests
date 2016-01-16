package ua.x1.tests;

import static ua.x1.constants.Constants.QUERY_STRING;

import org.junit.Before;
import org.junit.Test;

import ua.x1.pages.GoogleMainPage;

public class KreditechTest extends BaseTest {

	@Before
	public void before() {
		GoogleMainPage googleMainPage = new GoogleMainPage(driver);
		googleMainPage.getSearchBlock().searchFor(QUERY_STRING);
	}

	@Test
	public void navigateByEachBarItem() {

	}

}
