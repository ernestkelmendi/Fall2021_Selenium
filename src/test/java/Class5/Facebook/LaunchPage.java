package Class5.Facebook;

import Web.UseDriver;
import org.openqa.selenium.By;

public class LaunchPage {
    // Locators of elements on Launch Page
    By loginEmailLocator = By.id("email");
    By loginPasswordLocator = By.id("pass");
    By loginButtonLocator = By.xpath("//button[@name='login']");
    By messengerLocator = By.linkText("Messenger");



    // Methods to interact with elements of Launch Page

    // type in login emailBox
    public void enterLoginEmail(String loginEmail) {
        UseDriver.getDriver().findElement(loginEmailLocator).sendKeys(loginEmail);
    }

    // if login emailBox is enabled
    public boolean isLoginEmailBoxEnabled() {
        return UseDriver.getDriver().findElement(loginEmailLocator).isEnabled();
    }

    // type in login passwordBox
    public void enterLoginPassword(String loginPwd) {
        UseDriver.getDriver().findElement(loginPasswordLocator).sendKeys(loginPwd);
    }
    // if login passwordBox is enabled

    // click login button
    public void clickLoginButton() {
        UseDriver.getDriver().findElement(loginButtonLocator).click();
    }

    // if login button is enabled

    // to click the Messenger link
    public void clickMessengerLink() {
        UseDriver.getDriver().findElement(messengerLocator).click();
    }
}
