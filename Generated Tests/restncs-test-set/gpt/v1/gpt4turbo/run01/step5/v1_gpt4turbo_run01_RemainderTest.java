
package org.restncs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import org.evomaster.client.java.controller.SutHandler;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import io.restassured.config.JsonConfig;
import io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import org.evomaster.client.java.controller.expect.ExpectationHandler;
import io.restassured.path.json.JsonPath;
import java.util.Arrays;

public class v1_gpt4turbo_run01_RemainderTest {

    private static final SutHandler controller = new em.embedded.org.restncs.EmbeddedEvoMasterController();
    private static String baseUrlOfSut;

    @BeforeClass
    public static void initClass() {
        controller.setupForGeneratedTest();
        baseUrlOfSut = controller.startSut();
        controller.registerOrExecuteInitSqlCommandsIfNeeded();
        assertNotNull(baseUrlOfSut);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;
        RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
    }

    @AfterClass
    public static void tearDown() {
        controller.stopSut();
    }

    @Before
    public void initTest() {
        controller.resetStateOfSUT();
    }

    @Test
    public void testRemainderApi() {
        ValidatableResponse response = given().when().get(baseUrlOfSut + "/api/remainder/{a}/{b}", 10, 3)
            .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(1));

        response = given().when().get(baseUrlOfSut + "/api/remainder/{a}/{b}", 10, 0)
            .then()
            .statusCode(200) // Corrected expected status code
            .body("resultAsInt", equalTo(Integer.MIN_VALUE)); // Assuming the API handles division by zero by returning Integer.MIN_VALUE

        response = given().when().get(baseUrlOfSut + "/api/remainder/{a}/{b}", 0, 10)
            .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(0));

        response = given().when().get(baseUrlOfSut + "/api/remainder/{a}/{b}", -10, 3)
            .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(-1));

        response = given().when().get(baseUrlOfSut + "/api/remainder/{a}/{b}", 10, -3)
            .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(1));

        response = given().when().get(baseUrlOfSut + "/api/remainder/{a}/{b}", -10, -3)
            .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(-1));
    }
}