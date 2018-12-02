package client.accountTest;

import client.SeleniumTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class CreateAccountTest extends SeleniumTest {

    private WebElement user, pass, email;

    @BeforeTest
    public void setUp(){
        prepareChromeDriver();
        navigateToRegisterPage();

        email = driver.findElement(By.name("email"));
        user = driver.findElement(By.name("username"));
        pass = driver.findElement(By.name("password"));
    }

    @Test
    public void createAccount() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath(".//div[@class='form-actions']/input"));

        email.sendKeys("test@yahoo.com");
        user.sendKeys("test");
        pass.sendKeys("test");
        button.submit();
        Thread.sleep(100);
        String logout = driver.findElement(By.xpath(".//nav/div[@class='btn-group']/button")).getText();
        assertEquals("Wyloguj się", logout);
    }

    @AfterTest
    public void tearDown() throws Exception {
        closeChrome();
    }
}
