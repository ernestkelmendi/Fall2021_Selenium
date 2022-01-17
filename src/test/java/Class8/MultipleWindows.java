package Class8;

import Class7.Facebook.FacebookPayPage;
import Class7.Facebook.LaunchPage;
import Helper.Check;
import Helper.Misc;
import Web.UseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    // Verify After clicking on Facebook Pay, user can see new page with Title "Facebook Pay: Simple, Secure, Free Payments"
    @Test
    public void verifyFacebookPayLanding() {

        /*
            1. Launch facebook.com
            2. Click on Facebook Pay link
            3. Verify new page with Title "Facebook Pay: Simple, Secure, Free Payments"
         */
        // 1
        UseDriver.openUrl("https://www.facebook.com");  // [ LaunchWindow ] driver is connected to LaunchWindow

        /**
         * To get the value of WindowHandle stored in driver
         * Method: getWindowHandle
         * Return Type: String
         */

        String launchWindowHandle = UseDriver.getDriver().getWindowHandle();
        System.out.println("launchWindowHandle = " + launchWindowHandle);


        // 2
        LaunchPage lPage = new LaunchPage();
        lPage.clickFacebookPay();                       // driver is connected to LaunchWindow
        /**
         * To get the value of ALL WindowHandle generated due to automated code
         * Method: getWindowHandles
         * Return Type: Set<String>
         */

        Set<String> allHandles = UseDriver.getDriver().getWindowHandles();
        // System.out.println("allHandles = " + allHandles);

        // String launchWindowHandle2 = UseDriver.getDriver().getWindowHandle();
        // System.out.println("launchWindowHandle2 = " + launchWindowHandle2);

        Misc.sleep(2);

        /**
         * To connect driver with new windowHandle
         * Method: switchTo().window(windowHandle)
         * input: windowHandle
         */
        /*
            get the windowHandle stored in driver (launchWindowHandle = wh1)
            using getWindowHandles get all windowHandles (allHandles = wh2, wh1)
            loop
                get a handle from allHandles-Set  (handle = wh2)
                if (handle != launchWindowHandle)
                    switch to handle
                    break/stop the loop
         */
        for (String handle : allHandles) {
            if (!handle.equals(launchWindowHandle)) {
                UseDriver.getDriver().switchTo().window(handle);
                break;
            }
        }

        // 3
        FacebookPayPage fpPage = new FacebookPayPage();
        Check.checkEquals(fpPage.getPageTitle(), "Facebook Pay: Simple, Secure, Free Payments", "Facebook Pay page title is not as expected");

    }


    @Test
    public void verifyCloseAllAds() {
        /*
            1. Launch naukri.com
            2. if any adv window opens
                close all advs
            3. Click Search button on naukri.com
         */
        // 1
        UseDriver.openUrl("https://www.naukri.com/");

        // 2
        /*
            get All window handles
            if size of windowHandles-Set > 1
                then execute code to close adv
         */
        String mainWindowHandle = UseDriver.getDriver().getWindowHandle(); // (mh)

        Set<String> allHandles = UseDriver.getDriver().getWindowHandles(); // (mh, a1, a2, a3)

        if (allHandles.size() > 1) {
            // code to close adv
            /*
                loop
                    get a handle from allHandles-Set (handle = a3)
                    if (handle != mainWindowHandle)
                        switch driver to handle
                        driver.close();
             */
            for (String handle : allHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    UseDriver.getDriver().switchTo().window(handle);
                    UseDriver.getDriver().close();
                }
            }
        }

        // switch driver to mh
        UseDriver.getDriver().switchTo().window(mainWindowHandle);

        // findElement for Search button
        // click Search button

    }
}
