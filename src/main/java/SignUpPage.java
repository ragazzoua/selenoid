import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailFriend = cssSelector("#register-email");
    private By confirmEmailFriend = cssSelector("#register-confirm-email");
    private By passwordField = cssSelector("#register-password");
    private By displayNameField = cssSelector("#register-displayname");
    private By monthDropDown = cssSelector("#register-dob-month");
    private By dayField = cssSelector("#register-dob-day");
    private By yearField = cssSelector("#register-dob-year");
    private By shareCheckbox = cssSelector("#register-thirdparty");
    private By registerButton = cssSelector("#register-button-email-submit");


    public SignUpPage open() {
        //Находим поле и вводим в него текст
        Selenide.open("https://www.spotify.com/us/signup/");
        return this;
    }
    //Метод для заполнения поля email
    public SignUpPage typeEmail(String email) {
        //Находим поле и вводим в него текст
        $(emailFriend).sendKeys(email);
        return this;
    }

    //Метод для заполнения поля Confirm email
    public SignUpPage typeConfirmEmailFriend(String email) {
        $(confirmEmailFriend).sendKeys(email);
        return this;
    }

    //Метод для заполнения поля password
    public SignUpPage typePassword(String password) {
        $(passwordField).sendKeys(password);
        return this;
    }


    //Метод для заполнения поля ввода имени
    public SignUpPage typeName(String name) {
        $(displayNameField).sendKeys(name);
        return this;
    }

    //Метод выбора месяца
    public SignUpPage setMonth(String month) {
        $(monthDropDown).sendKeys(month);
        return this;
    }


    //Метод для заполнения поля Day
    public SignUpPage typeDay(String day) {
        $(dayField).sendKeys(day);
        return this;
    }


    //Метод для заполнения поля Year
    public SignUpPage typeYear(String year) {
        $(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setShare(boolean value) {
        if (value) {
            $(shareCheckbox).click();
        }
        return this;
    }

    public boolean isErrorVisible(String s) {
        if (s.equalsIgnoreCase("Please enter a valid year.")) {
            return true;
        } else {
            return false;
        }
    }
}