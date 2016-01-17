package ua.x1.commonmethods.and.steps;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.common.DoesElementExistMatcher.exists;
import static ua.x1.constants.Constants.FIRST_ELEMENT;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import static org.openqa.selenium.By.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CommonMethods {

    private final static long TIMEOUT_WAITING_ELEMENT = SECONDS.toMillis(30);

    private static final Logger log = Logger.getLogger(CommonMethods.class);

    public static void elementShouldExistOnThePage(WebElement link) {
        assertThat("Element does not exist on the page.", link,
                should(exists()).whileWaitingUntil(timeoutHasExpired(TIMEOUT_WAITING_ELEMENT)));
    }

    public static void listOfElementsShouldDisplayOnThePage(List<Link> listOfElements) {
        assertThat("The list of elements are not on the page.", listOfElements, should(not(hasSize(0)))
                .whileWaitingUntil(timeoutHasExpired(TIMEOUT_WAITING_ELEMENT)));
        elementShouldExistOnThePage(listOfElements.get(FIRST_ELEMENT).getWrappedElement());
    }

    public static void enterText(TextInput textInput, String text) {
        elementShouldExistOnThePage(textInput.getWrappedElement());
        textInput.clear();
        textInput.sendKeys(text);
    }

    public static void clickOnButton(Button button) {
        elementShouldExistOnThePage(button.getWrappedElement());
        button.click();
    }

    public static void clickOnHtmlElement(HtmlElement element) {
        elementShouldExistOnThePage(element.getWrappedElement());
        element.click();
    }

    /**
     * This method clicks on link that equal to text
     * 
     * @param listOfLinks
     *            - list of links
     * @param expectedHref
     *            - href attribute of link
     */
    public static void clickOnLinkThatEqualText(List<Link> listOfLinks, String expectedHref) {
        for (Link link : listOfLinks) {
            elementShouldExistOnThePage(link.getWrappedElement());
            if (expectedHref.equals(link.getReference())) {
                link.click();
                break;
            }
        }
    }

    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    /**
     * This method scroll down on the page and wait until element is visible
     * 
     * @param driver
     * @param element
     *            - htmlElement
     */
    public static void scrollDownAndWaithUntilElementVisible(WebDriver driver, HtmlElement element) {
        for (int i = 1; i < 10 && element.isDisplayed(); i++) {
            waitUntilPageLoad(driver);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, " + i + "* document.body.offsetHeight)");
            assertThat(element + " is not present on the page!", element,
                    should((exists())).whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(TIMEOUT_WAITING_ELEMENT))));
        }
    }

    public static void waitUntilPageLoad(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_WAITING_ELEMENT, SECONDS);
    }

    /**
     * This method takes screenshot and save as image
     * 
     * @param driver
     * @param pathToSaveFile
     *            - path where image should be saved
     * @param fileName
     *            - image name
     */
    public static void takeScreenshotAndSaveFile(WebDriver driver, String pathToSaveFile, String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(pathToSaveFile, fileName));
        } catch (IOException e) {
            log.info("File not found.");
        }
    }

    /**
     * This method help to switch to frame
     * 
     * @param driver
     * @param xpath
     */
    public static void switchToFrame(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(xpath(xpath));
        elementShouldExistOnThePage(element);
        driver.switchTo().frame(element);
    }

    /**
     * This method gets new window handle
     * 
     * @param driver
     * @param oldWindowHandles
     *            - old windows
     * @return new handle as string
     */
    public static String getNewWindowHandle(WebDriver driver, Set<String> oldWindowHandles) {
        String newHandle = "";
        waitUntilPageLoad(driver);
        Set<String> newWindowHandles = driver.getWindowHandles();
        if (newWindowHandles != null) {
            newWindowHandles.removeAll(oldWindowHandles);
            if (!newWindowHandles.isEmpty()) {
                newHandle = newWindowHandles.iterator().next();
            }
        }
        return newHandle;
    }

    public static void switchToWindow(WebDriver driver, String window) {
        driver.switchTo().window(window);
    }

    public static void closeCurrentWindow(WebDriver driver) {
        driver.close();
    }

}
