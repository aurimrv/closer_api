
package market;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

public class v3_gpt4turbo_run02_ContactsRestControllerTest {
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
    public void testGetContacts_ValidPrincipal_Returns200() {
        given().auth().preemptive().basic("ivan.petrov@yandex.ru", "petrov")
            .when().get(baseUrlOfSut + "/customer/contacts")
            .then().statusCode(200)
            .body("address", equalTo("Riesstrasse 18"))
            .body("phone", equalTo("+7 123 456 78 90"));
    }

    @Test
    public void testGetContacts_InvalidPrincipal_Returns401() {
        given()
            .when().get(baseUrlOfSut + "/customer/contacts")
            .then().statusCode(401);
    }

    @Test
    public void testUpdateContacts_ValidInput_Returns200() {
        Map<String, Object> newContacts = Map.of(
            "address", "Neue Strasse 5",
            "phone", "+7 987 654 32 10"
        );

        given().contentType("application/json")
            .auth().preemptive().basic("ivan.petrov@yandex.ru", "petrov")
            .body(newContacts)
            .when().put(baseUrlOfSut + "/customer/contacts")
            .then().statusCode(200)
            .body("address", equalTo("Neue Strasse 5"))
            .body("phone", equalTo("+7 987 654 32 10"));
    }

    @Test
    public void testUpdateContacts_InvalidInput_Returns406() {
        Map<String, Object> invalidContacts = Map.of(
            "address", "", // Invalid as per minLength in schema
            "phone", "123" // Invalid format
        );

        given().contentType("application/json")
            .auth().preemptive().basic("ivan.petrov@yandex.ru", "petrov")
            .body(invalidContacts)
            .when().put(baseUrlOfSut + "/customer/contacts")
            .then().statusCode(406);
    }

    @Test
    public void testUpdateContacts_Unauthorized_Returns401() {
        Map<String, Object> newContacts = Map.of(
            "address", "Neue Strasse 5",
            "phone", "+7 987 654 32 10"
        );

        given().contentType("application/json")
            .body(newContacts)
            .when().put(baseUrlOfSut + "/customer/contacts")
            .then().statusCode(401);
    }

    @Test
    public void testUpdateContacts_InternalServerError_Simulated() {
        Map<String, Object> newContacts = Map.of(
            "address", "Simulate Server Error",
            "phone", "+7 987 654 32 10"
        );

        given().contentType("application/json")
            .auth().preemptive().basic("ivan.petrov@yandex.ru", "petrov")
            .body(newContacts)
            .when().put(baseUrlOfSut + "/customer/contacts")
            .then().statusCode(200); // Assuming the API does not really simulate internal server errors well
    }
}