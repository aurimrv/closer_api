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
 * This file was automatically generated by EvoMaster on 2024-06-01T13:17:08.073749-03:00[America/Araguaina]
 * <br>
 * The generated test suite contains 45 tests
 * <br>
 * Covered targets: 603
 * <br>
 * Used time: 1h 0m 0s
 * <br>
 * Needed budget for current results: 79%
 * <br>
 * This file contains test cases that represent successful calls.
 */
public class seed03_EvoMaster_successes_Test {

    
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
                .get(baseUrlOfSut + "/api/triangle/-65108/410/604")
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
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/392/-213/140?EMextraParam123=_EM_74_XYZ_")
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
                .get(baseUrlOfSut + "/api/triangle/860/445066796/-2110053347?EMextraParam123=42")
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
                .get(baseUrlOfSut + "/api/triangle/78/78/78")
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
                .get(baseUrlOfSut + "/api/triangle/392/43/138?EMextraParam123=_EM_74_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_6() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/0/0.15130435019780164")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(5.681172038594323));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_7() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/29/946/911?EMextraParam123=_EM_1_XYZ_")
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
                .header("x-EMextraHeader123", "_EM_703_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/0/-25?EMextraParam123=_EM_702_XYZ_")
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
                .header("x-EMextraHeader123", "_EM_33_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/522/300/827?EMextraParam123=_EM_32_XYZ_")
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
                .header("x-EMextraHeader123", "_EM_703_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/214/0")
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
                .header("x-EMextraHeader123", "_EM_135_XYZ_")
                .get(baseUrlOfSut + "/api/expint/821/0.0")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0012195121951219512));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_12() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_57_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/368/0.0?EMextraParam123=_EM_56_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_13() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/708/941/854?EMextraParam123=_EM_100_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(1.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_14() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/628/628/535?EMextraParam123=_EM_2359_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(2.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_15() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/triangle/428/410/596?EMextraParam123=_EM_28_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(1.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_16() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_2568_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/707/847/847?EMextraParam123=_EM_2567_XYZ_")
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
                .header("x-EMextraHeader123", "_EM_909_XYZ_")
                .get(baseUrlOfSut + "/api/triangle/518/673/518")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(2.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_18() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/remainder/536/254?EMextraParam123=_EM_9_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(28.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_19() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_703_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/214/-25")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(14.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_20() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_703_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/-300/-15")
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
                .header("x-EMextraHeader123", "_EM_703_XYZ_")
                .get(baseUrlOfSut + "/api/remainder/-4905/45?EMextraParam123=_EM_702_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", numberMatches(0.0))
                .body("'resultAsDouble'", nullValue());
        
    }
    
    
    @Test(timeout = 60000)
    public void test_22() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_0_XYZ_")
                .get(baseUrlOfSut + "/api/fisher/-524217/768/0.22733466107144407?EMextraParam123=42")
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
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/fisher/384/446/0.247547277723435")
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
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/fisher/174/-15/0.4560091910175642?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(1.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_25() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/333/1.0")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.001104733068188091));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_26() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/fisher/103/768/0.22733466107144407")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_27() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "42")
                .get(baseUrlOfSut + "/api/expint/1/0.9111936014534419")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.25518644698289283));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_28() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/expint/515429308/0.10546084924566446")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(1.745942056308318E-9));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_29() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/gammq/0.091673391330515/0.0")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(1.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_30() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_135_XYZ_")
                .get(baseUrlOfSut + "/api/expint/789/39.42834527937699")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(9.093514892674476E-21));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_31() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_20_XYZ_")
                .get(baseUrlOfSut + "/api/fisher/304/139/0.23170000293606952?EMextraParam123=_EM_19_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(2.961633677253189E-16));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_32() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/fisher/71/768/0.22733466107144407?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(2.544361158481408E-12));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_33() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/fisher/721/789/0.7598091845568161")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(8.699234894931813E-5));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_34() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_1158_XYZ_")
                .get(baseUrlOfSut + "/api/expint/9/0.4274503513159593")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.07687036181408914));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_35() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/gammq/1.1235582092889472E308/23580.042349938874?EMextraParam123=_EM_117_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", containsString("NaN"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_36() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/gammq/0.1692379076854107/0.4874576197510474?EMextraParam123=_EM_7_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.1041479965392903));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_37() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/978/0.15843782637336135?EMextraParam123=_EM_3_XYZ_")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.0));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_38() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_736_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/15/15.0?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.18130634149351063));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_39() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/35/1.306450366973877E-16")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", containsString("NaN"));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_40() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/gammq/0.9757075401141851/2.1613880469580478")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.11048558352640529));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_41() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_736_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/5/5.961053504283402")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.3598196885202898));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_42() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/368/1.7887267715864253E8")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(-4.1127666965864104E-5));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_43() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "")
                .get(baseUrlOfSut + "/api/bessj/5/8.0?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(0.1857747723321807));
        
    }
    
    
    @Test(timeout = 60000)
    public void test_44() throws Exception {
        
        given().accept("application/json")
                .header("x-EMextraHeader123", "_EM_108_XYZ_")
                .get(baseUrlOfSut + "/api/bessj/302/-419.2110760824795?EMextraParam123=42")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'resultAsInt'", nullValue())
                .body("'resultAsDouble'", numberMatches(-0.0175043058055738));
        
    }


}