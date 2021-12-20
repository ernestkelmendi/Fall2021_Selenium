package Class2;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UseSelenium_2 {
    @Test
    public void goBackForward() {
        /*
        // path of the ChromeDriver
        // System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");   // Mac
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");    // Windows

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        UseDriver.openUrl("https://www.facebook.com/");

        /**
         * To move Back/Forward in a webpage
         *
         * Method: back()
         * Method: forward()
         */

        // WebDriver abcd = Driver.getDriver();            // abcd = driver (from Driver-class)

        // Go Backward
        UseDriver.getDriver().navigate().back();           // <- to go Back once

        Misc.sleep(5);

        UseDriver.getDriver().navigate().forward();        // <- to go Forward once

        Misc.sleep(5);

        UseDriver.quitWebPages();

    }

    @Test
    public void refreshWebPage() {

        UseDriver.openUrl("https://www.hotels.com");

        Misc.sleep(5);

        /**
         * To refresh a webpage
         *
         * 1. Method: refresh()
         *
         * 2. Go back then forward
         *
         * 3. Launch the current url
         *
         */
        // 1
        // Driver.getDriver().navigate().refresh();

        // 2
        // Driver.getDriver().navigate().back();
        // Driver.getDriver().navigate().forward();

        // 3
        /*
            Launch the current url
            1. get current url (getCurrentUrl)
            2. launch url (from step-1) using get() method
         */
        String currentUrl = UseDriver.getDriver().getCurrentUrl();
        UseDriver.getDriver().get(currentUrl);

        UseDriver.quitWebPages();

    }
}
