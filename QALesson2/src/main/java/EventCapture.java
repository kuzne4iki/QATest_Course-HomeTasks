import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by kuzne4iki on 11/10/18.
 */
//Дополнительно необходимо описать логгер, который будет выводить в консоль
//базовые действия драйвера в процессе выполнения скрипт
//(переход на страницу, поиск элементов, клики по элементам).

public class EventCapture implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("Logging event : alert accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("Logging event : alert dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Logging event : navigated to the indicated url");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Logging event : navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Logging event : navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("Logging event : navigated to refresh the page");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Logging event : element found " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Logging event : element clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Logging event : value of element was changed");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("Logging event : beforeScript");
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        System.out.println("Logging event : afterScript");
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Logging event : Exception occured");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
