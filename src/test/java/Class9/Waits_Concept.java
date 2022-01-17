package Class9;

import Web.UseDriver;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits_Concept {
    /**
     * wait is active
     * sleep is not active
     *
     * Sleep for 2-seconds
     * find a webElement
     *
     *
     * wait for 10-seconds
     * finding a webElement
     *
     */
    /**
     * Timeout: max time driver will wait
     * Polling Period : Time after which driver will try to check if it should stop waiting
     */

    /**
     * Types:
     *  1. Implicit Wait
     *  2. Explicit Wait
     *  3. Fluent Wait
     */

    /**
     * Implicit Wait:
     * (like, one time setting in the driver).
     *
     * Wait for a certain amount of time before throwing NoSuchElementException
     * and stop waiting as soon the element is found
     *
     * Polling period: 250ms
     *
     * During the wait time, implicit wait ignores the NoSuchElementException;
     * If any other exception occurs, implicit-wait throws it right away.
     */
    @Test
    public void implicitWait() {
        UseDriver.openUrl("https://www.facebook.com/");

        // driver.manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        UseDriver.getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        UseDriver.getDriver().findElement(By.id("email")).sendKeys("abcd@gmail.com");
        UseDriver.getDriver().findElement(By.id("password")).sendKeys("abcd@1234");
    }

    /**
     * Explicit Wait:
     * Wait for a certain amount of time until the specified condition is met
     * As soon as the condition(s) are met, driver will stop waiting.
     *
     * Timeout: is always in Seconds
     * Polling Period: 500ms
     *
     * During the wait time, Explicit Wait ignores the exception related the condition
     * If any other Exception occur, then Explicit-wait throw it right away.
     *
     */
    @Test
    public void explicitWait() {
        UseDriver.openUrl("https://www.facebook.com/");

        WebDriverWait eWait = new WebDriverWait(UseDriver.getDriver(), 20);

        eWait.until(ExpectedConditions.titleIs("Login in the Facebook"));

        // code

        // eWait.until(ExpectedConditions.alertIsPresent());

        eWait.until(ExpectedConditions.and(
                ExpectedConditions.titleContains("facebook"),
                ExpectedConditions.elementToBeClickable(By.xpath("")),
                ExpectedConditions.urlContains("https")
        ));

        eWait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe("https://www.facebook.com/"),
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(""))
        ));



    }

    /**
     * Fluent Wait
     *
     * Wait for a certain amount of time until the element(s) is found or condition(s) is met
     * If thr waiting time is over, fluent wait throws TimeOutException
     *
     * User can:
     *      define the polling period
     *      ignores the exception(s) during the wait time mentioned by user
     *      put a custom error message to display when the timeout is over
     *
     */
    @Test
    public void fluentWait() {
        UseDriver.openUrl("https://www.facebook.com/");

        Wait fWait = new FluentWait(UseDriver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found within 30 seconds");

        // Use fluent wait for a condition is met (like Explicit Wait).
        fWait.until(ExpectedConditions.titleContains("book"));

        // Use fluent wait to find a webElement (like a Implicit wait)
        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("abcd"));
            }
        });

        element.click();



    }

}
