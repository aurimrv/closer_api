
package market;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
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

public class run01_RestExceptionHandlerTest {

    private static final SutHandler controller = new em.embedded.market.EmbeddedEvoMasterController();
    private static String baseUrlOfSut;

    @BeforeAll
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

    @AfterAll
    public static void tearDown() {
        controller.stopSut();
    }

    @BeforeEach
    public void initTest() {
        controller.resetDatabase(Arrays.asList("USER_ROLE","CUSTOMER_ORDER","CART_ITEM","PRODUCT","CART","CONTACTS"));
        controller.resetStateOfSUT();
    }

    @Test
    public void testAccessDeniedException() {
        given().baseUri(baseUrlOfSut)
            .when()
            .get("/restricted")
            .then()
            .statusCode(401)
            .body("message", equalTo("Access Denied"));
    }

    @Test
    public void testUnknownEntityException() {
        given().baseUri(baseUrlOfSut)
            .when()
            .get("/customer/nonexistent")
            .then()
            .statusCode(404)
            .body("message", containsString("Entity Not Found"));
    }

    @Test
    public void testCustomNotValidException() {
        given().baseUri(baseUrlOfSut)
            .contentType("application/json")
            .body("{\"email\": \"invalidEmail\"}")
            .when()
            .post("/customer")
            .then()
            .statusCode(406)
            .body("message", containsString("Validation failed"));
    }

    @Test
    public void testMethodArgumentNotValidException() {
        given().baseUri(baseUrlOfSut)
            .contentType("application/json")
            .body("{\"name\": \"\"}")
            .when()
            .post("/customer")
            .then()
            .statusCode(406)
            .body("message", containsString("Argument not valid"));
    }

    @Test
    public void testOtherExceptions() {
        given().baseUri(baseUrlOfSut)
            .when()
            .get("/causeInternalError")
            .then()
            .statusCode(500)
            .body("message", equalTo("Internal Server Error"));
    }
}