package Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseDriver {
    static WebDriver driver;

    public static void openUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitWebPages() {
        driver.quit();
    }
}
