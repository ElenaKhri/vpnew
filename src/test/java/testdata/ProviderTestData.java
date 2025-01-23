package testdata;

import com.github.javafaker.Faker;

public class ProviderTestData {
    static Faker faker = new Faker();
    public String email = faker.internet().emailAddress(),
    phone = faker.phoneNumber().subscriberNumber(10);
}
