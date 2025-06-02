package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage {

    private static final By
            ACCOUNTS_LABEL = By.xpath("//h1[text()='Accounts']"),
            NEW_BUTTON = By.xpath("//div[@title='New' and text()='New']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ACCOUNTS_LABEL)));
        return this;
    }

    @Override
    public AccountsPage openPage() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com" +
                "/lightning/o/Account/list?filterName=__Recent");
        return this;
    }

    public NewAccountModal clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
        return new NewAccountModal(driver);
    }
}
