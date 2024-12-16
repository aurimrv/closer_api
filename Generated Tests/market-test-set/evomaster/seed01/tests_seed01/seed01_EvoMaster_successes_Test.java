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
 * This file was automatically generated by EvoMaster on 2024-05-02T16:15:21.015-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 10 tests
 * <br>
 * Covered targets: 666
 * <br>
 * Used time: 1h 0m 6s
 * <br>
 * Needed budget for current results: 90%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class seed01_EvoMaster_successes_Test {

    
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
        controller.resetDatabase(Arrays.asList("CONTACTS","CUSTOMER_ORDER","CART","USER_ROLE","CART_ITEM","PRODUCT"));
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
                .get(baseUrlOfSut + "/products")
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
                .header("x-EMextraHeader123", "_EM_461_XYZ_")
                .get(baseUrlOfSut + "/customer?" + 
                    "name=_EM_459_XYZ_&" + 
                    "EMextraParam123=_EM_460_XYZ_")
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
                .header("x-EMextraHeader123", "_EM_711_XYZ_")
                .get(baseUrlOfSut + "/products/5?EMextraParam123=_EM_710_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'productId'", numberMatches(5.0))
                .body("'distillery'", containsString("Dalwhinnie"))
                .body("'name'", containsString("15 y.o."))
                .body("'price'", numberMatches(6517.0))
                .body("'age'", numberMatches(15.0))
                .body("'volume'", numberMatches(750.0))
                .body("'alcohol'", numberMatches(43.0))
                .body("'description'", containsString("A good introduction to the delights of single malt whisky – elegant, smooth and medium-bodied, with a light, fruity palate and a whiff of heather on the finish. Part of Diageo's Classic Malt range. "))
                .body("'available'", equalTo(true));
        
    }
    
    
    @Test @Timeout(60)
    public void test_5() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "_EM_292_XYZ_")
                .delete(baseUrlOfSut + "/customer/cart")
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
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "_EM_456_XYZ_")
                .get(baseUrlOfSut + "/customer/orders?EMextraParam123=_EM_455_XYZ_")
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
    public void test_7() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("CONTACTS", 172L)
                .d("PHONE", "\"_EM_9774_XYZ_\"")
                .d("ADDRESS", "\"JFf9UwDvk9Zw\"")
                .d("CITY_REGION", "\"XG\"")
            .and().insertInto("CONTACTS", 173L)
                .d("PHONE", "\"FPwE35vvMAZ\"")
                .d("ADDRESS", "\"_EM_10839_XYZ_\"")
                .d("CITY_REGION", "\"_EM_10840_XYZ_\"")
            .and().insertInto("CONTACTS", 174L)
                .d("PHONE", "\"_EM_9776_XYZ_\"")
                .d("ADDRESS", "\"cb3_0_\"")
                .d("CITY_REGION", "\"UgdfrRZCxohRbgf\"")
            .and().insertInto("CONTACTS", 175L)
                .d("PHONE", "NULL")
                .d("ADDRESS", "\"_EM_10841_XYZ_\"")
                .d("CITY_REGION", "\"_EM_10842_XYZ_\"")
            .and().insertInto("CONTACTS", 176L)
                .d("PHONE", "\"yy\"")
                .d("ADDRESS", "\"_EM_10843_XYZ_\"")
                .d("CITY_REGION", "\"JfoeQJXPtU9\"")
            .and().insertInto("CUSTOMER_ORDER", 179L)
                .d("ID", "-2096630")
                .d("USER_ACCOUNT_ID", "6605215904726674648")
                .d("DATE_CREATED", "\"2031-01-18\"")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "0")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "0")
            .and().insertInto("CUSTOMER_ORDER", 180L)
                .d("ID", "-16295")
                .d("USER_ACCOUNT_ID", "2097526")
                .d("DATE_CREATED", "\"2054-01-07\"")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "326")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "0")
            .and().insertInto("CUSTOMER_ORDER", 181L)
                .d("ID", "-392698")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "\"2000-10-16\"")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "994")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "8192")
            .and().insertInto("CART", 182L)
                .d("TOTAL_ITEMS", "349")
                .d("PRODUCTS_COST", "1017")
                .d("DELIVERY_INCLUDED", "false")
            .and().insertInto("CART", 183L)
                .d("TOTAL_ITEMS", "262261")
                .d("PRODUCTS_COST", "4194762")
                .d("DELIVERY_INCLUDED", "false")
            .and().insertInto("CART", 184L)
                .d("TOTAL_ITEMS", "NULL")
                .d("PRODUCTS_COST", "0")
                .d("DELIVERY_INCLUDED", "false")
            .and().insertInto("CART", 185L)
                .d("TOTAL_ITEMS", "131072")
                .d("PRODUCTS_COST", "437")
                .d("DELIVERY_INCLUDED", "false")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer/orders/1")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/hal+json")
                .body("'userAccount'", containsString("ivan.petrov@yandex.ru"))
                .body("'billNumber'", numberMatches(2.7132054E8))
                .body("'dateCreated'", containsString("2019-12-27T03:00:00.000+00:00"))
                .body("'productsCost'", numberMatches(8127.0))
                .body("'deliveryCost'", numberMatches(400.0))
                .body("'deliveryIncluded'", equalTo(true))
                .body("'totalCost'", numberMatches(8527.0))
                .body("'payed'", equalTo(true))
                .body("'executed'", equalTo(false));
        
    }
    
    
    @Test @Timeout(60)
    public void test_8() throws Exception {
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer/cart")
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
        List<InsertionDto> insertions = sql().insertInto("USER_ROLE", 225L)
                .d("USER_ID", "425")
                .d("ROLE_ID", "33438")
            .and().insertInto("USER_ROLE", 226L)
                .d("USER_ID", "NULL")
                .d("ROLE_ID", "-33554432")
            .and().insertInto("CUSTOMER_ORDER", 227L)
                .d("ID", "0")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "\"1977-09-09\"")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "497")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "247")
            .and().insertInto("CUSTOMER_ORDER", 228L)
                .d("ID", "1048992")
                .d("USER_ACCOUNT_ID", "746")
                .d("DATE_CREATED", "NULL")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "128")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "0")
            .and().insertInto("CUSTOMER_ORDER", 229L)
                .d("ID", "-67108185")
                .d("USER_ACCOUNT_ID", "815")
                .d("DATE_CREATED", "\"1999-12-08\"")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "0")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "2031924570")
            .and().insertInto("CART_ITEM", 1571L)
                .d("CART_ID", "970")
                .d("PRODUCT_ID", "0")
                .d("QUANTITY", "0")
            .and().insertInto("PRODUCT", 214L)
                .d("NAME", "NULL")
                .d("DISTILLERY_ID", "-130290")
                .d("AGE", "1060")
                .d("ALCOHOL", "0.08309524891070652")
                .d("VOLUME", "-8033")
                .d("PRICE", "0.9180783293588286")
                .d("DESCRIPTION", "NULL")
                .d("AVAILABLE", "true")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        
        given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "42")
                .put(baseUrlOfSut + "/customer/cart/delivery?included=true")
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


}