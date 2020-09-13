package com.qa.rest.test;

import com.qa.rest.common.AbstractBaseTest;
import com.qa.rest.model.UserPayload;
import com.qa.rest.model.UsersListResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.qa.rest.constant.Endpoints.*;
import static com.qa.rest.constant.StatusCode._200;
import static com.qa.rest.helper.RestHelper.*;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Feature("Rest Support sock shop services")
@DisplayName("User Service")
@Tag("Regression")
public class UserApiTests extends AbstractBaseTest {

    @Test
    @Description("Verify that user could be registered via Rest")
    @Severity(SeverityLevel.CRITICAL)
    void testCanRegisterUserWithValidCredentials(){
        UserPayload userPayload = modelHelper.getUserWithValidCredentials();

        performAdvancedPostOperation(REGISTER, userPayload).spec(getResponseSpecification(_200)).assertThat()
                .body("id", not(isEmptyString()));
    }

    @Test
    @Description("Verify that user could be deleted via Rest")
    @Severity(SeverityLevel.CRITICAL)
    void testCanDeleteUser(){
        UserPayload userPayload = modelHelper.getUserWithValidCredentials();

        String userId = getValue(performPostOperation(REGISTER, userPayload), "id");

        assertTrue(performAdvancedDeleteOperation(String.format(CUSTOMER, userId))
                .extract().body().asString().contains("true"));
    }

    @Test
    @Description("Verify getting user via Rest")
    @Severity(SeverityLevel.CRITICAL)
    void testGetUsers() throws IOException {
        int numberOfCustomersBefore = asPojo(performGetOperation(CUSTOMERS),
                UsersListResponse.class).getEmbedded().getCustomer().size();

        UserPayload userPayload = modelHelper.getUserWithValidCredentials();

        performAdvancedPostOperation(REGISTER, userPayload).spec(getResponseSpecification(_200)).assertThat()
                .body("id", not(isEmptyString()));

        int numberOfCustomersAfter = asPojo(performGetOperation(CUSTOMERS),
                UsersListResponse.class).getEmbedded().getCustomer().size();

        assertEquals(numberOfCustomersBefore  + 1, numberOfCustomersAfter);
    }

    @AfterAll
    static void deleteUsers() throws IOException {
        UsersListResponse users = asPojo(performGetOperation(CUSTOMERS), UsersListResponse.class);

        for(int i = 0; i < users.getEmbedded().getCustomer().size(); i ++){
            String userId = users.getEmbedded().getCustomer().get(i).getId();
            performAdvancedDeleteOperation(String.format(CUSTOMER, userId));
        }
    }
}
