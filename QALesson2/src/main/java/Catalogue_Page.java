import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by kuzne4iki on 11/10/18.
 */
public class Catalogue_Page {

    public static void choose_submenu(WebDriver driver, String xPathMainManu, String xPathSubMenu) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathMainManu)));
        WebElement elementToHover = driver.findElement(By.xpath(xPathMainManu));

       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathSubMenu)));
        WebElement elementToClick = driver.findElement(By.xpath(xPathSubMenu));
        UtilityMethods.hoverAndClick(driver, elementToHover, elementToClick);
    }

    public static void addCategorie(WebDriver driver, String xPathAddCategory, String nameToEnter){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathAddCategory))).click();
        WebElement createNew = driver.findElement(By.xpath("//input[@id='name_1']"));
        createNew.sendKeys(nameToEnter);
        driver.findElement(By.xpath("//button[contains(.,'Сохранить')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alert alert-success'][contains(.,'×\n" +
                "\t\t\tСоздано')]")));

    }

    //TODO
    public static boolean sortAndVerifyPresence(){
        boolean result = false;
        return result;
    }

}

