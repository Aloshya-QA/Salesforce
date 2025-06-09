package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public static final String BASE_URL = "https://tms9-dev-ed.develop.my.salesforce.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void jsZoom(int zoom) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("document.body.style.zoom='%d%%'"), zoom);
    }

    public abstract BasePage isPageOpened();
    public abstract BasePage openPage();

}
