package Class5;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scrolls_Concept {
    /**
     * To scroll in webpage, we use Javascript.
     *
     * 1. scroll by pixel
     * 2. scroll upto a webElement
     * 3. scroll upto bottom of webpage
     *
     */

    @Test
    public void scrollByPixel() {
        UseDriver.openUrl("https://www.darksky.net/");
        /**
         * 1. Scroll by Pixel
         * scrollBy(0,y)
         *
         * y is +ve         ->      scroll downwards pixels down
         * scrollBy(0,500)  ->      scroll downwards by 500 pixels
         *
         * y is -ve         ->      scroll upwards pixels down
         * scrollBy(0,-500)  ->     scroll upwards by 500 pixels
         *
         */


        // scroll to TIME MACHINE button

        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,800);");

        Misc.sleep(1);

        UseDriver.getDriver().findElement(By.xpath("//a[@class='button']")).click();

    }

    @Test
    public void scrollByPixel2() {
        UseDriver.openUrl("https://www.darksky.net/");

        // scroll to TIME MACHINE button
        for (int i=1 ; i <= 15 ; i++) {
            try {
                UseDriver.getDriver().findElement(By.xpath("//a[@class='button']")).click();
                break;
            } catch (ElementClickInterceptedException e) {
                JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
                js.executeScript("scrollBy(0,100);");
            }
        }

    }

    @Test
    public void scrollUpToElement() {
        /**
         * scroll upto a webElement
         *
         * "element.scrollIntoView(true)"
         */

        WebElement element = UseDriver.getDriver().findElement(By.xpath(""));

        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);


    }

    @Test
    public void scrollToBottom() {
        /**
         * scroll to bottom of webPage
         *
         * "window.scrollTo(0,document.body.scrollHeight);"
         *
         */

        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");


    }
}
