import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by kuzne4iki on 11/10/18.
 */
public class CataloguePage extends CatalogueBase {

    public CataloguePage(WebDriver driver) {
        //this.driver = eventHandler;
        super(driver);
    }

    // !!! looks like hovering event is not supported by EventFiringWebDriver so need to use here regular driver instead
    public void choose_submenu(String xPathMainManu, String xPathSubMenu)  {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathMainManu)));
        WebElement elementToHover = driver.findElement(By.xpath(xPathMainManu));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathSubMenu)));
        WebElement elementToClick = driver.findElement(By.xpath(xPathSubMenu));
        UtilityMethods.hoverAndClick(driver, elementToHover, elementToClick, xPathSubMenu);//"//a[contains(.,'категории')]");
    }

    /*public void addCategorie(String xPathAddCategory, String nameToEnter){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathAddCategory))).click();
        WebElement createNew = driver.findElement(By.xpath("//input[@id='name_1']"));
        createNew.sendKeys(nameToEnter);
        driver.findElement(By.xpath("//button[contains(.,'Сохранить')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alert alert-success'][contains(.,'×\n" +
                "\t\t\tСоздано')]")));

    }
    */

    //TODO
    public void sortAndVerifyPresence(String nameEntered){
        driver.findElement(By.xpath("//div[@class='panel-heading']//i[@class='process-icon-refresh']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),nameEntered)]")));
        if(driver.findElements(By.xpath("//td[contains(text(),nameEntered)]")).size() != 0){
            System.out.println("Element " + nameEntered +  " is Present");
        }else{
            System.out.println("Element " + nameEntered +  " is Absent");
        }



    }

}

//div[@class='panel-heading']