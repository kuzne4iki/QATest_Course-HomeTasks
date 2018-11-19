import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by kuzne4iki on 11/4/18.
 */
public class Runner_Lecture_3 {
    // Script 3 (Lesson 3)
    // Plug-in class-listener (EventCapture)

    public static void main(String ... args) throws InterruptedException {

        WebDriver driver = DriverManager.chooseDriver("firefox");
        UtilityMethods RunnerInstance = new UtilityMethods();

        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        EventCapture eCapture = new EventCapture();
        eventHandler.register(eCapture);


        //System.out.println("Third script");
        RunnerInstance.printScriptNumber("Third script");

        // 1. Войти в Админ Панель
        RunnerInstance.login(eventHandler, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        Catalogue_Page catalogue = new Catalogue_Page(eventHandler);
        catalogue.choose_submenu("//span[contains(.,'Каталог')]","//a[contains(.,'категории')]");

        //3. Нажать «Добавить категорию» для перехода к созданию новой категории.
        // 4. После загрузки страницы ввести название новой категории и сохранить изменения. На
        //странице управления категориями должно появиться сообщение об успешном создании категории.

        String nameEntered = "NEW TESTIK NAME";
        catalogue.addCategorie("(//div[contains(.,'Добавить категорию')])[7]", nameEntered);

        // 5. Отфильтровать таблицу категорий по имени и дождаться там появления записи созданной категории.
        catalogue.sortAndVerifyPresence(nameEntered);

        RunnerInstance.logout(eventHandler , "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");

        RunnerInstance.quit(driver);
        //driver.quit();

    }

}
