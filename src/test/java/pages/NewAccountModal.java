package pages;

import dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

import static wrappers.AccountField.*;

public class NewAccountModal extends BasePage {

    private static final By
            CANCEL_BUTTON = By.xpath("//button[text()='Cancel']"),
            SAVE_AND_NEW_BUTTON = By.xpath("//button[text()='Save & New']"),
            SAVE = By.xpath("//button[text()='Save']"),
            SUCCESSFUL_CREATION_POPUP = By.xpath(
                    "//div[@data-aura-class='forceToastMessage']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
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
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SAVE)));
        return this;
    }

    @Override
    public NewAccountModal openPage() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return this;
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickSaveAndNewButton() {
        driver.findElement(SAVE_AND_NEW_BUTTON).click();
    }

    public void clickSaveButton() {
        driver.findElement(SAVE).click();
    }

    public NewAccountModal createAccount(Account account) {
        return new NewAccountModal(driver)
                .input(ACCOUNT_NAME.getLabel(), account.getName())
                .input(PHONE.getLabel(), account.getPhone())
                .input(ACCOUNT_SITE.getLabel(), account.getAccountSite())
                .input(EMPLOYEES.getLabel(), account.getEmployees())
                .input(SIC_CODE.getLabel(), account.getSicCode())
                .input(TICKER_SYMBOL.getLabel(), account.getTickerSymbol())
                .input(FAX.getLabel(), account.getFax())
                .input(ANNUAL_REVENUE.getLabel(), account.getAnnualRevenue())
                .build();
    }

    public boolean isAccountCreated() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SUCCESSFUL_CREATION_POPUP)));
        return driver.findElement(SUCCESSFUL_CREATION_POPUP).isDisplayed();
    }
}
