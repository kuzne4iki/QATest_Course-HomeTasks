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
        Runner RunnerInstance = new Runner();
            RunnerInstance.login(driver);
            RunnerInstance.subMenus(driver);
            RunnerInstance.logout(driver);
    }

    public void login(WebDriver driver) throws InterruptedException{
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.xpath("//button[contains(.,'Вход')]")).click();
        Thread.sleep(2000);
    }

    public void logout(WebDriver driver){
        driver.findElement(By.xpath("//img[contains(@height,'32')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Выход')]")).click();
        driver.quit();
    }


    public void subMenus(WebDriver driver) throws InterruptedException {
        List<WebElement> submenus_found = driver.findElements(By.xpath("//*[contains(@class,\"title has_submenu\")]"));
        int listik_size= submenus_found.size();
/*
 --------------------------------------

        The problem with StaleElementReferenceException is usually that you look up elements on a page,
        hold them in a variable and then do some interaction that causes the page to change or reload.
        It seems you are doing exactly this: the list variable is initialized first, then you loop
        through it and then you click a search button multiple times, which probably updates the page.
        This makes the list variable invalid and will cause the exception if you try to interact with any of it's elements.

        What might work in this case is if you do the following:

       Within each iteration, initialize list again and take element i

*/

        for (int i=0; i<listik_size; i++){

                //WebDriverWait wait = new WebDriverWait(driver, 5);
                //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,\"title has_submenu\")]")));
            submenus_found = driver.findElements(By.xpath("//*[contains(@class,\"title has_submenu\")]"));
            WebElement submenu_page = submenus_found.get(i);

            // 2 - Кликнуть на каждом видимом пункте главного меню (Dashboard, Заказы, Каталог, Клиенты...) для открытия соответствующего раздела
            submenu_page.click();
            Thread.sleep(1000);
            String title_initial = driver.getTitle();

            // 2a - Вывести в консоль заголовок открытого раздела.
            System.out.println(title_initial);

            //2b - Выполнитьобновлениерефрешстраницы  и  проверить, что остается в  том  же  разделе после  перезагрузки страницы.
            driver.navigate().refresh();
            String title_refreshed = driver.getTitle();
            title_refreshed= "";

            if( !title_initial.equals(title_refreshed) ) {
                System.out.println("Title after refreshing is not the same! \n" +
                        " It was " + title_initial + " it became" + title_refreshed );
            };

            driver.navigate().back();
            Thread.sleep(2000);

        }

    }
}
