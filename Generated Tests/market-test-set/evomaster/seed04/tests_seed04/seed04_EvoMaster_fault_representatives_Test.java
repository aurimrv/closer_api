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
 * This file was automatically generated by EvoMaster on 2024-05-02T19:35:15.238-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 5 tests
 * <br>
 * Covered targets: 331
 * <br>
 * Used time: 1h 0m 7s
 * <br>
 * Needed budget for current results: 83%
 * <br>
 * This file contains one example of each category of fault. The test cases in this file are a subset of the set of test cases likely to indicate faults.
 */
public class seed04_EvoMaster_fault_representatives_Test {

    
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
        controller.resetDatabase(Arrays.asList("CUSTOMER_ORDER","CART","CONTACTS","USER_ROLE","PRODUCT","ORDERED_PRODUCT","BILL"));
        controller.resetStateOfSUT();
    }
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_1
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .contentType("application/json")
                .body(" { " + 
                    " \"_links\": [], " + 
                    " \"password\": \"Tz\", " + 
                    " \"phone\": \"\" " + 
                    " } ")
                .post(baseUrlOfSut + "/register?EMextraParam123=_EM_25_XYZ_")
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
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "_EM_156_XYZ_")
                .get(baseUrlOfSut + "/customer/contacts?EMextraParam123=_EM_155_XYZ_")
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
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "_EM_161_XYZ_")
                .get(baseUrlOfSut + "/customer")
                .then()
                .statusCode(500) // market/dto/assembler/UserAccountDtoAssembler_16_toModel
                .assertThat()
                .contentType("application/json")
                .body("'message'", nullValue())
                .body("'description'", containsString("uri=/customer"))
                .body("'entityName'", nullValue())
                .body("'fieldErrors'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    /**
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    * LastLine_0
    */
    @Test @Timeout(60)
    public void test_3_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=") // admin
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/customer/orders?name=_EM_695_XYZ_")
                .then()
                .statusCode(500) // market/dto/assembler/OrderDtoAssembler_18_toModel
                .assertThat()
                .contentType("application/json")
                .body("'message'", nullValue())
                .body("'description'", containsString("uri=/customer/orders"))
                .body("'entityName'", nullValue())
                .body("'fieldErrors'.size()", equalTo(0));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test @Timeout(60)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_19_XYZ_")
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


}