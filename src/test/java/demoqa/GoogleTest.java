package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleTest {

    @BeforeEach
    void setUp() {
        // Указываем браузер — chrome (можно изменить на firefox, edge и т.д.)
        Configuration.browser = "chrome";

        // Размер окна браузера
        Configuration.browserSize = "1920x1080";

        // Максимальное время ожидания загрузки страницы — 60 сек
        Configuration.pageLoadTimeout = 60000;

        // Открываем сайт Google
        open("https://www.google.com");
    }

    @Test
    void checkGoogleSearchField() {
        // Проверяем, что поле поиска отображается и доступно
        $("[name='q']").shouldBe(visible);
    }
}
