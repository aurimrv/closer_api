
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

public class v1_gpt4turbo_run01_TriangleClassificationTest {

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
    public void testTriangleClassification_Equilateral() {
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/triangle/{a}/{b}/{c}")
            .pathParam("a", 10)
            .pathParam("b", 10)
            .pathParam("c", 10)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(3));
    }

    @Test
    public void testTriangleClassification_Isosceles() {
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/triangle/{a}/{b}/{c}")
            .pathParam("a", 10)
            .pathParam("b", 10)
            .pathParam("c", 5)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(2));
    }

    @Test
    public void testTriangleClassification_Scalene() {
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/triangle/{a}/{b}/{c}")
            .pathParam("a", 10)
            .pathParam("b", 8)
            .pathParam("c", 5)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(1));
    }

    @Test
    public void testTriangleClassification_NotATriangle() {
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/triangle/{a}/{b}/{c}")
            .pathParam("a", 10)
            .pathParam("b", 5)
            .pathParam("c", 3)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(0));
    }

    @Test
    public void testTriangleClassification_InvalidInput() {
        given()
            .baseUri(baseUrlOfSut)
            .basePath("/api/triangle/{a}/{b}/{c}")
            .pathParam("a", -1)
            .pathParam("b", 10)
            .pathParam("c", 10)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("resultAsInt", equalTo(0));
    }
}