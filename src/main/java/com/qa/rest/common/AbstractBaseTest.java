package com.qa.rest.common;

import com.qa.rest.constant.StatusCode;
import com.qa.rest.helper.ModelHelper;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class AbstractBaseTest {
    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }
    private static RequestSpecification requestSpec;
    protected static ModelHelper modelHelper;

    @BeforeAll
    @Step("Configuration pre-condition for test running")
    public static void setupBeforeClass() {

        requestSpec = configureRequestSpecification();
        modelHelper = new ModelHelper();
    }

    @Step("Create Request Specification ")
    private static RequestSpecification configureRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(RestConfig.BASE_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Step("Create Response Specification")
    public static ResponseSpecification getResponseSpecification(StatusCode statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode.getCode())
                .expectStatusLine(String.format("HTTP/1.1 %s %s", statusCode.getCode(), statusCode.getDescription()))
                .build();
    }
}
