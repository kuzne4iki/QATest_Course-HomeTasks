
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

/**
 * Created by kuzne4iki on 11/4/18.
 */


public class Runner_Lecture_4_TestNG {
    WebDriver driver;
    UtilityMethods RunnerInstance;
    EventFiringWebDriver eventHandler;
    EventCapture eCapture;

    @BeforeTest
    @Parameters({ "browser_name", "value" })
    public void testPreparation(){
        driver = DriverManager.chooseDriver("browser_value");
        RunnerInstance = new UtilityMethods();

        eventHandler = new EventFiringWebDriver(driver);
        eCapture = new EventCapture();
        eventHandler.register(eCapture);
        RunnerInstance.printScriptNumber("Forth script");

    }

    @Test
        public void logintoPage(){
        // 1. Войти в Админ Панель
        RunnerInstance.login(eventHandler, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        Catalogue_Page catalogue = new Catalogue_Page(eventHandler);
    }



    @AfterTest
        public void afterTest(){
        RunnerInstance.quit(driver);
    }



//RunnerInstance.logout(eventHandler , "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");


}
