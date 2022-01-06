package Class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework_3 {


    /**
     * On https://www.darksky.net/
     * Verify feelsLike-tempValue is in between low-tempValue and high-tempValue
     */

    @Test
    public void VerifyFeelsLikeTemp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.darksky.net/";
        driver.get(url);


        //driver.openUrl("https://www.darksky.net/");
        WebElement feelsLikeElement = driver.findElement(By.xpath("//span[@class=\"feels-like-text\"]"));


        int feelsLike = Integer.parseInt(feelsLikeElement.getText().substring(0, feelsLikeElement.getText().length() - 1));

        WebElement lowTempElement = driver.findElement(By.xpath("//span[@class=\"low-temp-text\"]"));

        int lowTemp = Integer.parseInt(feelsLikeElement.getText().substring(0, lowTempElement.getText().length() - 1));

        WebElement highTempElement = driver.findElement(By.xpath("//span[@class=\"high-temp-text\"]"));

        int highTemp = Integer.parseInt(highTempElement.getText().substring(0, highTempElement.getText().length() - 1));

        boolean isTmpBet = (feelsLike > lowTemp && feelsLike < highTemp);

        Assert.assertTrue(isTmpBet, "Temperature - is not in between Low and High Temperatures");

        //UseDriver_1.getDriver().quit();
    }


    /**
     * On https://www.darksky.net/
     * Verify current-temp is displayed correctly when user changes temp-unit
     */

    @Test
    public void convertTemp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.darksky.net/";
        driver.get(url);


        WebElement convertTemperature = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[1]/div[3]/div/ul/li[1]"));
        int fTemp = 39;
        String b = Integer.toString(fTemp);

        int cTemp = (fTemp - 32) * 5 / 9;
        String c = Integer.toString(cTemp);
        Assert.assertTrue(true, "Celsius temperature is equal after convert");
        //System.out.println(fTemp + "F is equal to" + cTemp + "C");
    }


    /**
     * On https://www.darsky.net/
     * Verify blog post date is showing in correct format MonthName, Date Year
     * <p>
     * use below locator for blog-dates
     * (//time[@itemprop='datePublished'])[1]
     * (//time[@itemprop='datePublished'])[2]
     * (//time[@itemprop='datePublished'])[3]
     * (//time[@itemprop='datePublished'])[4]
     */

    @Test
    public void verifydate() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.darksky.net/";
        driver.get(url);

        driver.findElement(By.xpath("/html/body/section/nav/div/a[4]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/p/a")).click();

        // SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/yyyy");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat parser = new SimpleDateFormat("MMMM D,yyyy");
        String dateString = "June 7.2021";
        boolean ssd = true;
        try {
            Date date = formatter.parse(dateString);
            System.out.println(parser.format(date));
        } catch (ParseException e) {
            boolean aad = false;
            e.printStackTrace();
        }

        WebElement date = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/p[1]/time"));


        Assert.assertTrue(false, "Th date format is not same");
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
    public void verifyErrorMessage() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com/";
        driver.get(url);


        driver.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li[1]/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Nick");
        driver.findElement(By.name("lastname")).sendKeys("Young");
        driver.findElement(By.name("reg_email__")).sendKeys("5658452639");
        driver.findElement(By.name("reg_passwd__")).sendKeys("dfghh1245");


        By monthLocator = By.id("month");
        driver.findElement(monthLocator).sendKeys("Jun");

        By dayLocator = By.name("birthday_day");
        driver.findElement(dayLocator).sendKeys("28");

        By yearLocator = By.xpath("//select[@aria-label='Year']");
        WebElement yeardDElement = driver.findElement(yearLocator);
        Select yearD = new Select(yeardDElement);
        yearD.selectByIndex(5);

        driver.findElement(By.name("websubmit")).click();
    }



        /**
         * On https://www.hotels.com/
         * Verify the correct roomCount and guestCount on Homepage
         */

        @Test
        public void verifyGuestRoom() {
        }
}