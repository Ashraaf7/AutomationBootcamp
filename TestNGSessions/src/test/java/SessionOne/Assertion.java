package SessionOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class Assertion {
    private SoftAssert softAssert;
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test(priority = 5,groups = {"regression","broken"})
    public void hardAssertValidLoginTestCase()
    {
        driver.findElement(By.id("Username")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertTrue(expected,"Assert True that expected value is true "); //
    }

    @Test(priority = 2,groups = {"smoke"})
    public void softAssertValidLoginTestCase()
    {
        driver.findElement(By.id("Username")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        softAssert = new SoftAssert();
        boolean expected = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        softAssert.assertTrue(expected,"Assert True that expected value is true ");
        softAssert.assertAll();
    }
    @Test(priority = 7,groups = {"smoke","broken"})
    public void inValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("ahmed"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }
    @Test(priority = 7,groups = {"regression"})
    public void inValidLoginTestCaseUsingInvalidUsername()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("ahmed"); //username
        driver.findElement(By.id("inputPassword")).sendKeys("admin"); //password
        driver.findElement(By.id("loginButton")).click(); //login
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }


    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driver.quit();
    }

}
