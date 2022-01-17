package Class10;

import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alert_Concept {
    @Test
    public void alertTest() {

        UseDriver.openUrl("http://demo.guru99.com/test/delete_customer.php/");

        UseDriver.getDriver().findElement(By.name("cusid")).sendKeys("1234");

        UseDriver.getDriver().findElement(By.name("submit")).click();

        WebDriverWait webDriverWait = new WebDriverWait(UseDriver.getDriver(), 20);
        webDriverWait.until(ExpectedConditions.alertIsPresent());

        /**
         * To interact with an Alert, we need to switch on the Alert.
         * Method: switchTo().alert()
         */
        Alert myAlert = UseDriver.getDriver().switchTo().alert();

        /**
         * To get the text of alert
         * Method: getText()
         */
        String alertText = myAlert.getText();
        System.out.println("Alert text -> " + alertText);
        Assert.assertEquals(alertText, "Do you really want to delete this Customer?", "Alert message is not as expected");

        /**
         * To type in inputBox of an alert
         * Method: sendKeys
         */
        // myAlert.sendKeys("1234");

        Misc.sleep(5);

        /**
         * To click on +ve action button
         * Method: accept()
         */
        myAlert.accept();

        /**
         * To click on -ve action button
         * Method: dismiss()
         */
        // myAlert.dismiss();



    }
}
