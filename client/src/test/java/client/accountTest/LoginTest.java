package client.accountTest;

import client.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends SeleniumTest{

    private WebElement user;
    private WebElement pass;

    @BeforeTest
    public void setUp(){
        prepareChromeDriver();
        navigateToLoginPage();

        user = driver.findElement(By.name("username"));
        pass = driver.findElement(By.name("password"));
    }

    @Test
    public void logIn() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath(".//div[@class='form-actions']/input"));

        user.sendKeys("test");
        pass.sendKeys("test");
        button.click();
        Thread.sleep(200);
        String logout = driver.findElement(By.xpath("//nav/div[@class='btn-group']/button")).getText();
        assertEquals("Wyloguj się", logout);
    }

    @AfterTest
    public void tearDown(){
        closeChrome();
    }
}
