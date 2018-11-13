import com.sun.tools.javac.comp.Todo;
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

        // Script 1 (Lesson 2)
        System.out.println("First script");
        RunnerInstance.login(driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );
        RunnerInstance.logout(driver, "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");


        // Script 2 (Lesson 2)
        System.out.println("*************");
        System.out.println("Second script");
        RunnerInstance.login(driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );
        RunnerInstance.subMenus(driver);
        RunnerInstance.logout(driver, "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");

        //driver.quit();


        /*
        // Script 3 (Lesson 3)
        System.out.println("Third script");

        // 1. Войти в Админ Панель
        RunnerInstance.login(driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        Catalogue_Page.choose_submenu(driver, "//span[contains(.,'Каталог')]","//a[contains(.,'категории')]");

        //3. Нажать «Добавить категорию» для перехода к созданию новой категории.
        // 4. После загрузки страницы ввести название новой категории и сохранить изменения. На
        //странице управления категориями должно появиться сообщение об успешном создании категории.
        Catalogue_Page.addCategorie(driver, "(//div[contains(.,'Добавить категорию')])[7]", "NEW TESTIK NAME");


        // 5. Отфильтровать таблицу категорий по имени и дождаться там появления записи созданной категории.

        //RunnerInstance.logout(driver, "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");

*/
    }

}
