import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kuzne4iki on 11/22/18.
 */
public class CatalogueMerchandise extends CatalogueBase {

    public CatalogueMerchandise(WebDriver driver) {
        //this.driver = eventHandler;
        super(driver);
    }

    //Overload the method of the base class by adding extra fields to fill in
    public void addNewElement(String xPathAddCategory, String xPathTextField, String xPathQtyField,
                              String xPathPriceField, String nameToEnter,
                              String xPathSwitch, String xPathSave){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathAddCategory))).click();
        WebElement createNewName = driver.findElement(By.xpath(xPathTextField));
        createNewName.sendKeys(nameToEnter);

        WebElement createNewQty = driver.findElement(By.xpath(xPathQtyField));
        createNewQty.clear();
        int generatedQty = utilityMethods.generateRandomInt(1,100); // values hardcoded as numbers are known
        createNewQty.sendKeys(""+generatedQty);
        //System.out.println("Qty is "+generatedQty);

        WebElement createNewPrice = driver.findElement(By.xpath(xPathPriceField));
        createNewPrice.clear();
        double generatedPrice = utilityMethods.generateRandomDouble(0.1,100);
        createNewPrice.sendKeys(""+generatedPrice);
        //System.out.println("Price is "+generatedQty);

        driver.findElement(By.xpath(xPathSave)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathSwitch))).click();
        utilityMethods.checkAlerts(driver);
    }
}
