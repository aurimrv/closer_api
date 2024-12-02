
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

public class v0_gpt4o_run02_ExpintTest {
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
    public void testExpint200() {
        given()
            .pathParam("n", 1)
            .pathParam("x", 1.0)
        .when()
            .get(baseUrlOfSut + "/api/expint/{n}/{x}")
        .then()
            .statusCode(200)
            .body("resultAsDouble", notNullValue());
    }

    @Test
    public void testExpint404() {
        given()
            .pathParam("n", -1)
            .pathParam("x", -1.0)
        .when()
            .get(baseUrlOfSut + "/api/expint/{n}/{x}")
        .then()
            .statusCode(404);
    }

    @Test
    public void testExpintErrorCondition() {
        given()
            .pathParam("n", 0)
            .pathParam("x", 0.0)
        .when()
            .get(baseUrlOfSut + "/api/expint/{n}/{x}")
        .then()
            .statusCode(500);
    }

    @Test
    public void testExpintContinuedFractionFailure() {
        given()
            .pathParam("n", 10)
            .pathParam("x", 1.0e+30)
        .when()
            .get(baseUrlOfSut + "/api/expint/{n}/{x}")
        .then()
            .statusCode(500);
    }

    @Test
    public void testExpintSeriesFailure() {
        given()
            .pathParam("n", 1)
            .pathParam("x", 1.0e-30)
        .when()
            .get(baseUrlOfSut + "/api/expint/{n}/{x}")
        .then()
            .statusCode(500);
    }

    @Test
    public void testExpintLargeN() {
        given()
            .pathParam("n", 100)
            .pathParam("x", 1.0)
        .when()
            .get(baseUrlOfSut + "/api/expint/{n}/{x}")
        .then()
            .statusCode(200)
            .body("resultAsDouble", notNullValue());
    }
}