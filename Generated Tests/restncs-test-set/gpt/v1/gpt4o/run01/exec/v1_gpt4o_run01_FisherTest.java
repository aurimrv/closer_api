
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

public class v1_gpt4o_run01_FisherTest {
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
    public void testFisherEndpoint() {
        // Valid request
        given().pathParam("m", 10).pathParam("n", 5).pathParam("x", 1.5)
            .when().get(baseUrlOfSut + "/api/fisher/{m}/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", notNullValue());

        // Boundary and invalid test cases
        given().pathParam("m", -1).pathParam("n", 5).pathParam("x", 1.5)
            .when().get(baseUrlOfSut + "/api/fisher/{m}/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));

        given().pathParam("m", 10).pathParam("n", -1).pathParam("x", 1.5)
            .when().get(baseUrlOfSut + "/api/fisher/{m}/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));

        given().pathParam("m", 10).pathParam("n", 5).pathParam("x", -1.5)
            .when().get(baseUrlOfSut + "/api/fisher/{m}/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));

        given().pathParam("m", 10).pathParam("n", 5).pathParam("x", 0)
            .when().get(baseUrlOfSut + "/api/fisher/{m}/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));
    }

    @Test
    public void testBessjEndpoint() {
        // Valid request
        given().pathParam("n", 3).pathParam("x", 2.5)
            .when().get(baseUrlOfSut + "/api/bessj/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", notNullValue());

        // Boundary and invalid test cases
        given().pathParam("n", -1).pathParam("x", 2.5)
            .when().get(baseUrlOfSut + "/api/bessj/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));

        given().pathParam("n", 3).pathParam("x", -2.5)
            .when().get(baseUrlOfSut + "/api/bessj/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(-0.21660039114156904));
    }

    @Test
    public void testExpintEndpoint() {
        // Valid request
        given().pathParam("n", 3).pathParam("x", 2.5)
            .when().get(baseUrlOfSut + "/api/expint/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", notNullValue());

        // Boundary and invalid test cases
        given().pathParam("n", -1).pathParam("x", 2.5)
            .when().get(baseUrlOfSut + "/api/expint/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));

        given().pathParam("n", 3).pathParam("x", -2.5)
            .when().get(baseUrlOfSut + "/api/expint/{n}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));
    }

    @Test
    public void testGammqEndpoint() {
        // Valid request
        given().pathParam("a", 2.5).pathParam("x", 1.5)
            .when().get(baseUrlOfSut + "/api/gammq/{a}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", notNullValue());

        // Boundary and invalid test cases
        given().pathParam("a", -2.5).pathParam("x", 1.5)
            .when().get(baseUrlOfSut + "/api/gammq/{a}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));

        given().pathParam("a", 2.5).pathParam("x", -1.5)
            .when().get(baseUrlOfSut + "/api/gammq/{a}/{x}")
            .then().statusCode(200)
            .body("resultAsDouble", is(0.0));
    }

    @Test
    public void testRemainderEndpoint() {
        // Valid request
        given().pathParam("a", 10).pathParam("b", 3)
            .when().get(baseUrlOfSut + "/api/remainder/{a}/{b}")
            .then().statusCode(200)
            .body("resultAsInt", notNullValue());

        // Boundary and invalid test cases
        given().pathParam("a", -10).pathParam("b", 3)
            .when().get(baseUrlOfSut + "/api/remainder/{a}/{b}")
            .then().statusCode(200)
            .body("resultAsInt", is(-1));

        given().pathParam("a", 10).pathParam("b", -3)
            .when().get(baseUrlOfSut + "/api/remainder/{a}/{b}")
            .then().statusCode(200)
            .body("resultAsInt", is(0));

        given().pathParam("a", 10).pathParam("b", 0)
            .when().get(baseUrlOfSut + "/api/remainder/{a}/{b}")
            .then().statusCode(200)
            .body("resultAsInt", is(0));
    }

    @Test
    public void testTriangleEndpoint() {
        // Valid request
        given().pathParam("a", 3).pathParam("b", 4).pathParam("c", 5)
            .when().get(baseUrlOfSut + "/api/triangle/{a}/{b}/{c}")
            .then().statusCode(200)
            .body("resultAsString", notNullValue());

        // Boundary and invalid test cases
        given().pathParam("a", 0).pathParam("b", 4).pathParam("c", 5)
            .when().get(baseUrlOfSut + "/api/triangle/{a}/{b}/{c}")
            .then().statusCode(200)
            .body("resultAsString", nullValue());

        given().pathParam("a", 3).pathParam("b", 0).pathParam("c", 5)
            .when().get(baseUrlOfSut + "/api/triangle/{a}/{b}/{c}")
            .then().statusCode(200)
            .body("resultAsString", nullValue());

        given().pathParam("a", 3).pathParam("b", 4).pathParam("c", 0)
            .when().get(baseUrlOfSut + "/api/triangle/{a}/{b}/{c}")
            .then().statusCode(200)
            .body("resultAsString", nullValue());
    }
}