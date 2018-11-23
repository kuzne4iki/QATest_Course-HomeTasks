import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;

/**
 * Created by kuzne4iki on 11/6/18.
 */
public class DriverManager {
    private static WebDriver driver;

    public static WebDriver chooseDriver(String driverName) {
        switch (driverName) {
            case "firefox":
                System.setProperty("webdriver.chrome.driver", new File(DriverManager.class.getResource("geckodriver").getFile()).getPath());
                //There are 3 states for UnexpectedAlertBehaviour:
                //ACCEPT - Accepts the alert
                //DISMISS - Closes/Cancels the alert
                //IGNORE - Neither accepts nor closes the alert //

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                driver = new FirefoxDriver(firefoxOptions);
                return driver;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", new File(DriverManager.class.getResource("chromedriver").getFile()).getPath());
                return new ChromeDriver();

            default:
                System.setProperty("webdriver.chrome.driver", new File(DriverManager.class.getResource("geckodriver").getFile()).getPath());
                return new FirefoxDriver();

        }

    }
}