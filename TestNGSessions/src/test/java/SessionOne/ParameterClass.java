package SessionOne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import Listeners.IInvocedMethod;
import java.time.Duration;

import Listeners.Iretry;
public class ParameterClass {
    private SoftAssert softAssert;
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    @Parameters(value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("edge") String browser)
    {
        switch (browser)
        {
            case "chrome":
                driverThreadLocal.set(new ChromeDriver());
                break;
            default:
                driverThreadLocal.set(new EdgeDriver());
        }
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameters(value = {"username","password"})
    @Test()
    public void validLoginTestCase(@Optional("admin") String username, @Optional("admin") String password) //calling
    {
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username); //username
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password); //password
        driverThreadLocal.get().findElement(By.id("loginButton")).click(); //login
        boolean expected = driverThreadLocal.get().getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertTrue(expected,"Assert True that expected value is true "); //
    }
    @Parameters(value = {"username","password"})
    @Test(retryAnalyzer = Iretry.class)
    public void validLoginTestCase2(@Optional("ahmed") String username, @Optional("ashraf") String password) //calling
    {
        LogUtility.LOGGER.info("Test case started");
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username); //username
        LogUtility.LOGGER.info("username:ahmed is written");
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password); //password
        LogUtility.LOGGER.info("password:ashraf is written");
        driverThreadLocal.get().findElement(By.id("loginButton")).click(); //login
        LogUtility.LOGGER.info("login button is clicked");
        boolean expected = driverThreadLocal.get().getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        LogUtility.LOGGER.warn("value:" + expected);
        Assert.assertTrue(expected,"Assert True that expected value is true "); //
    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
