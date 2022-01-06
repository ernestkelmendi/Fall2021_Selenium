package Class5.Facebook;

import Web.UseDriver;
import org.openqa.selenium.By;

public class MessengerLoginFail {
    By incorrectEmailErrorLocator = By.xpath("//div[text()='Incorrect email or phone number' or text()='Incorrect email address or phone number']");


    public boolean isIncorrectEmailErrorDisplayed() {
        return UseDriver.getDriver().findElement(incorrectEmailErrorLocator).isDisplayed();
    }
}

