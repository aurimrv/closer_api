
package org.restscs;

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

public class v2_gpt4turbo_run03_RegexTest {

    private static final SutHandler controller = new em.embedded.org.restscs.EmbeddedEvoMasterController();
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
    public void testSubjectWithValidDate() {
        String response = given().baseUri(baseUrlOfSut)
                .basePath("/api/dateparse/mon/dec")
                .when().get()
                .then().statusCode(200)
                .extract().asString();
        assertEquals("13", response);
    }

    @Test
    public void testSubjectWithValidUrl() {
        given().baseUri(baseUrlOfSut)
                .basePath("/api/pat/http:%2F%2Fexample.com%2Fhome")
                .when().get()
                .then().statusCode(200)
                .body(is("url"));
    }

    @Test
    public void testSubjectWithInvalidInput() {
        given().baseUri(baseUrlOfSut)
                .basePath("/api/pat/invalidinput")
                .when().get()
                .then().statusCode(200);
    }

    @Test
    public void testSubjectWithValidFloatingPointExponential() {
        String response = given().baseUri(baseUrlOfSut)
                .basePath("/api/pat/1.23e-10")
                .when().get()
                .then().statusCode(200)
                .body(is("fpe"))
                .extract().asString();
        assertEquals("fpe", response);
    }

    @Test
    public void testSubjectWithMissingParameters() {
        given().baseUri(baseUrlOfSut)
                .basePath("/api/dateparse")
                .when().get()
                .then().statusCode(404);
    }
}