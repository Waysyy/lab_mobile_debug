import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class FirstTest extends CoreTestCase {

    public MainPageObject MainPageObject;
    public void setUp() throws  Exception{
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }



    @Test
    public void testSaveElement(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.ClickInput("Пропустить");
        SearchPageObject.ClickInput("Нет, спасибо");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Хоббит, или Туда и обратно");
        MainPageObject.pressEnterKey();

//        MainPageObject.waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']//*[@text='повесть английского писателя Джона Р. Р. Толкина']"),"Невозможно найти Хоббита", 15);
        SearchPageObject.ClickInput("повесть английского писателя Джона Р. Р. Толкина");
        SearchPageObject.waitForLoadPage("повесть английского писателя Джона Р. Р. Толкина");
        driver.tap(1, 380, 649, 1);
        SearchPageObject.ClickAtElement("page_save");
        SearchPageObject.ClickInput("Добавить в список");
        SearchPageObject.inputElement("Хоббит");
        SearchPageObject.ClickInput("ОК");
        SearchPageObject.ClickInput("Посмотреть список");
        SearchPageObject.waitForLoadPage("Статей доступно офлайн:");
        SearchPageObject.getMoreSettings();
        driver.tap(1, 1166, 987, 1);
        SearchPageObject.ClickInput("Удалить список");
        SearchPageObject.deleteElement("ОК");
    }


}
