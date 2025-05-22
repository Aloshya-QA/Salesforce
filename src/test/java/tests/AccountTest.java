package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest{

    @Test
    public void checkCreateAccount() {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("tborodich@tms.sandbox");
        driver.findElement(By.id("password")).sendKeys("Password002!");
        driver.findElement(By.id("Login")).click();
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=__Recent");
        driver.findElement(By.cssSelector("[title=New]")).click();
        driver.findElement(By.xpath("//*[@name='Name']")).sendKeys("TMS");
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
    }
}
