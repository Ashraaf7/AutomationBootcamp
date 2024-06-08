import Pages.P01_LoginPage;
import Utilities.DataUtil;
import Utilities.Utility;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginTest {
    private WebDriver driver;
    String USERNAME = new Faker().name().username();


    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertyValue("environments","LOGIN_URL"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Description("This test case verify that user logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ashraf")
    @Link(name = "Bissness Document" , url = "https://www.google.com")
    @Issue("www.jira.com")
    @TmsLink("www.jira.com/zephyr/TC50")
    @Epic("Web Panel")
    @Feature("Login")
    @Story("Valid Login on Web")
    @Test
    public void validLoginTC() throws IOException {
        enterUsername();
        new P01_LoginPage(driver)
                .enterPassword(DataUtil.getJsonData("validLoginData","password"))
                        .clickOnLoginButton();
        Utility.takeScreenshot(driver,"validLoginTC");
        Assert.assertEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("environments","HOME_URL"));
    }
    @Step("Step 1")
    public void enterUsername() throws FileNotFoundException {
        new P01_LoginPage(driver).enterUsername(DataUtil.getJsonData("validLoginData","username"));
    }
    @Test
    public void inValidLoginTC() throws IOException {
        System.out.println(USERNAME);
        new P01_LoginPage(driver).enterUsername(USERNAME)
                .enterPassword(DataUtil.getJsonData("validLoginData","password"))
                .clickOnLoginButton();
        Assert.assertNotEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("environments","HOME_URL"));
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
