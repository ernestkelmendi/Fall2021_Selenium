package Class5;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Concept {
    /**
     *  MouseHover      ->      moveToElement()
     *  click           ->      click()
     *  type            ->      sendKeys()
     *  Drag and Drop   ->      dragAndDrop()
     *  double click    ->      doubleClick()
     *  right click     ->      contextClick()
     *
     */

    @Test
    public void Actions_Demo() {

        /*
            Launch https://www.classroomessentialsonline.com/
            move mouse on CHURCH CHAIRS
            click ECONOMY CHURCH CHAIRS
         */

        UseDriver.openUrl("https://www.classroomessentialsonline.com/");

        // By churchChairsLocator = By.partialLinkText("Church Chairs ");

        By churchChairsLocator = By.xpath("//a[@href='/church-chairs/']");
        WebElement churchChairs = UseDriver.getDriver().findElement(churchChairsLocator);
        Actions act = new Actions(UseDriver.getDriver());
        act.moveToElement(churchChairs).build().perform();

        Misc.sleep(1);

        By economyChurchChairsLocator = By.xpath("//a[@href='/economy-church-chairs/']");
        WebElement economyChurchChairs = UseDriver.getDriver().findElement(economyChurchChairsLocator);
        // economyChurchChairs.click();      // using click-method from Selenium library


        act.click(economyChurchChairs).perform();   // Using click-method from Actions class

        /**
         *  .build().perform() vs .perform()
         *
         *  when a method (from Actions class) is doing more than 1 action -> .build().perform()
         *  when a method (from Actions class) is doing only 1 action -> .perform() is enough
         *      [but we can use .build().perform() as well]
         *
         */

        UseDriver.quitWebPages();
    }

}
