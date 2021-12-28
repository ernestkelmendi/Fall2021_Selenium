package Class3;

import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Homework_2 {
    /**

     */

    /**
     * Testcase-1
     * <p>
     * Verify find your account link is displayed for incorrect credentials
     * username : %^&&*()
     * password: abcd@1234
     * Link --> Find your account and log in.
     */

    @Test
    public void useLocators() {

        UseDriver.openUrl("https://www.facebook.com/");

        String loginEmailIdValue = "email";
        By loginEmailLocator = By.id(loginEmailIdValue);
        WebElement loginEmailBox = UseDriver.getDriver().findElement(loginEmailLocator);
        loginEmailBox.sendKeys("%^&&*()");

        String loginPassNameValue = "pass";
        By loginPassLocator = By.name(loginPassNameValue);
        WebElement loginPassBox = UseDriver.getDriver().findElement(loginPassLocator);
        loginPassBox.sendKeys("abcd@1234");

        String loginButtonTag = "button";
        By loginButtonLocator = By.tagName(loginButtonTag);
        WebElement loginButton = UseDriver.getDriver().findElement(loginButtonLocator);
        loginButton.click();

    }

        /**
        * Testcase-2
        *
        * Verify find your account link is displayed if login with empty credentials on Messenger page
        * Link --> Find your account and log in.
        * Also, verify "Continue" button is displayed and enabled
        * verify "keep me signed in" check-box is not selected by default
        *
        */

        @Test
        public void useLocators2() {

            UseDriver.openUrl("https://www.messenger.com/");

            String loginButtonTag = "button";
            By loginButtonLocator = By.tagName(loginButtonTag);
            WebElement loginButton = UseDriver.getDriver().findElement(loginButtonLocator);
            loginButton.click();

            String loginEmailIdValue = "";
            By loginEmailLocator = By.id(loginEmailIdValue);
            WebElement loginEmailBox = UseDriver.getDriver().findElement(loginEmailLocator);
            loginEmailBox.sendKeys("");

            String loginPassNameValue = "";
            By loginPassLocator = By.name(loginPassNameValue);
            WebElement loginPassBox = UseDriver.getDriver().findElement(loginPassLocator);
            loginPassBox.sendKeys("");


        }
}

