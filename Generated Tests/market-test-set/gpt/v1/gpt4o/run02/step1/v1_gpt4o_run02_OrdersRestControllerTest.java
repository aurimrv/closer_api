
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
import static org.evomaster.client.java.sql.dsl.SqlDsl.sql;
import org.evomaster.client.java.controller.api.dto.database.operations.InsertionResultsDto;
import org.evomaster.client.java.controller.api.dto.database.operations.InsertionDto;
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

public class v1_gpt4o_run02_OrdersRestControllerTest {

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
    public void testGetOrdersUnauthorized() {
        given()
            .baseUri(baseUrlOfSut)
            .when()
            .get("/customer/orders")
            .then()
            .statusCode(401);
    }

    @Test
    public void testGetOrdersForbidden() {
        String token = loginAsUser("unauthorizedUser@example.com", "password");

        given()
            .baseUri(baseUrlOfSut)
            .auth().oauth2(token)
            .when()
            .get("/customer/orders")
            .then()
            .statusCode(403);
    }

    @Test
    public void testGetOrdersSuccess() {
        String token = loginAsUser("ivan.petrov@yandex.ru", "petrov");

        given()
            .baseUri(baseUrlOfSut)
            .auth().oauth2(token)
            .when()
            .get("/customer/orders")
            .then()
            .statusCode(200)
            .body("$.size()", greaterThan(0));
    }

    @Test
    public void testGetOrderSuccess() {
        String token = loginAsUser("ivan.petrov@yandex.ru", "petrov");
        long orderId = 1; // Assume an order with this ID exists

        given()
            .baseUri(baseUrlOfSut)
            .auth().oauth2(token)
            .when()
            .get("/customer/orders/" + orderId)
            .then()
            .statusCode(200)
            .body("id", equalTo(orderId));
    }

    @Test
    public void testGetOrderNotFound() {
        String token = loginAsUser("ivan.petrov@yandex.ru", "petrov");
        long orderId = 9999; // Assume no order with this ID exists

        given()
            .baseUri(baseUrlOfSut)
            .auth().oauth2(token)
            .when()
            .get("/customer/orders/" + orderId)
            .then()
            .statusCode(404);
    }

    private String loginAsUser(String email, String password) {
        return given()
            .baseUri(baseUrlOfSut)
            .contentType("application/json")
            .body(Map.of("email", email, "password", password))
            .when()
            .post("/login")
            .then()
            .statusCode(200)
            .extract()
            .path("token");
    }
}