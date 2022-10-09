package com.demoqa.tests;


import com.github.javafaker.Faker;

import java.util.Locale;

import static com.demoqa.utils.GenerateMonth.randomMonth;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String day = String.valueOf(faker.number().numberBetween(10, 28));
    String month = String.valueOf(randomMonth());
    String year = String.valueOf(faker.number().numberBetween(1900, 2022));
    String subject = "Math";
    String subjectCheck = "Maths";
    String hobbies =  "Music";
    String picture = "test.jpeg";
    String address = faker.address().fullAddress();
    String stateCity = "Haryana Panipat";
}
