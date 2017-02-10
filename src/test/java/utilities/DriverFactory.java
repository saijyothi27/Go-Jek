package utilities;

/**
 * Created by saijyoth on 2/7/2017.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;


    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }



    public WebDriver createNewDriverInstance() {
        driver = new ChromeDriver();
        String pathToChrome = "C:\\Users\\saijyoth\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cleartrip.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public WebDriver getDriver() {

        return driver;

    }
    public void destroyDriver() {

        driver.quit();
        driver=null;
    }

}
