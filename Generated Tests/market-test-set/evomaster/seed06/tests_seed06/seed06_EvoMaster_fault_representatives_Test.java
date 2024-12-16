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
 * This file was automatically generated by EvoMaster on 2024-05-03T14:12:56.955-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 5 tests
 * <br>
 * Covered targets: 297
 * <br>
 * Used time: 1h 0m 6s
 * <br>
 * Needed budget for current results: 91%
 * <br>
 * This file contains one example of each category of fault. The test cases in this file are a subset of the set of test cases likely to indicate faults.
 */
public class seed06_EvoMaster_fault_representatives_Test {

    
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
        controller.resetDatabase(Arrays.asList("USER_ROLE","PRODUCT","CUSTOMER_ORDER"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "_EM_217_XYZ_")
                .get(baseUrlOfSut + "/customer/contacts?EMextraParam123=_EM_216_XYZ_")
                .then()
                .statusCode(500) // market/dto/assembler/ContactsDtoAssembler_12_toModel
                .assertThat()
                .contentType("application/json")
                .body("'message'", nullValue())
                .body("'description'", containsString("uri=/customer/contacts"))
                .body("'entityName'", nullValue())
                .body("'fieldErrors'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "_EM_498_XYZ_")
                .contentType("application/json")
                .body(" { " + 
                    " \"_links\": [] " + 
                    " } ")
                .put(baseUrlOfSut + "/customer/cart?EMextraParam123=_EM_497_XYZ_")
                .then()
                .statusCode(500) // market/rest/exception/RestErrorResponse_50_getFieldErrors
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("JSON parse error: Expected relation name; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Expected relation name\n at [Source: (ByteArrayInputStream); line: 1, column: 13] (through reference chain: market.dto.CartItemDTO[\"_links\"])"))
                .body("'description'", containsString("uri=/customer/cart"))
                .body("'entityName'", nullValue())
                .body("'fieldErrors'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "_EM_492_XYZ_")
                .contentType("application/json")
                .body(" { " + 
                    " \"_links\": [ " + 
                    " { " + 
                    " \"deprecation\": \"_EM_473_XYZ_\", " + 
                    " \"media\": \"_EM_475_XYZ_\", " + 
                    " \"name\": \"_EM_476_XYZ_\", " + 
                    " \"type\": \"_EM_489_XYZ_\" " + 
                    " } " + 
                    " ], " + 
                    " \"name\": \"-p\", " + 
                    " \"password\": \"5O\", " + 
                    " \"phone\": \"\" " + 
                    " } ")
                .post(baseUrlOfSut + "/register?EMextraParam123=42")
                .then()
                .statusCode(500) // market/rest/exception/RestErrorResponse_50_getFieldErrors
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("JSON parse error: Expected relation name; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Expected relation name\n at [Source: (ByteArrayInputStream); line: 1, column: 13] (through reference chain: market.dto.UserDTO[\"_links\"])"))
                .body("'description'", containsString("uri=/register"))
                .body("'entityName'", nullValue())
                .body("'fieldErrors'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(201, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_3_with500() throws Exception {
        List<InsertionDto> insertions = sql().insertInto("USER_ROLE", 148L)
                .d("USER_ID", "190")
                .d("ROLE_ID", "698")
            .and().insertInto("USER_ROLE", 149L)
                .d("USER_ID", "899")
                .d("ROLE_ID", "832")
            .and().insertInto("PRODUCT", 150L)
                .d("NAME", "\"ScNUnj25\"")
                .d("DISTILLERY_ID", "806")
                .d("AGE", "2000")
                .d("ALCOHOL", "155.89544965440527")
                .d("VOLUME", "588")
                .d("PRICE", "411176.65283316746")
                .d("DESCRIPTION", "\"_EM_710_XYZ_\"")
                .d("AVAILABLE", "false")
            .and().insertInto("PRODUCT", 151L)
                .d("NAME", "\"_EM_711_XYZ_\"")
                .d("DISTILLERY_ID", "958")
                .d("AGE", "833")
                .d("ALCOHOL", "0.5354170113701477")
                .d("VOLUME", "286")
                .d("PRICE", "0.6298999111374656")
                .d("DESCRIPTION", "\"VhVjzfV2cexRulY\"")
                .d("AVAILABLE", "false")
            .and().insertInto("PRODUCT", 152L)
                .d("NAME", "NULL")
                .d("DISTILLERY_ID", "NULL")
                .d("AGE", "NULL")
                .d("ALCOHOL", "0.8940987593138564")
                .d("VOLUME", "-1108682026")
                .d("PRICE", "0.9808338951574803")
                .d("DESCRIPTION", "\"_EM_712_XYZ_\"")
                .d("AVAILABLE", "true")
            .and().insertInto("CUSTOMER_ORDER", 206L)
                .d("ID", "-67108152")
                .d("USER_ACCOUNT_ID", "710")
                .d("DATE_CREATED", "\"2030-10-10\"")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "-33553852")
                .d("DELIVERY_INCLUDED", "false")
                .d("DELIVERY_COST", "797")
            .and().insertInto("CUSTOMER_ORDER", 207L)
                .d("ID", "0")
                .d("USER_ACCOUNT_ID", "NULL")
                .d("DATE_CREATED", "\"2010-12-05\"")
                .d("EXECUTED", "true")
                .d("PRODUCTS_COST", "716")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "-1175")
            .and().insertInto("CUSTOMER_ORDER", 208L)
                .d("ID", "-67108758")
                .d("USER_ACCOUNT_ID", "899")
                .d("DATE_CREATED", "\"2009-12-02\"")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "346")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "615")
            .and().insertInto("CUSTOMER_ORDER", 209L)
                .d("ID", "-3848")
                .d("USER_ACCOUNT_ID", "973")
                .d("DATE_CREATED", "\"1953-06-06\"")
                .d("EXECUTED", "false")
                .d("PRODUCTS_COST", "66243")
                .d("DELIVERY_INCLUDED", "true")
                .d("DELIVERY_COST", "934")
            .dtos();
        InsertionResultsDto insertionsresult = controller.execInsertionsIntoDatabase(insertions);
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer/orders/0?" + 
                    "name=&" + 
                    "EMextraParam123=42")
                .then()
                .statusCode(500) // market/dto/assembler/OrderDtoAssembler_17_toModel
                .assertThat()
                .contentType("application/json")
                .body("'message'", nullValue())
                .body("'description'", containsString("uri=/customer/orders/0"))
                .body("'entityName'", nullValue())
                .body("'fieldErrors'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test @Timeout(60)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic aXZhbi5wZXRyb3ZAeWFuZGV4LnJ1OnBldHJvdg==") // user
                .header("x-EMextraHeader123", "_EM_463_XYZ_")
                .get(baseUrlOfSut + "/customer/orders?EMextraParam123=_EM_462_XYZ_")
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


}