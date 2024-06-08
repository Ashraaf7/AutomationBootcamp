import Pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_HomeTest {
    private WebDriver driver;


    @BeforeMethod
    public void setupDriver()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void logoutTC()
    {
       new P01_LoginPage(driver).loginSteps("admin","admin")
                .clickOnLogoutButton();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
