import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by kuzne4iki on 11/6/18.
 */
public class DriverManager {
    private static WebDriver driver;

    public static WebDriver chooseDriver(String driverName) {
        switch (driverName) {
            case "firefox":
                System.setProperty("webdriver.chrome.driver", "/Users/kuzne4iki/Documents/STUDYING/java1/QALesson2/src/main/drivers/geckodriver");
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/kuzne4iki/Documents/STUDYING/java1/QALesson2/src/main/drivers/chromedriver");
                return new ChromeDriver();

            default:
                System.setProperty("webdriver.chrome.driver", "/Users/kuzne4iki/Documents/STUDYING/java1/QALesson2/src/main/drivers/geckodriver");
                return new FirefoxDriver();

        }

    }
}