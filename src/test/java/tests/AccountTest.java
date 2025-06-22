package tests;

import dto.Account;
import dto.AccountFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest extends BaseTest{

    @Test(testName = "Проверка создания аккаунта", groups = {"Regression"})
    @Description("Проверяет, что пользователь может успешно создать аккаунт через модальное окно.")
    @Step("Создание аккаунта")
    public void checkCreateAccount() {
        Account account = AccountFactory.getMaxAccount();
        loginStep.auth(user, password);
        newAccountModal.openPage()
                .isPageOpened()
                .createAccount(account)
                .clickSaveButton();
        assertThat(newAccountModal.isAccountCreated()).isTrue();
    }
}
