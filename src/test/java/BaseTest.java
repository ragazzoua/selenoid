import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Добавляем переменную страницы регистрации
    private WebDriver driver;
    //Добавляем переменные драйвера
    private SignUpPage page;

    @BeforeClass
    public void setUp() {

    }

    @Test
    public void typeInvalidYear() {
        //Создаём объект класса страницы регистрации и передаём в конструктор класса driver
        page = new SignUpPage(driver);
        //Устанавливаем месяц
        page.open().setMonth("December")
                //Указываем день
                .typeDay("20")
                //Указываем год
                .typeYear("85")
                //Жмём чекбокс
                .setShare(true);
        //Проверяем видимость ошибки, ошибка должна быть видна;
        Assert.assertTrue(page.isErrorVisible("Please enter a valid year."));
    }

}