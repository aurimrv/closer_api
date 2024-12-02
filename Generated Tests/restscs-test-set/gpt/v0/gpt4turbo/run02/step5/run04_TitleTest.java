
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

public class run04_TitleTest {
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
    public void testTitleMaleValid() {
        given().pathParam("sex", "male")
               .pathParam("title", "mr")
               .when().get(baseUrlOfSut + "/api/title/{sex}/{title}")
               .then().statusCode(200)
               .body(equalTo("1"));
    }

    @Test
    public void testTitleFemaleValid() {
        given().pathParam("sex", "female")
               .pathParam("title", "mrs")
               .when().get(baseUrlOfSut + "/api/title/{sex}/{title}")
               .then().statusCode(200)
               .body(equalTo("0"));
    }

    @Test
    public void testTitleNoneValid() {
        given().pathParam("sex", "none")
               .pathParam("title", "dr")
               .when().get(baseUrlOfSut + "/api/title/{sex}/{title}")
               .then().statusCode(200)
               .body(equalTo("2"));
    }

    @Test
    public void testTitleInvalidSex() {
        given().pathParam("sex", "unknown")
               .pathParam("title", "mr")
               .when().get(baseUrlOfSut + "/api/title/{sex}/{title}")
               .then().statusCode(200)
               .body(equalTo("-1"));
    }

    @Test
    public void testTitleInvalidTitle() {
        given().pathParam("sex", "male")
               .pathParam("title", "king")
               .when().get(baseUrlOfSut + "/api/title/{sex}/{title}")
               .then().statusCode(200)
               .body(equalTo("-1"));
    }
}