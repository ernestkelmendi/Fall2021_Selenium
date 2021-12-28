package Class3;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UseLocators_2 {
    /**
     * To find a webElement
     * Method: findElement()
     * input: By (the locator of webElement which we want to find)
     * return type: WebElement
     *
     * if the element is found using the locator,
     *      findElement-method return WebElement
     * else
     *      NoSuchElement Exception
     *
     */

    /**
     * To type on a webElement
     * Method: sendKeys()
     * input: String (data that we want to type in the webElement)
     */

    /**
     * To clear the text from a webElement
     * Method: clear()
     */

    /**
     * To click on a webElement
     * Method: click()
     *
     */

    /**
     * To find if WebElement is enabled or not
     * Method: isEnabled()
     * return type: boolean
     */

    /**
     * To find if WebElement is displayed or not
     * Method: isDisplayed()
     * return type: boolean
     */

    /**
     * To find if WebElement is selected or not
     * Method: isSelected()
     * return type: boolean
     */

    @Test
    public void useLocators() {

        UseDriver.openUrl("https://www.facebook.com/");

        String loginEmailIdValue = "email";
        By loginEmailLocator = By.id(loginEmailIdValue);
        WebElement loginEmailBox = UseDriver.getDriver().findElement(loginEmailLocator);
        loginEmailBox.sendKeys("testing@test.com");

        String loginPassNameValue = "pass";
        By loginPassLocator = By.name(loginPassNameValue);
        WebElement loginPassBox = UseDriver.getDriver().findElement(loginPassLocator);
        loginPassBox.sendKeys("abcd@1234");

        // Misc.sleep(2);

        // loginEmailBox.clear();

        // Misc.sleep(2);

        // loginEmailBox.sendKeys("newtesting@newTest.com");

        String loginButtonTag = "button";
        By loginButtonLocator = By.tagName(loginButtonTag);
        WebElement loginButton = UseDriver.getDriver().findElement(loginButtonLocator);
        loginButton.click();

        UseDriver.quitWebPages();

    }

    @Test
    public void useLinkLocator() {

        UseDriver.openUrl("https://www.facebook.com/");

        String partialTextCreatePage = "a Page";
        By createPageLocator = By.partialLinkText(partialTextCreatePage);
        WebElement createPageLink = UseDriver.getDriver().findElement(createPageLocator);
        createPageLink.click();
    }

    @Test
    public void checkEnabled() {

        // Verify login button is enabled on launch facebook.com

        UseDriver.openUrl("https://www.facebook.com/");

        String loginButtonTag = "button";
        By loginButtonLocator = By.tagName(loginButtonTag);
        WebElement loginButton = UseDriver.getDriver().findElement(loginButtonLocator);
        boolean isLoginButtonEnabled = loginButton.isEnabled();

        Assert.assertTrue(isLoginButtonEnabled, "Login button is not enable when user lands on facebook.com");

        UseDriver.quitWebPages();

    }

    @Test
    public void checkCreatePageLinkDisplayed() {

        // Verify Create a Page link is displayed and enabled on facebook.com

        UseDriver.openUrl("https://www.facebook.com/");

        String partialTextCreatePage = "a Page";
        By createPageLocator = By.partialLinkText(partialTextCreatePage);
        WebElement createPageLink = UseDriver.getDriver().findElement(createPageLocator);

        boolean isCreatePageEnabled = createPageLink.isEnabled();

        boolean isCreatePageDisplayed = createPageLink.isDisplayed();

        // Assert.assertTrue(isCreatePageDisplayed && isCreatePageEnabled, "Create a Page is is either not displayed or enabled");

        Assert.assertTrue(isCreatePageDisplayed, "Create a Page link is not displayed");
        Assert.assertTrue(isCreatePageEnabled, "Create a Page link is not enabled");


    }

    @Test
    public void checkSelected() {
        // Verify no gender radio button is selected on Create new account form
        /*
            Steps:
            Launch facebook.com
            Click Create new account button
            Verify female radio button is not selected
            Verify male radio button is not selected
            Verify custom radio button is not selected
         */
        UseDriver.openUrl("https://www.facebook.com/");

        String createNewAccountText = "Create New Account";
        By createAccountLocator = By.linkText(createNewAccountText);
        WebElement createAccountButton = UseDriver.getDriver().findElement(createAccountLocator);
        createAccountButton.click();
        Misc.sleep(2);

        String femaleBtnAddress = "//label[text()='Female']";
        By femaleBtnLocator = By.xpath(femaleBtnAddress);
        WebElement femaleBtn = UseDriver.getDriver().findElement(femaleBtnLocator);
        boolean isFemaleBtnSelected = femaleBtn.isSelected();
        Assert.assertTrue(isFemaleBtnSelected, "Female Radio button is already selected");

    }

    @Test
    public void usingXPath() {
        UseDriver.openUrl("https://www.facebook.com");

        String loginEmailXpath = "//input[@aria-label='Email address or phone number']";
        By loginEmailLocator = By.xpath(loginEmailXpath);
        WebElement loginEmailBox = UseDriver.getDriver().findElement(loginEmailLocator);
        loginEmailBox.sendKeys("testing@gmail.com");

        String loginPassXpath = "//input[contains(@data-testid, '_pass')]";
        By loginPassLocator = By.xpath(loginPassXpath);
        WebElement loginPassBox = UseDriver.getDriver().findElement(loginPassLocator);
        loginPassBox.sendKeys("abcd@1234");

        String loginButtonXPath = "//button[contains(text() , 'Log' )]";
        By loginBtnLocator = By.xpath(loginButtonXPath);
        WebElement loginBtn = UseDriver.getDriver().findElement(loginBtnLocator);
        loginBtn.click();

    }

}
