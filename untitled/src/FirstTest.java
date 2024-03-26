import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "OnePlus Nord 3 5G");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\Waysy\\IdeaProjects\\untitled\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstTest(){
        waitForElementAndClick(By.xpath("//*[contains(@text,'Пропустить')]"), "Невозможно нажать на поле ввода", 15);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Нет, спасибо')]"), "Невозможно нажать на поле ввода", 15);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Поиск по Википедии')]"), "Невозможно нажать на поле ввода", 15);
        waitForElementAndSendKeysEnter(By.xpath("//*[contains(@text,'Поиск')]"), "Хоббит, или Туда и обратно", "Невозможно найти поле ввода", 5);


        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='повесть английского писателя Джона Р. Р. Толкина']"),"Невозможно найти Хоббита", 15);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Понятно')]"), "Невозможно нажать на поле ввода", 15);
        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),"Невозможно найти Хоббита", 15);
        waitForElementAndClick(By.xpath("//*[contains(@text,'Добавить в список')]"), "Невозможно нажать на поле ввода", 15);

//        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"),"Невозможно найти Хоббита", 15);
//
//        waitForElementAndClick(By.xpath("//*[contains(@text,'Добавить в другой список для чтения')]"), "Невозможно нажать на поле ввода", 15);
//        waitForElementAndClick(By.xpath("//*[contains(@text,'Создать новый')]"), "Невозможно нажать на поле ввода", 15);
//        waitForElementAndSendKeys(By.xpath("//*[@resource-id='org.wikipedia:id/page_save']"), "Хоббит", "Невозможно найти поле ввода", 5);
//        waitForElementAndClick(By.xpath("//*[contains(@text,'ОК')]"), "Невозможно нажать на поле ввода", 15);
//
//        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_toolbar_button_tabs']"),"Невозможно найти Хоббита", 15);
//        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/close_tab_button']"),"Невозможно найти Хоббита", 15);
//        waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/close_tab_button']"),"Невозможно найти Хоббита", 15);
    }

    private WebElement waitForElementPresent(By by, String error_message, long timoutSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timoutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timoutSeconds){
        WebElement element = waitForElementPresent(by, error_message, timoutSeconds);
        element.click();
        return  element;

    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timoutSeconds){
        WebElement element = waitForElementPresent(by, error_message, timoutSeconds);
        element.sendKeys(value);
        return  element;

    }
    private void pressEnterKey() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }
    private WebElement waitForElementAndSendKeysEnter(By by, String value, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.sendKeys(value);
        pressEnterKey(); // Добавляем нажатие клавиши Enter
        return element;
    }


}
