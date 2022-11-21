package app.binar.handler;

import com.github.javafaker.Faker;

/**
 * @author regiewby on 20/11/22
 * @project web-automation-learning
 */
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
}
