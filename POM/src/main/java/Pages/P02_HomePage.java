package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {
    private WebDriver driver;
    private  final By LOGOUT_BUTTON = By.xpath("//button[contains(@class,logout)]");

    public P02_HomePage(WebDriver driver) {
        this.driver = driver ;
    }

    public P01_LoginPage clickOnLogoutButton()
    {
        Utility.clickOnElement(driver,LOGOUT_BUTTON);
        return new P01_LoginPage(driver);
    }
}
