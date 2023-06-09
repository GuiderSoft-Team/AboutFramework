package gorest1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ZippoTest {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://api.zippopotam.us";
    }


    @Test
    public void test() {
        given().when().then();
    }

    @Test
    public void testingStatusCode() {
        given()
                .when()
                .get("/us/90210")
                .then()
                .statusCode(200)
        ;
    }

    @Test
    public void loggingRequest() {
        given()
                .log().all()
                .when()
                .get("/us/90210")
                .then()
        ;
    }

    @Test
    public void loggingResponse() {
        given()
                .when()
                .get("/us/90210")
                .then()
                .log().all()
        ;
    }

    @Test
    public void loggingRequestAndResponse() {
        given()
                .log().all()
                .when()
                .get("/us/90210")
                .then()
                .log().all()
        ;
    }

    @Test
    public void testingContentType() {
        given()
                .when()
                .get("/us/90210")
                .then()
//        .contentType("application/json")
            .contentType(ContentType.JSON)
        ;
    }

    @Test
    public void checkCountryTest() {
        given()
                .when()
                .get("/us/90210")
                .then()
                .body("country", equalTo("United States"))
                .body("'country abbreviation'", equalTo("US"))
                .log().body()
        ;
    }

    @Test
    public void checkPlacesTest() {
        given()
                .when()
                .get("/us/90210")
                .then()
                .log().body()
                .body("places", hasSize(1))
                .body("places[0].state", equalTo("California"))
                .body("places[0].'place name'", equalTo("Beverly Hills"))
        ;
    }

    @Test
    public void checkArtursTest() {
        given()
                .when()
                .get("/us/11214")
                .then()
                .log().body()
                .body("places[0].'place name'", equalTo("Brooklyn"))
        ;
    }

    @Test
    public void checkTurkeyTest() {
        given()
                .when()
                .get("/tr/34840")
                .then()
                .log().body()
                .body("places", hasSize(2))
                .body("places.state", hasSize(2)) // {"İstanbul", "İstanbul"}
                .body("places.'place name'", hasItem("Altintepe Mah.")) // {"Küçükyalimerkez Mah.", "Altintepe Mah."}
        ;
    }

    @Test
    public void pathParameterTest() {
        String country = "us";
        String zipCode = "11214";
        given()
                .pathParam("country", country)
                .pathParam("zipCode", zipCode)
                .when()
                .get("/{country}/{zipCode}")
                .then()
                .log().body()
                .body("places[0].'place name'", equalTo("Brooklyn"))
        ;
    }

    @Test
    public void queryParameterTest() {
        String name = "Gurdev";
        String gender = "Female";
        given()
                .log().uri()
                .param("name", name)
                .param("gender", gender)
                .when()
                .get("https://gorest.co.in/public-api/users")
                .then()
        .log().body()
        ;
    }

    @Test
    public void extractingValueTest() {
        Object country = given()
                .when()
                .get("/us/11214")
                .then()
                .extract().path("country");
        System.out.println(country);
    }

    @Test
    public void extractingValueTest2() {
        Object secondPlaceName = given()
                .when()
                .get("/tr/34840")
                .then()
                .log().body()
                .body("places", hasSize(2))
                .body("places.state", hasSize(2)) // {"İstanbul", "İstanbul"}
                .body("places.'place name'", hasItem("Altintepe Mah.")) // {"Küçükyalimerkez Mah.", "Altintepe Mah."}
                .extract().path("places[1].'place name'");
        ;

        System.out.println(secondPlaceName);
    }
}
