package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        log.info("Opening HomePage");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/setup/SetupOneHome/home");
        return this;
    }

    @Override
    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".uiImage")));
            log.info("HomePage is opened");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }
}