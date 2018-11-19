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
        System.out.println("Logging event : beforeAlertAccept");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("Logging event : afterAlertAccept");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("Logging event : afterAlertDismiss");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("Logging event : beforeAlertDismiss");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Logging event : beforeNavigateTo");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Logging event : afterNavigateTo");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Logging event : beforeNavigateBack");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Logging event : afterNavigateBack");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Logging event : beforeNavigateForward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Logging event : afterNavigateForward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Logging event : beforeNavigateRefresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("Logging event : afterNavigateRefresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Logging event : beforeFindBy");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Logging event : afterFindBy");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Logging event : beforeClickOn");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Logging event : afterClickOn");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Logging event : beforeChangeValueOf");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Logging event : afterChangeValueOf");
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
        System.out.println("Logging event : onException");
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
