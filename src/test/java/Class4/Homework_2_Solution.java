package Class4;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_2_Solution {
    /**
     * Due Date: Wednesday (Dec-22)
     */

    /**
     * Testcase-1
     *
     * Verify find your account link is displayed for incorrect credentials
     * username : %^&&*()
     * password: abcd@1234
     * Link --> Find your account and log in.
     */
    @Test
    public void invalidCredentialsFlow() {
        /*
            Steps (write steps in automation code to practice how to write manual testcases
            Testcase: Verify find your account link is displayed for invalid credentials
            1. Launch facebook.com
            2. Enter %^&&*() in login email
            3. Enter abcd@1234 in login password
            4. Enter login button
            5. Verify Find your account and log in. link is displayed
         */
        UseDriver.openUrl("https://www.facebook.com");
        UseDriver.getDriver().findElement(By.id("email")).sendKeys("%^&&*()");
        UseDriver.getDriver().findElement(By.id("pass")).sendKeys("abcd@1234");
        UseDriver.getDriver().findElement(By.tagName("button")).click();
        Misc.sleep(2);
        boolean isFindAccountDisplayed = UseDriver.getDriver().findElement(By.linkText("Find your account and log in.")).isDisplayed();
        Assert.assertTrue(isFindAccountDisplayed, "Find your account link is NOT displayed");
        UseDriver.quitWebPages();
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
    public void emptyMessengerLoginFlow() {
        /*
            Steps (write steps in automation code to practice how to write manual testcases
            Testcase: Verify flow when user login with empty credentials on Messenger login screen
            1. Launch facebook.com
            2. Click Messenger link
            3. Click Login button on Messenger link
            4. Verify Continue button is displayed and enabled
            5. Verify "Keep me signed in" checkbox is NOT selected
         */
        UseDriver.openUrl("https://www.facebook.com");

        UseDriver.getDriver().findElement(By.linkText("Messenger")).click();
        Misc.sleep(5);

        UseDriver.getDriver().findElement(By.id("loginbutton")).click();
        Misc.sleep(5);

        WebElement continueButton = UseDriver.getDriver().findElement(By.id("loginbutton"));
        boolean isContinueDisplayed = continueButton.isDisplayed();
        boolean isContinueEnabled = continueButton.isEnabled();

        WebElement keepSignedInBox = UseDriver.getDriver().findElement(By.xpath("//input[@name='persistent']/following-sibling::span"));
        boolean isKeepSignedBoxChecked = keepSignedInBox.isSelected();

        Assert.assertTrue(isContinueDisplayed, "Continue button is NOT displayed");
        Assert.assertTrue(isContinueEnabled, "Continue button is NOT enabled");
        Assert.assertFalse(isKeepSignedBoxChecked, "Keep me Sign in checkBox is selected");

        UseDriver.quitWebPages();

    }
}
