package Class2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators {
    @Test
    public void UseLocators() {

        /**
         * ChroPath Plugin:
         * https://chrome.google.com/webstore/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo?hl=en
         */

        /**
         * Locator : It's a kind of data/route to find desired webElement
         * Datatype of Locator -> By
         *
         *
         * Steps to create Locator
         * 1. Find the unique address to reach to the webElement using DOM
         * 2. Depending upon the type of address/info,
         *      we use specific method from By-Class to create locator
         * 3. Use locator to find the WebElement (use: findElement() method)
         * 4. when WebElement is found, interact with it.
         *
         * Address:
         * 1. id attribute (unique)
         *      In chropath, check if id is unique --> //*[@id='idValue']
         *      By locatorUsingId = By.id("idValue");
         *
         * 2. name attribute
         *      In chropath, check if name is unique --> //*[@name='nameValue']
         *      By locatorUsingName = By.name("nameValue")
         *
         */



    }
}
