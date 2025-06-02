package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        driver.get(BASE_URL);
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_BUTTON)));
        return this;
    }

    public HomePage login(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    public void getErrorMessage() {
        driver.findElement(ERROR_MESSAGE).getText();
    }
}
