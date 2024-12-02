
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
    void testAccessDeniedException() {
        given().baseUri(baseUrlOfSut)
               .when().get("/customer")
               .then().assertThat()
               .statusCode(401);
    }

    @Test
    void testUnknownEntityException() {
        given().baseUri(baseUrlOfSut)
               .pathParam("productId", 9999)
               .when().get("/products/{productId}")
               .then().assertThat()
               .statusCode(404);
    }

    @Test
    void testCustomNotValidExceptionOnPost() {
        String jsonBody = "{\"email\":\"invalid\",\"password\":\"short\",\"name\":\"\",\"phone\":\"invalid\",\"address\":\"invalid$#\"}";
        given().baseUri(baseUrlOfSut)
               .contentType("application/json")
               .body(jsonBody)
               .when().post("/register")
               .then().assertThat()
               .statusCode(406)
               .body("message", containsString("Error.Validation.Parameter"));
    }

    @Test
    void testMethodArgumentNotValidExceptionOnPost() {
        String jsonBody = "{\"email\":\"ivan.petrov@yandex.ru\",\"password\":\"petrov\",\"name\":\"Ivan Petrov\",\"phone\":\"+7 123 456 78 90\",\"address\":\"Riesstrasse 18\"}";
        given().baseUri(baseUrlOfSut)
               .contentType("application/json")
               .body(jsonBody)
               .when().post("/register")
               .then().assertThat()
               .statusCode(201)
               .body("name", equalTo("Ivan Petrov"))
               .body("address", equalTo("Riesstrasse 18"))
               .body("email", equalTo("ivan.petrov@yandex.ru"));
    }

    @Test
    void testInternalServerError() {
        // Simulate server error via a specific endpoint or condition
        given().baseUri(baseUrlOfSut)
               .when().get("/simulate-server-error") // Assuming there is such an endpoint for testing
               .then().assertThat()
               .statusCode(500);
    }

    @Test
    void testValidResponseAgainstSchema() {
        given().baseUri(baseUrlOfSut)
               .when().get("/products")
               .then().assertThat()
               .statusCode(200)
               .body(matchesJsonSchemaInClasspath("schema/ProductDTO.json")); // Assuming JSON schema is stored in classpath
    }
}