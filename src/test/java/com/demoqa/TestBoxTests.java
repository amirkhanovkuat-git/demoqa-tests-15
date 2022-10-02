package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x800";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        Configuration.holdBrowserOpen = true;

        $("#firstName").setValue("Kuat");
        $("#lastName").setValue("Amirkhanov");
        $("#userEmail").setValue("amirkhanovkuat@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("7051174428");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText("1999")).click();
        $(".react-datepicker__month-select").click();
        $(byText("December")).click();
        $(byText("8")).click();
        $("#subjectsInput").setValue("Mat");
        $(byText("Maths")).click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpeg"));
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
    }
}
