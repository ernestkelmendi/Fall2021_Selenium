package Class10;

import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Frames_Concept {
    @Test
    public void frames_Concept() {

        UseDriver.openUrl("https://www.yahoo.com/");

        /**
         * Frames: is a web-page on web-page
         *      Frames are always going to be 'iframe' tag
         *      One web-page can have multiple frames.
         *
         * To interact with a frame:
         *      1. switch on the frame
         *      2. then we interact with frame (or any specific element in the frame)
         *
         * Switch to frame:
         *  1. using the id of the iframe tag
         *  2. using the frame-webElement
         *  3. using the frame-index
         *
         */

        // 1. using the id of the iframe tag
        UseDriver.getDriver().switchTo().frame("my-adsLDRB-iframe");


        // 2. using the frame-webElement
        WebElement frameElement = UseDriver.getDriver().findElement(By.xpath("//iframe[@class='darla']"));
        UseDriver.getDriver().switchTo().frame(frameElement);

        // 3. using the frame-index
        UseDriver.getDriver().switchTo().frame(4);

    }
}
