package reqresIn;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ErgastCom {

    // First test: Understanding the syntax
    @Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }


    //Validating technical response data
    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {

        given().
            when().
                get("http://ergast.com/api/f1/2017/circuits.json").
            then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("Content-Length", equalTo("4567"));
    }



    // Parameterizing tests
    @Test
    public void test_Parameterized_Query() {

        String originalText = "test";
        String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";

        given().
                param("text", originalText).
            when().
                get("http://md5.jsontest.com").
            then().
                log().body().
                assertThat();
                //body("md5", equalTo(expectedMd5CheckSum));
    }


    @Test
    public void test_Parameterized_Path() {

        String season = "2017";
        int numberOfRaces = 20;

        given().
                pathParam("raceSeason", season).
            when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
            then().
                log().body().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId", hasSize(numberOfRaces));
    }


    @DataProvider(name="seasonsAndNumberOfRaces")
    public Object[][] createTestDataRecords() {
        return new Object[][] {
                {"2017",20},
                {"2016",21},
                {"1966",9}
        };
    }

    @Test(dataProvider="seasonsAndNumberOfRaces")
    public void test_Parameterized_DataProvider(String season, int numberOfRaces) {

        given().
                pathParam("raceSeason",season).
            when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
            then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
    }

    //Accessing secured APIs
    @Test
    public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {

        given().
                auth().
                preemptive().
                basic("username", "password").
            when().
                get("http://path.to/basic/secured/api").
            then().
                assertThat().
                statusCode(200);
    }

    // Passing parameters between tests
    @Test
    public void test_ScenarioRetrieveFirstCircuitFor2017SeasonAndGetCountry_ShouldBeAustralia() {

        // First, retrieve the circuit ID for the first circuit of the 2017 season
        String circuitId = given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
            then().
                extract().
                path("MRData.CircuitTable.Circuits.circuitId[0]");

        // Then, retrieve the information known for that circuit and verify it is located in Australia
        given().
                pathParam("circuitId",circuitId).
            when().
                get("http://ergast.com/api/f1/circuits/{circuitId}.json").
            then().
                assertThat();
                //body("MRData.CircuitTable.Circuits.Location[0].country", equalTo("Australia"));
    }

    // Reusing checks with ResponseSpecBuilder


    @Test
    public void test_NumberOfCircuits_ShouldBe20_UsingResponseSpec() {
        ResponseSpecification checkStatusCodeAndContentType =
                new ResponseSpecBuilder().
                        expectStatusCode(200).
                        expectContentType(ContentType.JSON).
                        build();

        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
            then().
                assertThat().
                spec(checkStatusCodeAndContentType).
                and().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }
}
