package com.qa.rest.helper;

import com.github.javafaker.Faker;
import com.qa.rest.model.UserPayload;
import org.apache.commons.lang3.RandomStringUtils;

public class ModelHelper {
    public static Faker faker = new Faker();


    public UserPayload getUserWithValidCredentials() {
        return new UserPayload(RandomStringUtils.randomAlphanumeric(6),
                faker.name() + "@email.com", faker.name().username());
    }
}
