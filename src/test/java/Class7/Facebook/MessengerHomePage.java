package Class7.Facebook;

import Web.UseDriver;
import org.openqa.selenium.By;

public class MessengerHomePage {
    By loginButtonLocator = By.id("loginbutton");



    public void clickLoginButton() {
        UseDriver.getDriver().findElement(loginButtonLocator).click();
    }

}
