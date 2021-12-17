package Class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestCases {
    // Verify facebook url is correct after launching the page
    /*
        1. Launch facebook.com
        2. get the current url
        3. Assert, current url is same as what we launched
     */
    @Test
    public void VerifyFacebookUrl() {

        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com/";
        driver.get(url);

        String urlFromWeb = driver.getCurrentUrl();

        Assert.assertEquals(urlFromWeb, url, "Facebook url is not correct after launch");

        driver.quit();

    }


    // Verify facebook title is correct after launching the page
    /*
        1. Launch facebook.com
        2. get page title
        3. Assert, page title is "Facebook – log in or sign up"
     */
    @Test
    public void verifyFacebookTitle() {

        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com/";
        driver.get(url);

        String titleFromWeb = driver.getTitle();

        Assert.assertEquals(titleFromWeb, "Facebook – log in or sign up", "Facebook title is not correct after launch");

        driver.quit();
    }

}
