package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Dependencies {
    private SoftAssert softAssert;
    private WebDriver driver;
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test");
    }
    @BeforeClass
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

   @Test
   public void registerTC()  //pass
   {
       Assert.fail();
       
   }

   @Test(dependsOnMethods = "registerTC",alwaysRun = true)
    public void loginTC()
    {
        System.out.println("Login TC");
    }

    @AfterClass
    public void quit()
    {
        driver.quit();
    }
}
