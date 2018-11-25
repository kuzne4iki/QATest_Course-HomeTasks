
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


public class Runner_Lecture_4_TestNG {
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

        //eventHandler = new EventFiringWebDriver(driver);
        //eCapture = new EventCapture();
       // eventHandler.register(eCapture);
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
        utilities.login(url, driver, email_field, email_value,
                password_field, password_value, login_identifier);

        // 2. Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        CataloguePage catalogue = new CataloguePage(driver);
        catalogue.choose_submenu("//span[contains(.,'Каталог')]","(//a[contains(.,'товары')])[1]");
        items = new CatalogueMerchandise(driver);
        merchandiseNameEntered = utilities.generateRandomString(20);
        items.addNewElement("//span[contains(.,'Новый товар')]",
                "//input[@id='form_step1_name_1']",
                "//input[@id='form_step1_qty_0_shortcut']",
                "//input[contains(@name,'form[step1][price_shortcut]')]",
                merchandiseNameEntered,
                "//div[contains(@class,'switch-input')]",
                "//button[@class='btn btn-primary js-btn-save'][contains(.,'Сохранить')]");

    }

    @DataProvider(name = "credentialsDataGUI")
    public static Object[][] loginDataGUI() {
        return new Object[][] {
                {"http://prestashop-automation.qatestlab.com.ua",
                        "email",
                        "webinar.test@gmail.com",
                        "passwd",
                        "Xcg7299bnSmMuRLp9ITw",
                        "//button[contains(.,'Вход')]"}};
    }

    @Test(dependsOnMethods = "createProduct")
    public void checkSavingAlert(){
        utilities.checkAlerts(driver);

    }


    @Parameters({ "urlGUI"})
    @Test(dependsOnMethods = {"createProduct", "checkSavingAlert"} )
    public void checkCorrectCreation(String urlGUI){
    driver.get(urlGUI);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Все товары\uE315')]"))).click();

        WebElement merchandiseCreated = driver.findElement(By.xpath("//a[contains(.,merchandiseNameEntered)]"));
        Assert.assertTrue(merchandiseCreated.isDisplayed());
        merchandiseCreated.click();

        WebElement priceCreated = driver.findElement(By.xpath("//span[contains(@content, items.getGeneratedPrice() )]"));
        WebElement qtyCreated = driver.findElement(By.xpath("//span[contains(., items.getGeneratedQty() )]"));
        //double priceEntered = items.getGeneratedPrice();
        //int qtyEntered = items.getGeneratedQty();

        System.out.print(priceCreated.getText());
        System.out.print(qtyCreated.getText());

        //Assert.assertEquals(prices);
        //Assert.assertEquals(qtties)

    }

/*
    @AfterClass
        public void tearDown(){
        utilities.quit(driver);
    }

*/

//RunnerInstance.logout(eventHandler , "(//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg'])[1]", "//a[contains(.,'Выход')]");


}
