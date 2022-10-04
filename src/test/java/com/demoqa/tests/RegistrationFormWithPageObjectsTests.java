package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x800";

    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Kuat")
                .setLastName("Amirkhanov")
                .setEmail("amirkhanovkuat@gmail.com")
                .setGender("Male")
                .setNumber("7054992748")
                .setBirthDate("08", "December", "1999")
                .setSubjects("Mat")
                .chooseHobbies()
                .uploadPicture()
                .setAddress("Some address")
                .chooseStateCity()
                .submitForm();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Kuat Amirkhanov")
                .checkResult("Student Email", "amirkhanovkuat@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7054992748")
                .checkResult("Date of Birth", "08 December,1999")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "test.jpeg")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "Haryana Panipat");

    }
}
