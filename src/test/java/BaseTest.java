import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Добавляем переменную страницы регистрации
    private WebDriver driver;
    //Добавляем переменные драйвера
    private SignUpPage page;

    @BeforeMethod
    public void setUp() {
        //Указываем путь где хранится geckodriver
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        //Создаем новый драйвер
        driver = new FirefoxDriver();
        //Добавляем неявное ожидание, используемое при поиске любого из элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Открываем url в браузере с помощью метода webdrivera get
        driver.get("https://www.spotify.com/us/signup/");
    }

    @Test
    public void typeInvalidYear() {
        //Создаём объект класса страницы регистрации и передаём в конструктор класса driver
        page = new SignUpPage(driver);
        //Устанавливаем месяц
        page.setMonth("December")
                //Указываем день
                .typeDay("20")
                //Указываем год
                .typeYear("85")
                //Жмём чекбокс
                .setShare(true);
        //Проверяем видимость ошибки, ошибка должна быть видна;
        Assert.assertTrue(page.isErrorVisible("Please enter a valid year."));
    }

    @AfterMethod
    //Метод, закрывающий браузер
    public void tearDown() {
        driver.quit();
    }
}