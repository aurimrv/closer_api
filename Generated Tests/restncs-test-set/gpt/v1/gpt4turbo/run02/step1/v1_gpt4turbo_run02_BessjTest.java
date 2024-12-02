
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

public class v1_gpt4turbo_run02_BessjTest {

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
    public void testBessjValidInputs() {
        int n = 5;
        double x = 3.0;
        ValidatableResponse response = given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/bessj/{n}/{x}")
            .pathParam("n", n)
            .pathParam("x", x)
            .when()
            .get()
            .then()
            .statusCode(200)
            .body("resultAsDouble", notNullValue());

        Double result = response.extract().jsonPath().getDouble("resultAsDouble");
        assertNotNull(result);
    }

    @Test
    public void testBessjInvalidN() {
        int n = 1;
        double x = 3.0;
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/bessj/{n}/{x}")
            .pathParam("n", n)
            .pathParam("x", x)
            .when()
            .get()
            .then()
            .statusCode(404); // Assuming the service returns 404 for invalid `n`
    }

    @Test
    public void testBessjZeroX() {
        int n = 5;
        double x = 0.0;
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/bessj/{n}/{x}")
            .pathParam("n", n)
            .pathParam("x", x)
            .when()
            .get()
            .then()
            .statusCode(200)
            .body("resultAsDouble", equalTo(0.0));
    }
}