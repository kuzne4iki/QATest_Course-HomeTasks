
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

/**
 * Created by kuzne4iki on 11/4/18.
 */


public class Runner_Lecture_4_TestNG {
    WebDriver driver;
    UtilityMethods utilities;
    EventFiringWebDriver eventHandler;
    EventCapture eCapture;

    @BeforeTest
    @Parameters({ "browser_name", "value" })
    public void testPreparation(){
        driver = DriverManager.chooseDriver("browser_value");
        utilities = new UtilityMethods();

        //eventHandler = new EventFiringWebDriver(driver);
        //eCapture = new EventCapture();
       // eventHandler.register(eCapture);
        utilities.printScriptNumber("Forth script");

    }

    @Test
        public void createProduct(){
        // 1. Войти в Админ Панель
        utilities.login(driver, "email", "webinar.test@gmail.com","passwd", "Xcg7299bnSmMuRLp9ITw", "//button[contains(.,'Вход')]" );

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        CataloguePage catalogue = new CataloguePage(driver);
        catalogue.choose_submenu("//span[contains(.,'Каталог')]","(//a[contains(.,'товары')])[1]");
        CatalogueMerchandise items = new CatalogueMerchandise(driver);
        //String nameEntered = "NEW ITEM NAME";
        String nameEntered = utilities.generateRandomString(20);
        items.addNewElement("//span[contains(.,'Новый товар')]",
                "//input[@id='form_step1_name_1']",
                "//input[@id='form_step1_qty_0_shortcut']",
                "//input[contains(@name,'form[step1][price_shortcut]')]",
                nameEntered,
                "//div[contains(@class,'switch-input')]",
                "//button[@class='btn btn-primary js-btn-save'][contains(.,'Сохранить')]");

    }

/*
    @Test(dependsOnMethods = "createProduct")
    public void checkAlert(){
        utilities.checkAlerts(driver);

    }

    @AfterClass
        public void tearDown(){
        utilities.quit(driver);
    }
*/


//RunnerInstance.logout(eventHandler , "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");


}
