package org.restncs;

import  org.junit.AfterClass;
import  org.junit.BeforeClass;
import  org.junit.Before;
import  org.junit.Test;
import static org.junit.Assert.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
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
 * This file was automatically generated by EvoMaster on 2024-06-01T15:17:14.764918-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 17 tests
 * <br>
 * Covered targets: 178
 * <br>
 * Used time: 1h 0m 0s
 * <br>
 * Needed budget for current results: 60%
 * <br>
 * This file contains test cases that represent failed calls, but not indicative of faults.
 */
public class seed05_EvoMaster_others_Test {

    
    private static final SutHandler controller = new em.embedded.org.restncs.EmbeddedEvoMasterController();
    private static String baseUrlOfSut;
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    
    
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
    
    
    
    
    @Test(timeout = 60000)
    public void test_0() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_1_XYZ_")
                .get(baseUrlOfSut + "/api/fisher/67108952/-67108402/0.4485983912283127?EMextraParam123=_EM_0_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/-524124/2.2925331326346443?EMextraParam123=_EM_115_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/1005599588/884")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/fisher/88/1049038/-889.2859355199223")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/67109328/0.5111134963764231?EMextraParam123=_EM_79_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/-1955184096/329?EMextraParam123=_EM_215_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_561_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/990/132071")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_327_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/557/-1809663575")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/-2097005/-4.382628184201697?EMextraParam123=_EM_242_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/317/-3.420915696354223E8?EMextraParam123=_EM_32_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_446_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/-0.5833733809764086/-7712291.648857872")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_11() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_9_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/-665567.5803126729/0.04016?EMextraParam123=_EM_8_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/gammq/0.0/1.6049872500465898")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/0/0.0")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/1/0.0")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_179_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/8.988465674311579E307/8.955548929898816E307")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("*/*")
                .header("x-EMextraHeader123", "_EM_1785_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/8.988465674311579E307/8.988465674311579E307?EMextraParam123=_EM_1784_XYZ_")
                .then()
                .statusCode(400)
                .assertThat()
                .body(isEmptyOrNullString());
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 401, 403, 404).contains(res_0.extract().statusCode()));
    }


}