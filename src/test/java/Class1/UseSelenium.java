package Class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UseSelenium {
    @Test
    public void useSelenium() {

        // path of the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");    // Windows


        WebDriver driver = new ChromeDriver();
        /**
         * WebDriver driver = new ChromeDriver();
         *
         * WebDriver driver -> driver is a variable of WebDriver Interface
         * new ChromeDriver(); -> object of ChromeDriver class.
         *
         * Datatype of driver is WebDriver
         *
         * ChromeDriver(C) extends RemoteWebDriver(C) ; RemoteWebDriver(C) implements WebDriver(I)
         */

        /**
         * To launch a webpage
         *
         * Method-1 : get()
         *
         * Method-2 : navigate().to()
         */
        String url = "https://www.facebook.com/";

        driver.get(url);
        // OR
        // driver.navigate().to(url);
        /**
         * get() vs navigate().to()
         *
         * get() -> launches the webpage and wait for few seconds (for webpage to load)
         *          before executing the next line in the code.
         *
         * navigate().to() -> launches the webpage,
         *          and goes to execute the next line in the code.
         */

        try {
            Thread.sleep(5000);         // 1sec = 1000 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * Method to maximize the webpage
         *
         * method: maximize()
         */
        // driver.manage().window().maximize();

        /**
         * To get the current-url of webpage from window associated with driver
         * Method: getCurrentUrl
         */
        String webUrl = driver.getCurrentUrl();     // webUrl = https://www.facebook.com/

        Assert.assertEquals(url, webUrl, "Facebook was not launched successfully");


        /**
         * To get the page title of webpage from window associated with driver
         * Method: getTitle
         */
        String pageTitle = driver.getTitle();
        System.out.println("Page title after launch -> " + pageTitle);

        /**
         * To close a webpage
         *
         * Method-1 : close()
         *      will close ONLY the web-window associated with driver
         *
         * Method-2 : quit()
         *      will close ALL web-windows launched due to automation code/script
         */
        // driver.close();
        driver.quit();


    }

}
