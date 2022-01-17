package Class8;

import Class7.Facebook.LaunchPage;
import Helper.DateUtil;
import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements_Concept2 {
    /**
     * To find multiple webElements using a locator
     * Method: findElements
     * return type: List<WebElement>
     */


    @Test
    public void findElements_Concept() {
        /*
            // Verify facebook Launch page has 48 links.
            1. Launch facebook.com
            2. Find the number of links of launch page
            3. Verify count from #2 is 48
         */
        UseDriver.openUrl("https://www.facebook.com/");
        LaunchPage lp = new LaunchPage();
        int linksCountFromWeb= lp.getNumberOfLinks();

        Assert.assertEquals(linksCountFromWeb, 48, "Number of links are not same as expected");

        UseDriver.quitWebPages();

    }

    @Test
    public void CalendarOnWeb() {

        /**
         * 1. Analyse if the Date-Values are present in dom as text-value or some attribute's-value
         * 2. Create locator to get all date-webElement of interested month (//h2[text()='January 2022']/following-sibling::table//button)
         * 3. Use findElements method to get all date-WebElements
         * 4. use loop
         *      pick dateElement from List<WebElement>
         *      apply getText or getAttribute [depends on step#1]
         *      if (above-value is equal to date user want to select)
         *          click the WebElement
         *          break the loop
         */
        UseDriver.openUrl("https://www.hotels.com/");

        try {
            UseDriver.getDriver().findElement(By.xpath("//span[text()='Check in' or text()='Check-in']")).click();
        } catch (ElementClickInterceptedException e) {
            UseDriver.getDriver().findElement(By.xpath("//button[starts-with(@aria-label,'Check-in')]")).click();
        }

        Misc.sleep(2);

        String janDatesLocator = "//h2[text()='January 2022']/following-sibling::table//button";

        List<WebElement> allJanDates = UseDriver.getDriver().findElements(By.xpath(janDatesLocator));

        for (WebElement janDate : allJanDates) {
            String dateValue = janDate.getText();
            if (dateValue.equalsIgnoreCase("14")) {
                janDate.click();
                break;
            }
        }

    }

    @Test
    public void CalendarOnWeb2() {

        /**
         * Select tomorrow's date as Check-in (Jan 8)
         * Select Checkout as 7 days from Check-in (Jan 15)
         */
        UseDriver.openUrl("https://www.hotels.com/");

        try {
            UseDriver.getDriver().findElement(By.xpath("//span[text()='Check in' or text()='Check-in']")).click();
        } catch (ElementClickInterceptedException e) {
            UseDriver.getDriver().findElement(By.xpath("//button[starts-with(@aria-label,'Check-in')]")).click();
        }

        Misc.sleep(2);

        String[] dateFields = DateUtil.getTomorrowDateFields();     // dateFields = [8, January, 2022]

        String datesLocator = "//h2[text()='"+dateFields[1]+" "+dateFields[2]+"']/following-sibling::table//button";

        List<WebElement> allDates = UseDriver.getDriver().findElements(By.xpath(datesLocator));

        for (WebElement date : allDates) {
            String dateValue = date.getText();
            String dateAttributeValue = date.getAttribute("data-day");
            if (dateAttributeValue == null) {
                dateAttributeValue = "";
            }
            if (dateValue.equalsIgnoreCase(dateFields[0]) || dateAttributeValue.equalsIgnoreCase(dateFields[0])) {
                date.click();
                break;
            }
        }

        String[] checkoutDateFields = DateUtil.addDaysToTomorrow(7);

        String checkoutDatesLocator = "//h2[text()='"+checkoutDateFields[1]+" "+checkoutDateFields[2]+"']/following-sibling::table//button";

        List<WebElement> allCheckoutDates = UseDriver.getDriver().findElements(By.xpath(checkoutDatesLocator));

        for (WebElement date : allCheckoutDates) {
            String dateValue = date.getText();
            String dateAttributeValue = date.getAttribute("data-day");
            if (dateAttributeValue == null) {
                dateAttributeValue = "";
            }
            if (dateValue.equalsIgnoreCase(dateFields[0]) || dateAttributeValue.equalsIgnoreCase(checkoutDateFields[0])) {
                date.click();
                break;
            }
        }

    }

    @Test
    public void AutoSuggestions() {
        /**
         * 1. Analyse if the auto-suggestions are present in dom as text-value or some attribute's-value
         * 2. Create locator to get all auto-suggestions webElements (//ul[contains(@data-stid, 'destination-results')]//strong)
         * 3. Use findElements method to get all auto-suggestions-WebElements
         * 4. use loop
         *      pick autoSuggestion-WebElement from List<WebElement>
         *      apply getText or getAttribute [depends on step#1]
         *      if (above-value is equal to option user wants to select)
         *          click the WebElement
         *          break the loop
         */
        UseDriver.openUrl("https://www.hotels.com/");

        UseDriver.getDriver().findElement(By.xpath("//button[contains(@data-stid, 'destination-menu')]")).click();

        UseDriver.getDriver().findElement(By.id("location-field-destination")).sendKeys("New");

        Misc.sleep(2);

        List<WebElement> allSuggestions = UseDriver.getDriver().findElements(By.xpath("//ul[contains(@data-stid, 'destination-results')]//strong"));

        for (WebElement suggestion : allSuggestions) {
            String suggestionText = suggestion.getText();
            if (suggestionText.equalsIgnoreCase("New Orleans")) {
                suggestion.click();
                break;
            }
        }



    }


    // Verify Values in Month dropdown is [Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec]
    @Test
    public void verifyMonthDropdown() {
        /*
            Array[] monthNames = [Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec]
            boolean isFail = false; //
            FindElements find all webElements with Month-values (List<WebElement>) (web1, web2, web3, ...)
            Loop
                pick a webElement (web1)
                if web1.getText() (Jan) is NOT equal to Array[0]
                    isFail = true
                    stop the loop
                pick a webElement (web2)
                if web2.getText() (Feb) is NOT equal to Array[1]
                    isFail = true
                    stop the loop
                ...
                ...
            // After loop
            Assert.assertFalse(isFail, "Dropdown values are not as expected")
         */
    }

}
