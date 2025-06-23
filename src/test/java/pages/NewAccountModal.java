package pages;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.Button;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

import static wrappers.AccountField.*;

@Log4j2
public class NewAccountModal extends BasePage {

    private static final String
            CANCEL_BUTTON = "//button[text()='Cancel']",
            SAVE_AND_NEW_BUTTON = "//button[text()='Save & New']",
            SAVE_BUTTON = "//button[text()='Save']",
            SUCCESSFUL_CREATION_POPUP = "//div[@data-aura-class='forceToastMessage']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    private NewAccountModal click(String xpath) {
        new Button(driver, xpath).click();
        return this;
    }

    private NewAccountModal input(String label, String value) {
        new Input(driver, label).fill(value);
        return this;
    }

    private NewAccountModal picklist(String label, String value) {
        new Picklist(driver, label).select(value);
        return this;
    }

    private NewAccountModal textArea(String label, String value) {
        new TextArea(driver, label).fill(value);
        return this;
    }

    private NewAccountModal build() {
        return new NewAccountModal(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(SAVE_BUTTON))));
            log.info("NewAccountModal is Opened");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    @Override
    public NewAccountModal openPage() {
        log.info("Opening NewAccountModal");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return this;
    }

    public void clickCancelButton() {
        log.info("Click Cancel Button");
        click(CANCEL_BUTTON);
    }

    public void clickSaveAndNewButton() {
        log.info("Click Save&New Button");
        click(SAVE_AND_NEW_BUTTON);
    }

    public void clickSaveButton() {
        log.info("Click Save Button");
        click(SAVE_BUTTON);
    }

    public NewAccountModal createAccount(Account account) {
        log.info("Creating account: {}", account.getName());
        return new NewAccountModal(driver)
                .input(ACCOUNT_NAME.getLabel(), account.getName())
                .input(PHONE.getLabel(), account.getPhone())
                .input(ACCOUNT_SITE.getLabel(), account.getAccountSite())
                .input(EMPLOYEES.getLabel(), account.getEmployees())
                .input(SIC_CODE.getLabel(), account.getSicCode())
                .input(TICKER_SYMBOL.getLabel(), account.getTickerSymbol())
                .input(FAX.getLabel(), account.getFax())
                .build();
    }

    public boolean isAccountCreated() {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(SUCCESSFUL_CREATION_POPUP))));
            log.info("NewAccount is created");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("NewAccount isn't created");
        }
        return driver.findElement(By.xpath(SUCCESSFUL_CREATION_POPUP)).isDisplayed();
    }
}
