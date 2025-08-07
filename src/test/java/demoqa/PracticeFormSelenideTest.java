package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PracticeFormSelenideTest {

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillFormTest() {
        $("#firstName").setValue("Акнур");
        $("#lastName").setValue("QA");
        $("#userEmail").setValue("aknur@example.com");
        $x("//label[text()='Female']").click();
        $("#userNumber").setValue("7777777777");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--015:not(.outside-month)").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $x("//label[text()='Music']").click();

        File file = new File("src/test/resources/test.png");
        System.out.println("Файл существует? " + file.exists()); // должно вывести true
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Almaty, Kazakhstan");

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-content").shouldHave(text("Акнур QA"), text("aknur@example.com"));
    }
}
