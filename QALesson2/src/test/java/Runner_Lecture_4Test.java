
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by kuzne4iki on 11/4/18.
 */


public class Runner_Lecture_4Test extends EventCapture{
    WebDriver driver;
    UtilityMethods utilities;
    EventFiringWebDriver eventHandler;
    EventCapture eCapture;
    CatalogueMerchandise items;
    String merchandiseNameEntered;

    @BeforeTest
    @Parameters({ "browser_name"})
    public void testPreparation(String browser_name){
        driver = DriverManager.chooseDriver(browser_name);
        utilities = new UtilityMethods();

        eventHandler = new EventFiringWebDriver(driver);
        eCapture = new EventCapture();
       eventHandler.register(eCapture);
        utilities.printScriptNumber("Forth script");

    }


    @DataProvider(name = "credentialsDataAdmin")
    public static Object[][] loginData() {
        return new Object[][] {
                {"http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/",
                "email",
                "webinar.test@gmail.com",
                "passwd",
                "Xcg7299bnSmMuRLp9ITw",
                "//button[contains(.,'Вход')]"}};
    }

    @Test(dataProvider = "credentialsDataAdmin")
        public void createProduct(String url, String email_field, String email_value,
                                  String password_field, String password_value, String login_identifier){
        // 1. Войти в Админ Панель
        utilities.login(url, eventHandler, email_field, email_value,
                password_field, password_value, login_identifier);

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        CataloguePage catalogue = new CataloguePage(eventHandler);
        catalogue.choose_submenu("//span[contains(.,'Каталог')]","(//a[contains(.,'товары')])[1]");
        items = new CatalogueMerchandise(eventHandler);
        merchandiseNameEntered = utilities.generateRandomString(20);
        System.out.println("Random name entered is "+ merchandiseNameEntered);

        items.addNewElement("//span[contains(.,'Новый товар')]",
                "//input[@id='form_step1_name_1']",
                "//input[@id='form_step1_qty_0_shortcut']",
                "//input[contains(@name,'form[step1][price_shortcut]')]",
                merchandiseNameEntered,
                "//div[contains(@class,'switch-input')]",
                "//button[@class='btn btn-primary js-btn-save'][contains(.,'Сохранить')]");

    }


    @Test(dependsOnMethods = "createProduct")
    public void checkSavingAlert(){
        utilities.checkAlerts(eventHandler);

    }


    @Parameters({ "urlGUI"})
    @Test(dependsOnMethods = {"createProduct", "checkSavingAlert"} )
    public void checkCorrectCreation(String urlGUI){
        eventHandler.get(urlGUI);
        WebDriverWait wait = new WebDriverWait(eventHandler, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Все товары\uE315')]"))).click();

        WebElement merchandiseCreated = eventHandler.findElement(By.xpath("//a[contains(.,merchandiseNameEntered)]"));

        // VERIFICATIONS
        Assert.assertTrue(merchandiseCreated.isDisplayed());
        System.out.println("Random name entered is verified");
        merchandiseCreated.click();

        double priceEntered = items.getGeneratedPrice();
        int qtyEntered = items.getGeneratedQty();
        System.out.println("Random price entered is "+ priceEntered);
        System.out.println("Random price entered is "+ qtyEntered);

        // Here we enter the value of price and qty in the xpath parameters to determine the elements presence
        WebElement priceCreated = eventHandler.findElement(By.xpath("//span[contains(@content, priceEntered )]"));
        System.out.println("Random price entered is verified");
        WebElement qtyCreated = eventHandler.findElement(By.xpath("//span[contains(., qtyEntered)]"));
        System.out.println("Random qty entered is verified");

    }

    @AfterClass
        public void tearDown(){
        utilities.quit(driver);
    }


}
