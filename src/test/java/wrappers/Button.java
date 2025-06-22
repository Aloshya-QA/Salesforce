package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    WebDriver driver;
    String xpath;

    public Button(WebDriver driver, String xpath) {
        this.driver = driver;
        this.xpath = xpath;
    }

    public void click() {
        driver.findElement(By.xpath(xpath)).click();
    }
}
