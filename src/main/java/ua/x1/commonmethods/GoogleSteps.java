package ua.x1.commonmethods;

import static ua.x1.constants.Constants.KREDITECH_PAGE_URL;

import org.openqa.selenium.WebDriver;

import ua.x1.pages.GoogleMainPage;

public class GoogleSteps extends CommonMethods {

    private GoogleMainPage googleMainPage;

    public GoogleSteps(WebDriver driver) {
        googleMainPage = new GoogleMainPage(driver);
    }

    public void searchRequest(String request) {
        enterText(googleMainPage.getSearchBlock().getSearchTextField(), request);
        clickOnButton(googleMainPage.getSearchBlock().getSearchButton());
    }

    public void listOfCiteLinksShouldBeDisplayed() {
        listOfElementsShouldDisplayOnThePage(googleMainPage.getSearchResultsBlock().getListOfCiteLinks());
    }

    public void clickOnKreditechPageUrl() {
        clickOnLinkThatEqualText(googleMainPage.getSearchResultsBlock().getListOfCiteLinks(), KREDITECH_PAGE_URL);
    }
}
