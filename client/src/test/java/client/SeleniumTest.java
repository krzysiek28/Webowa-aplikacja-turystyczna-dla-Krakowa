package client;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    protected WebDriver driver;

    protected void prepareChromeDriver(){
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected void navigateToInitPage(){
        driver.get("http://localhost:8383/");
    }

    protected void navigateToRegisterPage(){
        driver.get("http://localhost:8383/registrationPage");
    }

    protected void navigateToLoginPage(){
        driver.get("http://localhost:8383/loginPage");
    }

    protected void closeChrome(){
        // Close the browser
        driver.quit();
    }


/*    	dependencies needed to tests
        <dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>22.0</version>
		</dependency>
        <dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>*/
}
