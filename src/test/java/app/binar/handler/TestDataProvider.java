package app.binar.handler;

import com.github.javafaker.Faker;


public class TestDataProvider {

    private static final Faker faker = new Faker();

    public static String getRandomUserName() {
        return faker.name().firstName();
    }

    public static String getRandomPasswordNumber() {
        return getRandomStringMatchingPattern("[A-Z]\\d{8}");
    }

    public static String getRandomStringMatchingPattern(String pattern) {
        return faker.regexify(pattern);
    }

    public static String getRandomEmail() {
        return getRandomStringMatchingPattern("[a-z]{5}\\d{3}") + ".binar@academy.com";
    }
}
