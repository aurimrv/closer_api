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
 * This file was automatically generated by EvoMaster on 2024-06-01T17:17:21.280883-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 44 tests
 * <br>
 * Covered targets: 605
 * <br>
 * Used time: 1h 0m 0s
 * <br>
 * Needed budget for current results: 85%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class seed07_EvoMaster_successes_Test {

    
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
    
    
    @Test(timeout = 60000)
    public void test_1() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/-77/-268434807/448?EMextraParam123=_EM_18_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_2() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_19_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/947/-523639/448?EMextraParam123=_EM_18_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_3() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/268436403/649/-134217280?EMextraParam123=_EM_18_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_4() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/425/425/425")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(3.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_5() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_75_XYZ_")
                .get(baseUrlOfSut + "/api/expint/0/0.1188000532489839")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(7.474620663124318));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_79_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/929/594/120?EMextraParam123=_EM_78_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_52_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/465/976/354?EMextraParam123=_EM_51_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_8() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/0/619")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(-1.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_9() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/380/431/989?EMextraParam123=_EM_22_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_10() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_597_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/-4044/0?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(-1.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_11() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/473/0.0")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.00211864406779661));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/425/425/816?EMextraParam123=_EM_950_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(2.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_83_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/156/0.0")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_2_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/850/929/785?EMextraParam123=_EM_1_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(1.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_6185_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/551/771/771?EMextraParam123=_EM_6184_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(2.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/triangle/305/40/305")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(2.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_17() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/956/549?EMextraParam123=_EM_14_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(407.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_18() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/2101/-1965?EMextraParam123=_EM_472_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(136.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_19() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_473_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/-8387/-1")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_20() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/-5280/528?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_21() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/fisher/-3859/386/-1243399.479675?EMextraParam123=_EM_0_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(1.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_22() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/fisher/-4193555/898/0.7081771577767972?EMextraParam123=_EM_0_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(1.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_23() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_47_XYZ_")
                .get(baseUrlOfSut + "/api/fisher/654/247/0.250867002")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_24() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_780_XYZ_")
                .get(baseUrlOfSut + "/api/expint/90/1.0?EMextraParam123=_EM_779_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.004087039209317321));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_25() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/1/0.47")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.5978774289160967));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_26() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/1073741848/0.1188000532489839")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(8.270007686141439E-10));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_27() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_403_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/0.6045336117956848/0.0?EMextraParam123=_EM_402_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(1.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_28() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/9999996/1.5")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(2.2313023824400538E-8));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_29() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/795/1.0886734994097524?EMextraParam123=_EM_44_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(4.234272373825536E-4));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_30() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/fisher/160/859/0.13463736234231127")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(5.551215781360935E-14));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_31() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_151_XYZ_")
                .get(baseUrlOfSut + "/api/fisher/781/415/0.40881525913758987")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_32() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/fisher/749/898/0.7081771577767972")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(5.046414048043008E-7));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_33() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_1296_XYZ_")
                .get(baseUrlOfSut + "/api/expint/5/0.9264334904285423")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.07709251111809151));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_34() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_431_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/8.988465674311579E307/1481967.7637792705")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", containsString("NaN"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_35() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_8_XYZ_")
                .get(baseUrlOfSut + "/api/gammq/0.4412176352620166/0.5225927322338576")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.26921158365729536));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_36() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_4_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/254/0.3826339337849941?EMextraParam123=_EM_3_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_37() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/3/1.6547508238936357E-16?EMextraParam123=_EM_9533_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(9.43966496771017E-50));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_38() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/bessj/7/-7.0")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(-0.23358356951104586));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_39() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/gammq/236584.11457584388/764958.3997709159?EMextraParam123=_EM_430_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_40() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/7/-7.9997305952553175")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(-0.3205736959312313));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_41() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_65_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/250/958431.9959782476")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(-7.3750981684287E-4));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_42() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/50/-35316.11360779469")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.003190345762632619));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_43() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/6/-8.0?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.33757590000907034));
        
    }


}