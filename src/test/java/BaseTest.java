import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Добавляем переменную страницы регистрации
    private WebDriver driver;
    //Добавляем переменные драйвера
    private SignUpPage page;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    public void tearDown(){
        driver.quit();
    }

}