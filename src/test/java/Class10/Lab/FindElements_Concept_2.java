package Class10.Lab;

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

public class FindElements_Concept_2 {
    /**
     * To find multiple webElements using a locator
     * Method: findElements
     * return type: List<WebElement>
     */

    @Test
    public void AutoSuggestions() {
        /**
         * 1. Analyse if the auto-suggestions are present in dom as text-value or some attribute's-value (attribute's value -> aria-label)
         * 2. Create locator to get all auto-suggestions webElements (//div[@class='s-suggestion'])
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

        List<WebElement> allSuggestions = UseDriver.getDriver().findElements(By.xpath("//div[@class='s-suggestion']"));

        for (WebElement suggestion : allSuggestions) {
            String suggestionValue = suggestion.getAttribute("aria-label");
            if (suggestionValue.equalsIgnoreCase("phone tripod")) {
                suggestion.click();
                break;
            }
        }



    }

}
