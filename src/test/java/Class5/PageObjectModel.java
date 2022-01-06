package Class5;

import Class5.Facebook.LaunchPage;
import Class5.Facebook.MessengerHomePage;
import Class5.Facebook.MessengerLoginFail;
import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectModel {
    /**
     *  Page Object Model (POM) Concept
     *
     *  We create a java-class for every webpage.
     *  Locator will be stored as variables
     *  Methods would be the action user can perform on the webElements
     *
     */

    /*
        Launch facebook
        Click Messenger
        Click Login button
        Verify Incorrect Email error is displayed
     */
    @Test
    public void sampleTest() {

        UseDriver.openUrl("https://www.facebook.com/");
        LaunchPage lp = new LaunchPage();
        lp.clickMessengerLink();

        Misc.sleep(2);

        MessengerHomePage mhp = new MessengerHomePage();
        mhp.clickLoginButton();

        Misc.sleep(2);

        MessengerLoginFail mlf = new MessengerLoginFail();
        Assert.assertTrue(mlf.isIncorrectEmailErrorDisplayed(), "Incorrect Email error message is not displayed");

        UseDriver.quitWebPages();
    }

    @Test
    public void sampleTest2() {
        UseDriver.openUrl("https://www.facebook.com");

        LaunchPage lp = new LaunchPage();
        lp.enterLoginEmail("testing@gmail.com");
        lp.enterLoginPassword("abcd@1234");
        lp.clickLoginButton();

    }


}
