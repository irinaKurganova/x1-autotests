package ua.x1.commonmethods;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.common.DoesElementExistMatcher.exists;

import java.util.List;

import org.openqa.selenium.WebElement;

import ru.yandex.qatools.htmlelements.element.Link;

public class CommonMethod {

	private final static long TIMEOUT_WAITING_ELEMENT = SECONDS.toMillis(30);

	public static void clickOnLinkThatContainsText(List<Link> listOfLinks,
			String expectedText) {
		for (Link link : listOfLinks) {
			elementShouldExistOnThePage(link.getWrappedElement());
			
			if (expectedText.equals(link.getReference())) {
				link.click();
				break;
			}
		}
	}

	public static void elementShouldExistOnThePage(WebElement link) {
		assertThat(
				"Element does not exist on the page.",
				link,
				should(exists()).whileWaitingUntil(
						timeoutHasExpired(TIMEOUT_WAITING_ELEMENT)));
	}
}
