import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class Selenium {

    public static WebDriver driver;
    public static String firstTab;

    public static void main(String[] args) throws IOException, AWTException, URISyntaxException {
        initializeDriver();
        openBrowser("https://the-internet.herokuapp.com/broken_images");
        // manageWindow(); //maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //general
        List<WebElement> elements = driver.findElements(By.tagName("img"));//47
        checkBrokenUsingRestAssured(elements, "photo");
    }

    public static void checkBrokenUsingRestAssured(List<WebElement> elements, String type) throws IOException, URISyntaxException {
        URL url = null;
        String attribute;
        if (type.equals("photo"))
            attribute = "src";
        else
            attribute = "href";
        for (WebElement element : elements) {
            url = new URI(element.getAttribute(attribute)).toURL();
            Response response = RestAssured.given().get(url);
            System.out.println(response.getStatusLine());
        }

    }

    public static void checkBroken(List<WebElement> elements, String type) throws IOException, URISyntaxException {
        URL url = null;
        String attribute;
        if (type.equals("photo"))
            attribute = "src";
        else
            attribute = "href";
        for (WebElement element : elements) {
            url = new URI(element.getAttribute(attribute)).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection.getResponseMessage() + " " + httpURLConnection.getResponseCode());
        }

    }

    public static void initializeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("download.default_directory", "F:\\MyApps\\Autoamtion Jan Round\\SeleniumSessions\\src\\main\\resources");
        edgeOptions.addExtensions(new File("C:\\Users\\ahmed\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default\\Extensions\\hnfepfakgcalolgicjdfmaaellnondji\\2.6.7_0.crx"));
        edgeOptions.setExperimentalOption("prefs", hashMap);
        driver = new EdgeDriver(edgeOptions);
    }


    public static void downloadFiles() {
        driver.findElement(By.cssSelector("a[href='download/10.png']")).click();
    }

    public static void uploadUsingRobot(String path) throws AWTException {
        driver.findElement(By.id("chooseFileBtn")).click();
        StringSelection stringSelection = new StringSelection(path); //CTRL+C
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); //CTRL+C
        Robot robot = new Robot();

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void uploadUsingSendKeys(String path) {
        driver.findElement(By.id("file-upload")).sendKeys(path);
    }

    public static void takingScreenShoot(String imageName) throws IOException {
        String path = "F:\\MyApps\\Autoamtion Jan Round\\SeleniumSessions\\src\\main\\resources\\";
        File src = ((TakesScreenshot) byToWebElement(By.id("inputEmail"))).getScreenshotAs(OutputType.FILE);
        File target = new File(path + imageName + ".png");//F:\MyApps\Autoamtion Jan Round\SeleniumSessions\src\main\resources\test.png
        FileUtils.copyFile(src, target);
    }

    public static void scrollingUsingJS() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", byToWebElement(By.id("scroll_text"))); //a
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .not(ExpectedConditions.attributeToBeNotEmpty(byToWebElement(By.id("scroll_text")), "disabled")));
        driver.findElement(By.id("scroll_text")).sendKeys("test");
    }

    public static void scrollingUsingActions() {

        new Actions(driver).scrollToElement(byToWebElement(By.id("scroll_text")))
                .perform();

        driver.findElement(By.id("scroll_text")).sendKeys("test");
    }

    public static void keysUsingActions() {
        By textField = By.id("target");
        new Actions(driver).keyDown(byToWebElement(textField), Keys.SHIFT)
                .sendKeys(byToWebElement(textField), "ahmed")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
    }


    public static void keyUsingSendKeys() {
        driver.findElement(By.id("target")).sendKeys(Keys.ARROW_DOWN);
    }

    public static void prompt() {
        driver.findElement(By.cssSelector("[onClick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Ahmed");
        alert.accept();
    }

    public static void dismissAlert() {
        driver.findElement(By.cssSelector("[onClick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
    }

    public static void acceptAlert() {
        driver.findElement(By.cssSelector("[onClick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public static void nestedFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        //driver.switchTo().parentFrame(); //Top
        //driver.switchTo().parentFrame(); //window
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),\"B\")]")).getText());
    }

    public static void iFrame() {
        By textArea = By.cssSelector("body#tinymce p");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(textArea).clear();
        driver.findElement(textArea).sendKeys("Ahmed");
        driver.switchTo().parentFrame();
    }

    public static void switchingTab(String handle) {

        driver.switchTo().window(handle);
    }

    public static Set<String> openNewTab() {
        By newTabButton = By.cssSelector("a[href='/windows/new']");
        driver.findElement(newTabButton).click();
        firstTab = driver.getWindowHandle();
        return driver.getWindowHandles(); //2
    }

    public static void hover() {
        By picture = By.xpath("(//img)[2]");
        new Actions(driver).moveToElement(byToWebElement(picture)).perform();
    }

    public static void clickAndHold() {
        By box_a = By.id("column-a");
        By box_b = By.id("column-b");
        new Actions(driver).clickAndHold(byToWebElement(box_b))
                .moveToElement(byToWebElement(box_a))
                .release()
                .build()
                .perform();

    }

    public static void dragAndDrop() {
        By box_a = By.id("column-a");
        By box_b = By.id("column-b");
        new Actions(driver).dragAndDrop(byToWebElement(box_a), byToWebElement(box_b)).perform();
    }

    public static void rightClick() {
        By box = By.id("hot-spot");
        new Actions(driver).contextClick(byToWebElement(box)).perform();
    }

    public static void doubleClick() {
        By checkboxButton = By.xpath("//button[text()='Show Checkboxes']");
        By ahlyCheckbox = By.id("Ahly");
        driver.findElement(checkboxButton).click();
        new Actions(driver).doubleClick(byToWebElement(ahlyCheckbox)).perform();
    }

    public static void checkElementIsEnabled() {
        By email = By.id("inputEmail");
        System.out.println("Email field is enabled: " + driver.findElement(email).isEnabled());
    }

    public static void checkElementIsDisplayed() {
        By email = By.id("inputEmail");
        System.out.println("Email field is displayed: " + driver.findElement(email).isDisplayed());
    }

    public static void checkboxIsSelected() {
        By ahlyCheckbox = By.id("Ahly");
        By zamalekCheckbox = By.id("Zamalek");
        System.out.println("First checkbox is selected: " + driver.findElement(ahlyCheckbox).isSelected()); //true / false
        System.out.println("Second checkbox is selected: " + driver.findElement(zamalekCheckbox).isSelected());
    }


    public static void handlingRadioButtons() {
        By radio = By.id("vfb-7-1");
        driver.findElement(radio).click();
    }

    public static void handlingCheckboxes() {
        By checkbox = By.cssSelector("input[type='checkbox']:nth-of-type(1)");
        driver.findElement(checkbox).click();
    }

    public static void handlingDropdown() {
        By dropDown = By.cssSelector("select#dropdown");
        int size = new Select(byToWebElement(dropDown)).getOptions().size();
        System.out.println(size);
    }

    public static void fluentWait(By locator) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .withMessage(locator.toString() + "doesn't meet the criteria")
                .pollingEvery(Duration.ofMillis(1L))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void explicitWait(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(byToWebElement(locator)));
    }

    public static void getHelloWorld() {
        By startButton = By.tagName("button");
        By helloWorldMsg = By.xpath("//div[@id='finish'] /h4");
        driver.findElement(startButton).click();
        //explicitWait(helloWorldMsg);
        fluentWait(helloWorldMsg);
        String msg = driver.findElement(helloWorldMsg).getText();
        System.out.println(msg);
    }

    public static void clearText() {
        By usernameLocator = By.id("username");
        driver.findElement(usernameLocator).clear();
    }

    public static String getTextFromField() {
        By flashMessage = By.cssSelector("div#flash");
        return driver.findElement(flashMessage).getText();
        //  System.out.println(msg);
    }


    public static void clicking() {
        By loginButton = By.className("radius");
        driver.findElement(loginButton).click();
    }

    public static void enterText(String username, String password) //dynamic
    {
        By usernameLocator = By.id("username");
        By passwordLocator = By.id("password");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
    }


    public static WebElement byToWebElement(By locator) {
        return driver.findElement(locator);
    }

    public static void openBrowser(String url) {
        driver.get(url);
    }

    public static void openBrowserUsingNavigation(String url) {
        driver.navigate().to(url);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void clickOnForward() {
        driver.navigate().forward();
    }

    public static void clickOnBack() {
        driver.navigate().back();
    }

    public static void manageWindow() {
        // Dimension dimension = new Dimension(430,932);
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();
        // driver.manage().window().setSize(new Dimension(430,932));
        // driver.manage().window().setPosition(new Point(100,100));
    }

    public static void getCurrentUrlOfThePage() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    public static void printTitleOfThePage() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public static void getSourceCode() {
        String sourceCode = driver.getPageSource();
        System.out.println(sourceCode);
    }

    public static void getWindowId() //Handle
    {
        String handle1 = driver.getWindowHandle();
        System.out.println(handle1);

        driver.switchTo().newWindow(WindowType.TAB);
        String handle2 = driver.getWindowHandle();
        System.out.println(handle2);

    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void quitBrowser() {
        driver.quit();
    }
}
