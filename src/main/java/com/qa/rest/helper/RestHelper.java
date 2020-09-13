package com.qa.rest.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rest.model.Model;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.qa.rest.common.AbstractBaseTest.getRequestSpec;

public class RestHelper {

    @Step("Perform Advanced GET operation")
    public static Response performAdvancedGetOperation(String endPoint, Map<String, ?> params) {
        return RestAssured.given()
                .spec(getRequestSpec()).params(params)
                .get(endPoint);
    }

    @Step("Perform Advanced GET operation")
    public static Response performGetOperation(String endPoint) {
        return RestAssured.given()
                .spec(getRequestSpec())
                .get(endPoint);
    }

    @Step("Perform Advanced POST operation")
    public static ValidatableResponse performAdvancedPostOperation(String endPoint, Model model) {
        return RestAssured.given()
                .spec(getRequestSpec())
                .body(model)
                .post(endPoint)
                .then().log().all();
    }

    @Step("Perform POST operation")
    public static Response performPostOperation(String endPoint, Model model) {
        return RestAssured.given()
                .spec(getRequestSpec())
                .body(model)
                .post(endPoint);
    }

    @Step("Perform Advanced Delete operation")
    public static ValidatableResponse performAdvancedDeleteOperation(String endPoint) {
        return RestAssured.given()
                .spec(getRequestSpec())
                .delete(endPoint)
                .then().log().all();
    }

    @Step("Extract value from json")
    public static String getValue(Response response, String jsonPath){
        return response.jsonPath().getObject(jsonPath, String.class);
    }

    @Step("Deserialize response into Java objects")
    public static <T> T asPojo(Response response, Class<T> tClass) throws IOException {
        InputStream inputStream = response.getBody().asInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, tClass);
    }
}
