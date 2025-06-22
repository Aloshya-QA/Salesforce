package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {

    private static final By
            LOGIN_INPUT = By.id("username"),
            PASSWORD_INPUT = By.id("password"),
            LOGIN_BUTTON = By.id("Login"),
            ERROR_MESSAGE = By.id("error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        log.info("Opening LoginPage");
        driver.get(BASE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_BUTTON)));
            log.info("LoginPage is opened");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public HomePage login(String user, String password) {
        log.info("Log in with credential: {}, {}", user, password);
        driver.findElement(LOGIN_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    public void getErrorMessage() {
        driver.findElement(ERROR_MESSAGE).getText();
    }
}
