import org.openqa.selenium.WebDriver;

/**
 * Created by kuzne4iki on 11/4/18.
 */
public class Runner_Lectures_1_2 {

    public static void main(String ... args) throws InterruptedException {

        WebDriver driver = DriverManager.chooseDriver("firefox");
        UtilityMethods RunnerInstance = new UtilityMethods();


       // Script 1 (Lesson 2)
        System.out.println("First script");
        RunnerInstance.login("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/", driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );
        RunnerInstance.logout(driver, "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");


        // Script 2 (Lesson 2)
        System.out.println("*************");
        System.out.println("Second script");
        RunnerInstance.login("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/", driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );
        RunnerInstance.subMenus(driver);
        RunnerInstance.logout(driver, "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");

        driver.quit();


    }

}
