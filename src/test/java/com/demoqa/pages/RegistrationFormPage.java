package com.demoqa.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        zoom(0.8);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        Configuration.holdBrowserOpen = true;
        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String gender){
        $(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value){
        $("#subjectsInput").setValue(value);
        $(byText("Maths")).click();

        return this;
    }

    public RegistrationFormPage chooseHobbies(){
        $(byText("Music")).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(){
        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpeg"));

        return this;
    }

    public RegistrationFormPage setAddress(String value){
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage chooseStateCity(){
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();

        return this;
    }

    public RegistrationFormPage submitForm(){
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible(){
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value){
        resultsModal.checkResult(key, value);

        return this;
    }

}
