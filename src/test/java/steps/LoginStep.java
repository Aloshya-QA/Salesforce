package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginStep {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void auth(String userName, String password) {
        loginPage.openPage()
                .isPageOpened()
                .login(userName, password)
                .isPageOpened();
    }
}
