import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

/**
 * Created by kuzne4iki on 11/9/18.
 */
public class UtilityMethods {

    private static EventFiringWebDriver driver;
    private static WebElement elementToHover;
    private static WebElement elementToClick;

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e){
            System.out.println(e.getStackTrace());
        }
    }

    public void login(WebDriver driver, String email_field, String email_value,
                      String password_field, String password_value, String login_identifier) {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        UtilityMethods.sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.id(email_field)).sendKeys(email_value);
        driver.findElement(By.id(password_field)).sendKeys(password_value);
        driver.findElement(By.xpath(login_identifier)).click();
        UtilityMethods.sleep(3000);
    }

    public void logout(WebDriver driver, String logout_main_identifier, String logout_sub_identifier){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logout_main_identifier))).click();
        //driver.findElement(By.xpath(logout_main_identifier)).click();
        //driver.findElement(By.xpath(logout_sub_identifier)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logout_sub_identifier))).click();
    }


    public void subMenus(WebDriver driver) {
        List<WebElement> submenus_found = driver.findElements(By.xpath("//*[contains(@class,\"title has_submenu\")]"));
        int listik_size= submenus_found.size();
/*
 --------------------------------------

        The problem with StaleElementReferenceException is usually that you look up elements on a page,
        hold them in a variable and then do some interaction that causes the page to change or reload.
        It seems you are doing exactly this: the list variable is initialized first, then you loop
        through it and then you click a search button multiple times, which probably updates the page.
        This makes the list variable invalid and will cause the exception if you try to interact with any of it's elements.

       Within each iteration, initialize list again and take element i

*/

        for (int i=0; i<listik_size; i++){

            submenus_found = driver.findElements(By.xpath("//*[contains(@class,\"title has_submenu\")]"));
            WebElement submenu_page = submenus_found.get(i);

            // 2 - Кликнуть на каждом видимом пункте главного меню (Dashboard, Заказы, Каталог, Клиенты...) для открытия соответствующего раздела
            submenu_page.click();
            UtilityMethods.sleep(1000);

            WebDriverWait wait = new WebDriverWait(driver, 40);
            String title_initial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(@class,'page-title')]"))).getText();

            // 2a - Вывести в консоль заголовок открытого раздела.
            System.out.println(title_initial);

            //2b - Выполнить обновление рефреш страницы  и  проверить, что остается в  том  же  разделе после  перезагрузки страницы.
            driver.navigate().refresh();


            String title_refreshed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(@class,'page-title')]"))).getText();

            if( !title_initial.equals(title_refreshed) ) {
                System.out.println("Title after refreshing is not the same! \n" +
                        " It was " + title_initial + " it became" + title_refreshed );
            };

            driver.navigate().back();
            UtilityMethods.sleep(2000);

        }

    }

   public void printScriptNumber(String ScriptDescription){
       System.out.println("********************************") ;
       System.out.println("Execution of script defined as \' " + ScriptDescription + " \' has started") ;
   }

    public void quit(WebDriver driver){
        driver.quit();
        System.out.println("Browser was quitted successfully") ;
        System.out.println("********************************") ;
    }

    public void checkAlerts(WebDriver driver) {
        try {
           // WebDriverWait wait = new WebDriverWait(driver, 10);
           // wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            alert.accept();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }
    public String generateRandomString(int maxdDesiredLength){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        int lowerLimit = 3;
        int targetStringLength = random.nextInt((maxdDesiredLength - lowerLimit) + 1) + lowerLimit;

        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println(generatedString);
        return generatedString;
    }

    public int generateRandomInt(int min, int max){
        if (min >= max) {
            int temp = min;
            min=max;
            max=temp;
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public double generateRandomDouble(double min, double max){
        if (min >= max) {
            double temp = min;
            min=max;
            max=temp;
        }
        Random r = new Random();
        double randomValue = min + (max- min) * r.nextDouble();
        double twoDecimalValue =Double.parseDouble(new DecimalFormat("#.##").format(randomValue));
        return twoDecimalValue;
    }


    public static void hoverAndClick(WebDriver driver, WebElement elementToHover,WebElement elementToClick, String elementToClickXPath)  {
            Actions action = new Actions(driver);
            action.moveToElement(elementToHover);

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementToClickXPath)));

            action.moveToElement(elementToHover);
            action.click(elementToClick).build().perform();

    }

}


