package Class3;

import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void useLinkLocators() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com/";
        driver.get(url);

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("testlogin@test.com");
        driver.findElement(By.id("pass")).sendKeys("asdt@1234");
        driver.findElement(By.tagName("button")).click();





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

            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            String url = "https://www.facebook.com/";
            driver.get(url);

            // driver.findElement(By.linkText("a Page"));

            String partialTextCreatePage = "a Page";
            By createPageLocator = By.partialLinkText(partialTextCreatePage);
            driver.findElement(By.id("Check Out Messenger")).click();
            driver.findElement(By.name("login")).click();




        }
}

