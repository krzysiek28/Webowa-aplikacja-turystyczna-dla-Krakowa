package client.accountTest;

import client.SeleniumTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class DeleteAccountTest extends SeleniumTest{

    private final static String logIn = ".//*[@id='mainWrapper']/div/div/div/form/div[3]/input";

    @BeforeTest
    public void setUp() {
        prepareChromeDriver();
        navigateToLoginPage();
    }

    @Test
    public void deleteUser() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("test");
        driver.findElement(By.xpath(logIn)).click();
        Thread.sleep(100);
        String logout = driver.findElement(By.xpath("//nav/div[@class='btn-group']/button")).getText();
        assertEquals("Wyloguj się", logout);
        //send request with Method.DELETE
//        response = driver.re('DELETE', 'http://localhost:8384/users/test');
//        driver.get("");
//        driver.get("http://localhost:8384/loginPage");
//
//        driver.findElement(By.name("username")).sendKeys("test");
//        driver.findElement(By.name("password")).sendKeys("test");
//        driver.findElement(By.xpath(logIn)).click();
//        assertEquals("Wyloguj się", logout);
//        String communicate = driver.findElement(By.xpath(".//*[@id='mainWrapper']//form/div[@class='alert alert-danger']/p")).getText();
//        assertEquals("Niepoprawna nazwa użytkownika lub hasło", communicate);
    }

    @AfterTest
    public void tearDown() throws Exception {
        closeChrome();
    }

    private By toBy(String xpath){
        return By.xpath(xpath);
    }
}
