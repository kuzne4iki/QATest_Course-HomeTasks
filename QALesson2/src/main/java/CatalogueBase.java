import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kuzne4iki on 11/22/18.
 */
public class CatalogueBase {
    public WebDriver driver = null;
    public UtilityMethods utilityMethods;

    public CatalogueBase(WebDriver driver) {
        this.driver = driver;
        this.utilityMethods = new UtilityMethods();
    }

    public void addNewElement(String xPathAddCategory,
                              String xPathTextField,
                              String nameToEnter,
                              String xPathSave){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathAddCategory))).click();
        WebElement createNew = driver.findElement(By.xpath(xPathTextField));
        createNew.sendKeys(nameToEnter);
        driver.findElement(By.xpath(xPathSave)).click();
    }
}
