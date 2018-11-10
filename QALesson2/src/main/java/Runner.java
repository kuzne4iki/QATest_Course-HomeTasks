import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kuzne4iki on 11/4/18.
 */
public class Runner {

    public static void main(String ... args) throws InterruptedException {

        WebDriver driver = DriverManager.chooseDriver("firefox");
        UtilityMethods RunnerInstance = new UtilityMethods();

        // Script 1
        System.out.println("First script");
        RunnerInstance.login(driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );
        RunnerInstance.logout(driver, "//img[contains(@height,'32')]", "//a[contains(.,'Выход')]");


        // Script 2
        System.out.println("*************");
        System.out.println("Second script");
        RunnerInstance.login(driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );
        RunnerInstance.subMenus(driver);
        RunnerInstance.logout(driver, "//img[contains(@height,'32')]", "//a[contains(.,'Выход')]");

        driver.quit();
    }

}
