package market;
import  org.junit.jupiter.api.AfterAll;
import  org.junit.jupiter.api.BeforeAll;
import  org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.evomaster.client.java.sql.dsl.SqlDsl.sql;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionResultsDto;
import  org.evomaster.client.java.controller.api.dto.database.operations.InsertionDto;
import static org.hamcrest.Matchers.*;
import  io.restassured.config.JsonConfig;
import  io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import  org.evomaster.client.java.controller.expect.ExpectationHandler;
import  io.restassured.path.json.JsonPath;
import  java.util.Arrays;




/**
 * This file was automatically generated by EvoMaster on 2024-05-03T16:30:50.918-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 13 tests
 * <br>
 * Covered targets: 739
 * <br>
 * Used time: 1h 0m 5s
 * <br>
 * Needed budget for current results: 96%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class seed08_EvoMaster_successes_Test {

    
    private static final SutHandler controller = new em.embedded.market.EmbeddedEvoMasterController();
    private static String baseUrlOfSut;
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    /**
    * rso - response structure oracle - checking that the response objects match the responses defined in the schema
    */
    private static boolean rso = false;
    
    
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
        controller.resetDatabase(Arrays.asList("USER_ROLE","cart_item","CONTACTS","CUSTOMER_ORDER","cart"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    @Test @Timeout(60)
    public void test_0() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .get(baseUrlOfSut + "/v2/api-docs")
                .then()
                .statusCode(200);
        
        expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
    }
    
    
    @Test @Timeout(60)
    public void test_1() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer/contacts")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'phone'", containsString("+7 123 456 78 90"))
                .body("'address'", containsString("Riesstrasse 18"));
        
    }
    
    
    @Test @Timeout(60)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/products?EMextraParam123=_EM_18_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(11))
                .body("[0].'productId'", numberMatches(1.0))
                .body("[0].'distillery'", containsString("Ardbeg"))
                .body("[0].'name'", containsString("Ten"))
                .body("[0].'price'", numberMatches(4420.0))
                .body("[0].'age'", numberMatches(10.0))
                .body("[0].'volume'", numberMatches(700.0))
                .body("[0].'alcohol'", numberMatches(46.0))
                .body("[0].'description'", containsString("Ten Years Old is the basis of the Ardbeg range. After 10 years of maturation in ex-bourbon casks, the whiskey bottled at 46% ABV without cold filtering. The characteristic peat, although clearly present but in perfect balance with the natural sweetness and not predominant in the taste."))
                .body("[0].'available'", equalTo(false))
                .body("[0].'links'.size()", equalTo(1))
                .body("[0].'links'[0].'rel'", containsString("self"))
                .body("[1].'productId'", numberMatches(2.0))
                .body("[1].'distillery'", containsString("Ardbeg"))
                .body("[1].'name'", containsString("Uigeadail"))
                .body("[1].'price'", numberMatches(7020.0))
                .body("[1].'age'", numberMatches(0.0))
                .body("[1].'volume'", numberMatches(700.0))
                .body("[1].'alcohol'", numberMatches(54.2))
                .body("[1].'description'", containsString("Ardbeg Uigedael is named after Loch Uigedael, the lake in the grounds of the distillery Ardbeg which are the water is an important factor in the distilling process. The Uigedael a vatted malt, bottled at 54.2% ABV without cold filtering. Ardbeg Uigedael has no age indication for the expression consists of various malts of different ages. Malts are used partly matured in ex-bourbon and partly on ex-sherry casks."))
                .body("[1].'available'", equalTo(true))
                .body("[1].'links'.size()", equalTo(1))
                .body("[1].'links'[0].'rel'", containsString("self"))
                .body("[2].'productId'", numberMatches(3.0))
                .body("[2].'distillery'", containsString("Balvenie"))
                .body("[2].'name'", containsString("12 y.o. Doublewood"))
                .body("[2].'price'", numberMatches(5403.0))
                .body("[2].'age'", numberMatches(12.0))
                .body("[2].'volume'", numberMatches(700.0))
                .body("[2].'alcohol'", numberMatches(40.0))
                .body("[2].'description'", containsString("Has clear influences from both bourbon and sherry wood. This malt has only 12 years aged in bourbon casks and then 3 months in young Oloroso casks. The peppery character from the bourbon barrels, penetrates, as it were by the rich and full aroma of Oloroso casks it. The Balvenie Double Wood is therefore a very complex malt."))
                .body("[2].'available'", equalTo(true))
                .body("[2].'links'.size()", equalTo(1))
                .body("[2].'links'[0].'rel'", containsString("self"))
                ; // Skipping assertions on the remaining 8 elements. This limit of 3 elements can be increased in the configurations
        
        expectationHandler.expect(ems)
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(0)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(1)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(2)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(3)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(4)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(5)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(6)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(7)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(8)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(9)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")))
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(10)).keySet().containsAll(Arrays.asList("alcohol", "price", "volume")));
    }
    
    
    @Test @Timeout(60)
    public void test_3() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'email'", containsString("ivan.petrov@yandex.ru"))
                .body("'password'", containsString("hidden"))
                .body("'name'", containsString("Ivan Petrov"))
                .body("'phone'", containsString("+7 123 456 78 90"))
                .body("'address'", containsString("Riesstrasse 18"));
        
    }
    
    
    @Test @Timeout(60)
    public void test_4() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "_EM_795_XYZ_")
                .get(baseUrlOfSut + "/products/8")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'productId'", numberMatches(8.0))
                .body("'distillery'", containsString("Springbank"))
                .body("'name'", containsString("12 y.o. Cask Strength Batch 6"))
                .body("'price'", numberMatches(8127.0))
                .body("'age'", numberMatches(12.0))
                .body("'volume'", numberMatches(700.0))
                .body("'alcohol'", numberMatches(53.1))
                .body("'description'", containsString("Like a storm gathering of the Kintyre coast, dark and ominous, yet tastes so good. The richness comes from the high percentage of sherry casks used in maturation. This is a truly classic Springbank, best enjoyed after dinner, or with your favourite cigar."))
                .body("'available'", equalTo(true));
        
    }
    
    
    @Test @Timeout(60)
    public void test_5() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "")
                .delete(baseUrlOfSut + "/customer/cart?EMextraParam123=_EM_270_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("admin"))
                .body("'totalItems'", numberMatches(0.0))
                .body("'productsCost'", numberMatches(0.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(400.0))
                .body("'cartItems'.size()", equalTo(0))
                .body("'empty'", equalTo(true));
        
    }
    
    
    @Test @Timeout(60)
    public void test_6() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("CONTACTS", 424L)
                .d("PHONE", "NULL")
                .d("ADDRESS", "\"\"")
                .d("CITY_REGION", "\"lurEZSMgx\"")
            .and().insertInto("CUSTOMER_ORDER", 10007L)
                .d("ID", "817")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "\"2068-01-11\"")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "564")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "792")
            .and().insertInto("CUSTOMER_ORDER", 10008L)
                .d("ID", "475")
                .d("USER_ACCOUNT_ID", "370")
                .d("DATE_CREATED", "\"1981-06-08\"")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "154")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "736")
            .and().insertInto("CUSTOMER_ORDER", 10009L)
                .d("ID", "405")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "NULL")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "43")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "145")
            .and().insertInto("CUSTOMER_ORDER", 10010L)
                .d("ID", "539")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "NULL")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "-1151786527")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "712")
            .and().insertInto("CUSTOMER_ORDER", 10011L)
                .d("ID", "296")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "\"2062-06-25\"")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "58")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "548")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "")
                .put(baseUrlOfSut + "/customer/cart/delivery?included=false")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("admin"))
                .body("'totalItems'", numberMatches(0.0))
                .body("'productsCost'", numberMatches(0.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(false))
                .body("'totalCost'", numberMatches(400.0))
                .body("'cartItems'.size()", equalTo(0))
                .body("'empty'", equalTo(true));
        
    }
    
    
    @Test @Timeout(60)
    public void test_7() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer/orders?EMextraParam123=_EM_465_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("size()", equalTo(1))
                .body("[0].'userAccount'", containsString("ivan.petrov@yandex.ru"))
                .body("[0].'billNumber'", numberMatches(2.7132054E8))
                .body("[0].'dateCreated'", containsString("2019-12-27T03:00:00.000+00:00"))
                .body("[0].'productsCost'", numberMatches(8127.0))
                .body("[0].'deliveryCost'", numberMatches(400.0))
                .body("[0].'deliveryIncluded'", equalTo(true))
                .body("[0].'totalCost'", numberMatches(8527.0))
                .body("[0].'payed'", equalTo(true))
                .body("[0].'executed'", equalTo(false))
                .body("[0].'links'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(0)).keySet().containsAll(Arrays.asList()));
    }
    
    
    @Test @Timeout(60)
    public void test_8() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/customer/cart?" + 
                    "name=_EM_458_XYZ_&" + 
                    "EMextraParam123=_EM_459_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("ivan.petrov@yandex.ru"))
                .body("'totalItems'", numberMatches(1.0))
                .body("'productsCost'", numberMatches(6517.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(6917.0))
                .body("'cartItems'.size()", equalTo(1))
                .body("'cartItems'[0].'productId'", numberMatches(5.0))
                .body("'cartItems'[0].'quantity'", numberMatches(1.0))
                .body("'empty'", equalTo(false));
        
    }
    
    
    @Test @Timeout(60)
    public void test_9() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("USER_ROLE", 11751L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "0")
            .and().insertInto("USER_ROLE", 11752L)
                .d("USER_ID", "311")
                .d("ROLE_ID", "823")
            .and().insertInto("USER_ROLE", 11753L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "961")
            .and().insertInto("USER_ROLE", 11754L)
                .d("USER_ID", "5947698296120311044")
                .d("ROLE_ID", "-1398636152")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"productId\": 1, " + 
                    " \"quantity\": 417 " + 
                    " } ")
                .put(baseUrlOfSut + "/customer/cart?name=oKpPlqCpVdsr")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("ivan.petrov@yandex.ru"))
                .body("'totalItems'", numberMatches(1.0))
                .body("'productsCost'", numberMatches(6517.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(6917.0))
                .body("'cartItems'.size()", equalTo(1))
                .body("'cartItems'[0].'productId'", numberMatches(5.0))
                .body("'cartItems'[0].'quantity'", numberMatches(1.0))
                .body("'empty'", equalTo(false));
        
    }
    
    
    @Test @Timeout(60)
    public void test_10() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("USER_ROLE", 11751L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "0")
            .and().insertInto("USER_ROLE", 11752L)
                .d("USER_ID", "247")
                .d("ROLE_ID", "824")
            .and().insertInto("USER_ROLE", 11753L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "953")
            .and().insertInto("USER_ROLE", 11754L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "-1398636154")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"productId\": 5, " + 
                    " \"quantity\": 581 " + 
                    " } ")
                .put(baseUrlOfSut + "/customer/cart?" + 
                    "name=oKpPlqCpVds&" + 
                    "included=YiUykdbU_t")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("ivan.petrov@yandex.ru"))
                .body("'totalItems'", numberMatches(1.0))
                .body("'productsCost'", numberMatches(3786377.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(3786777.0))
                .body("'cartItems'.size()", equalTo(1))
                .body("'cartItems'[0].'productId'", numberMatches(5.0))
                .body("'cartItems'[0].'quantity'", numberMatches(581.0))
                .body("'empty'", equalTo(false));
        
    }
    
    
    @Test @Timeout(60)
    public void test_11() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("USER_ROLE", 11751L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "677")
            .and().insertInto("USER_ROLE", 11752L)
                .d("USER_ID", "247")
                .d("ROLE_ID", "824")
            .and().insertInto("USER_ROLE", 11753L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "NULL")
            .and().insertInto("USER_ROLE", 11754L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "-1398636154")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"productId\": 9, " + 
                    " \"quantity\": 599 " + 
                    " } ")
                .put(baseUrlOfSut + "/customer/cart?" + 
                    "name=oKpPlqCpVds&" + 
                    "included=YiLykdIU_t")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("ivan.petrov@yandex.ru"))
                .body("'totalItems'", numberMatches(2.0))
                .body("'productsCost'", numberMatches(8686027.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(8686427.0))
                .body("'cartItems'.size()", equalTo(2))
                .body("'cartItems'[0].'productId'", numberMatches(5.0))
                .body("'cartItems'[0].'quantity'", numberMatches(1.0))
                .body("'cartItems'[1].'productId'", numberMatches(9.0))
                .body("'cartItems'[1].'quantity'", numberMatches(599.0))
                .body("'empty'", equalTo(false));
        
    }
    
    
    @Test @Timeout(60)
    public void test_12() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("USER_ROLE", 11751L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "0")
            .and().insertInto("USER_ROLE", 11752L)
                .d("USER_ID", "247")
                .d("ROLE_ID", "824")
            .and().insertInto("USER_ROLE", 11753L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "953")
            .and().insertInto("USER_ROLE", 11754L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "-1398636154")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"productId\": 4, " + 
                    " \"quantity\": 583 " + 
                    " } ")
                .put(baseUrlOfSut + "/customer/cart?" + 
                    "name=oKpPlqCpVds&" + 
                    "included=YiLykdIU_t")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'user'", containsString("ivan.petrov@yandex.ru"))
                .body("'totalItems'", numberMatches(2.0))
                .body("'productsCost'", numberMatches(2870796.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(2871196.0))
                .body("'cartItems'.size()", equalTo(2))
                .body("'cartItems'[0].'productId'", numberMatches(5.0))
                .body("'cartItems'[0].'quantity'", numberMatches(1.0))
                .body("'cartItems'[1].'productId'", numberMatches(4.0))
                .body("'cartItems'[1].'quantity'", numberMatches(583.0))
                .body("'empty'", equalTo(false));
        
    }


}