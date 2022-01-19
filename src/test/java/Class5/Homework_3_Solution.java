package Class5;

import Helper.DateUtil;
import Helper.Misc;
import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Homework_3_Solution {
    // Due date: Dec 27 2021

    /**
     * On https://www.darksky.net/
     * Verify feelsLike-tempValue is in between low-tempValue and high-tempValue
     */
    @Test
    public void verifyFeelsLinkTempRange() {
        /*
            Steps (write steps in automation code to practice how to write manual testcases
            Testcase: Verify feelsLike tempValue is in between the lowTemp and highTemp value
            1. Launch darksky.net
            2. Verify feelsLike tempValue is in between the lowTemp and highTemp value
         */
        UseDriver.openUrl("https://www.darksky.net/ ");

        String feelsLikeOnWeb = UseDriver.getDriver().findElement(By.xpath("//span[@class='feels-like-text']")).getText();
        String lowTempOnWeb = UseDriver.getDriver().findElement(By.xpath("//span[@class='low-temp-text']")).getText();
        String highTempOnWeb = UseDriver.getDriver().findElement(By.xpath("//span[@class='high-temp-text']")).getText();

        int feelsLinkTemp = Misc.removeDegreeAndGetTempAsInt(feelsLikeOnWeb);
        int lowTemp = Misc.removeDegreeAndGetTempAsInt(lowTempOnWeb);
        int highTemp = Misc.removeDegreeAndGetTempAsInt(highTempOnWeb);

        Assert.assertTrue(highTemp>=feelsLinkTemp && feelsLinkTemp>=lowTemp, "feelsLike tempValue is NOT in between the lowTemp and highTemp value");

        UseDriver.quitWebPages();

    }

    /**
     * On https://www.darksky.net/
     * Verify current-temp is displayed correctly when user changes temp-unit
     */
    @Test
    public void verifyTempConversion() {
        /*
            Steps (write steps in automation code to practice how to write manual testcases
            Testcase: Verify temp value is displayed correctly when user changes the temp unit (from ˚F to ˚C)
            1. Launch darksky.net
            2. Change Temp unit from ˚F to ˚C
            3. Verify temp value is displayed correctly when user changes the temp unit from ˚F to ˚C
         */
        UseDriver.openUrl("https://www.darksky.net/ ");

        String fTempText = UseDriver.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
        int fTemp = Misc.removeDegreeAndGetTempAsInt(fTempText);

        By tempUnitButton = By.xpath("(//div[contains(@class, 'selectric-units')]//div[@class='selectric'])[1]//span");
        UseDriver.getDriver().findElement(tempUnitButton).click();
        Misc.sleep(1);

        By firstDegCelsiusButton = By.xpath("(//div[contains(@class, 'selectric-open')]//div[@class='selectric-scroll']//li[contains(text(), '˚C')])[1]");
        UseDriver.getDriver().findElement(firstDegCelsiusButton).click();
        Misc.sleep(1);

        String cTempText = UseDriver.getDriver().findElement(By.xpath("//span[@class='summary swap']")).getText();
        int cTemp = Misc.removeDegreeAndGetTempAsInt(cTempText);

        System.out.println(fTemp);
        System.out.println(cTemp);
        int fTempIntoCTemp = Misc.convertFTempIntoCTemp(fTemp);

        Assert.assertEquals(cTemp, fTempIntoCTemp, "temp value is NOT displayed correctly when user changes the temp unit from ˚F to ˚C");

        UseDriver.quitWebPages();
    }

    /**
     * On https://www.darsky.net/
     * Verify blog post date is showing in correct format MonthName, Date Year
     *
     * use below locator for blog-dates
     * (//time[@itemprop='datePublished'])[1]
     * (//time[@itemprop='datePublished'])[2]
     * (//time[@itemprop='datePublished'])[3]
     * (//time[@itemprop='datePublished'])[4]
     */
    @Test
    public void verifyDateFormat() {
        /*
            Steps (write steps in automation code to practice how to write manual testcases
            Testcase: Verify date format on blog post
            1. Launch darksky.net
            2. Click on DarkSky API
            3. Click on blog post
            4. Verify dates are displayed in "MonthName, Date Year" format
         */
        UseDriver.openUrl("https://www.darksky.net/ ");

        UseDriver.getDriver().findElement(By.partialLinkText("Dark Sky API")).click();
        Misc.sleep(2);

        UseDriver.getDriver().findElement(By.partialLinkText("blog post")).click();
        Misc.sleep(2);

        // Currently using separate locator for each Date-element
        // later, when we cover findElements, then I can update code with 1-locator for all date-Elements
        // and using 1-locator and findElements, I can get all Date-elements in a List
        String date1Text = UseDriver.getDriver().findElement(By.xpath("(//time[@itemprop='datePublished'])[1]")).getText();
        String date2Text = UseDriver.getDriver().findElement(By.xpath("(//time[@itemprop='datePublished'])[2]")).getText();
        String date3Text = UseDriver.getDriver().findElement(By.xpath("(//time[@itemprop='datePublished'])[3]")).getText();
        String date4Text = UseDriver.getDriver().findElement(By.xpath("(//time[@itemprop='datePublished'])[4]")).getText();
        String[] allDatesText = {date1Text, date2Text, date3Text, date4Text};

        boolean isAllDatesCorrect = false;

        for (String dateText : allDatesText) {
            isAllDatesCorrect = DateUtil.isDateInCorrectFormat(dateText, "MMMM d, yyyy");
            if (!isAllDatesCorrect) {
                break;
            }
        }

        Assert.assertTrue(isAllDatesCorrect, "All dates are not in correct format");

        UseDriver.quitWebPages();

    }

    /**
     * On https://www.facebook.com/
     * Enter values in below fields:
     * First name
     * Last name
     * Mobile number
     * New password
     * Date of birth
     * Click "Sign Up"
     * Verify error msg (Please choose a gender. You can change who can see this later.) is displayed
     */
    @Test
    public void verifyGenderErrorOnSignUp() {
        /*
            Steps (write steps in automation code to practice how to write manual testcases
            Testcase: Verify gender not selected error on Sign up form
            1. Launch facebook.com
            2. Click on Create New Account
            3. Enter first name
            4. Enter last name
            5. Enter mobile number
            6. Enter new password
            7. Enter date of birth
            8. Click on Sign Up
            9. Verify Please select gender error is displayed
         */
        UseDriver.openUrl("https://www.facebook.com");

        UseDriver.getDriver().findElement(By.xpath("//a[text()='Create new account' or text()='Create New Account']")).click();
        Misc.sleep(1);

        UseDriver.getDriver().findElement(By.name("firstname")).sendKeys("John");
        UseDriver.getDriver().findElement(By.name("lastname")).sendKeys("Oliver");
        UseDriver.getDriver().findElement(By.name("reg_email__")).sendKeys("9846353738");
        UseDriver.getDriver().findElement(By.name("reg_passwd__")).sendKeys("myPassw0rd");

        WebElement monthElement = UseDriver.getDriver().findElement(By.id("month"));
        Select monthDropdown = new Select(monthElement);
        monthDropdown.selectByVisibleText("Jan");

        WebElement dateElement = UseDriver.getDriver().findElement(By.id("day"));
        Select dayDropdown = new Select(dateElement);
        dayDropdown.selectByVisibleText("1");

        WebElement yearElement = UseDriver.getDriver().findElement(By.id("year"));
        Select yearDropdown = new Select(yearElement);
        yearDropdown.selectByVisibleText("2000");

        UseDriver.getDriver().findElement(By.name("websubmit")).click();
        Misc.sleep(2);

        boolean isErrorDisplayed = UseDriver.getDriver().findElement(By.xpath("//div[text()='Please choose a gender. You can change who can see this later.']")).isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Please select gender error is NOT displayed");

        UseDriver.quitWebPages();
    }

    /**
     * On https://www.hotels.com/
     * Verify the correct roomCount and guestCount on Homepage
     */
}
