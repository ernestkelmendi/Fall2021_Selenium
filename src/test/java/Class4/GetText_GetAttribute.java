package Class4;

import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetText_GetAttribute {
    @Test
    public void getTextMethod() {

        // Verify Hotels-homepage has SEARCH copy in the Search button
        /*
            1. Launch hotels.com
            2. get the text from Search button
            3. Compare text from step#2 should be Search
         */

        UseDriver.openUrl("https://www.hotels.com/");

        String searchButtonXpath = "//button[@aria-label='Search' and @type='submit']";
        By searchButtonLocator = By.xpath(searchButtonXpath);
        WebElement searchButton = UseDriver.getDriver().findElement(searchButtonLocator);

        /**
         * To get the text from a webElement
         * Method: getText()
         * Return type: String
         */
        String searchButtonText = searchButton.getText();

        // Expected Text = SEARCH
        // Actual Text = Search

        Assert.assertTrue(searchButtonText.equalsIgnoreCase("SEARCH"),"Search button text is not same as expected");

        UseDriver.quitWebPages();

    }

    @Test
    public void getAttributeMethod() {

        // Verify text on empty login and password field on facebook landing page
        // Text on empty login box : Email or phone number
        // Text on empty password box : Password
        /*
            Steps:
            1. Launch facebook.com
            2. get value of placeholder-attribute for login box
            3. get value of placeholder-attribute for password box
            4. Assert step#2-value with "Email or phone number" (ignore cases)
            5. Assert step#3-value with "Password" (ignore cases)
         */
        UseDriver.openUrl("https://www.facebook.com/");

        String loginId = "email";
        By loginLocator = By.id(loginId);
        WebElement loginBox = UseDriver.getDriver().findElement(loginLocator);

        /**
         * To get the value of an attribute from a webElement
         * Method: getAttribute()
         * input: String (attrName)
         * Return type: String
         */
        String loginPlaceholderValue = loginBox.getAttribute("placeholder");

//        String passXpath = "//input[starts-with(@data-testid, 'royal_p')]";
//        By passLocator = By.xpath(passXpath);
//        WebElement passBox = UseDriver.getDriver().findElement(passLocator);

        WebElement passBox = UseDriver.getDriver().findElement(By.xpath("//input[starts-with(@data-testid, 'royal_p')]"));
        String passPlaceholderValue = passBox.getAttribute("placeholder");

        Assert.assertTrue(loginPlaceholderValue.equalsIgnoreCase("Email address or phone number"), "Login box placeholder is not as expected");
        Assert.assertTrue(passPlaceholderValue.equalsIgnoreCase("Password"), "Password box placeholder is not as expected");




    }

}
