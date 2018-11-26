
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Random;

/**
 * Created by kuzne4iki on 11/4/18.
 */


public class Runner_Lecture_5 extends EventCapture {
    WebDriver driver;
    UtilityMethods utilities;
    EventFiringWebDriver eventHandler;
    EventCapture eCapture;
    CatalogueMerchandise items;
    String merchandiseNameEntered;

    @BeforeTest
    @Parameters({"browser_name"})
    @Test
    public void testPreparation(String browser_name) {
        driver = DriverManager.chooseDriver(browser_name);
        utilities = new UtilityMethods();

        eventHandler = new EventFiringWebDriver(driver);
        eCapture = new EventCapture();
        eventHandler.register(eCapture);
        utilities.printScriptNumber("Fifth script");

    }


    @Parameters({"urlGUI"})
    @Test(dependsOnMethods = {"testPreparation"})
    public void checkDisplayCorrectness(String urlGUI) {
        eventHandler.get(urlGUI);
        WebDriverWait wait = new WebDriverWait(eventHandler, 40);


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Все товары\uE315')]"))).click();

        // TO CONTINUE FROM HERE
        //determining qty of elemenst and choosing a random out of them

        List<WebElement> listik = eventHandler.findElements(By.xpath("(//div[contains(@class,'thumbnail-container')])"));
        int qtyElementsFound = listik.size();
        System.out.println("Qty of elements found: " + qtyElementsFound);

        if (qtyElementsFound > 0) {
            Random random = new Random();

            int lowerLimit = 1;
            int randomIndexToClick = random.nextInt((qtyElementsFound - lowerLimit) + 1) + lowerLimit;
            System.out.println("Index of random element to be clicked is : " + randomIndexToClick);

            eventHandler.findElement(By.xpath("(//div[contains(@class,'thumbnail-container')])[" + randomIndexToClick + "]")).click();
        } else {
            System.out.println("No elements found to choose from");
            return;
        }
    }

    @AfterClass
        public void tearDown(){
        utilities.quit(driver);
    }


    }

