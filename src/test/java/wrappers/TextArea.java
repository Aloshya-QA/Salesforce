package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {

    WebDriver driver;
    String label;

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void fill(String text) {
        driver.findElement(By.xpath(String.format(
                "//label[text()='%s']/ancestor::lightning-textarea//textarea", label))).sendKeys(text);
    }
}