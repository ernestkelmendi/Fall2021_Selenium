package Class4;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdowns {
    @Test
    public void dropDowns() {

        // Enter your Date of birth in Create New Account flow in Facebook
        /*
            1. Launch facebook.com
            2. Click Create new Account button
            3. Enter date of birth
                Feb 20 2018
         */

        UseDriver.openUrl("https://www.facebook.com");

        UseDriver.getDriver().findElement(By.xpath("//a[@role='button' and contains(@data-testid, 'open-registration')]")).click();
        Misc.sleep(2);

        /**
         * Dropdown with select tag --> Select class
         *
         * 1. find the locator of dropdown webElement (or select tag)
         * 2. find the dropdown-WebElement using step-1 locator
         * 3. Create an object of Select class, and pass Dropdown WebElement (found on Step-2) in Constructor
         * 4. Use relevant method from Select class to select desired value in dropdown
         *      selectByVisibleText     |       selectByValue       |       selectByIndex
         */
        By monthLocator = By.id("month");
        WebElement monthDdElement = UseDriver.getDriver().findElement(monthLocator);
        Select monthDd = new Select(monthDdElement);
        monthDd.selectByVisibleText("Feb");
        // monthDd.selectByValue("2");

        By dayLocator = By.name("birthday_day");
        WebElement dayDdElement = UseDriver.getDriver().findElement(dayLocator);
        Select dayDd = new Select(dayDdElement);
        dayDd.selectByValue("20");

        By yearLocator = By.xpath("//select[@aria-label='Year']");
        WebElement yearDdElement = UseDriver.getDriver().findElement(yearLocator);
        Select yearDd = new Select(yearDdElement);
        yearDd.selectByIndex(3);







    }
}
