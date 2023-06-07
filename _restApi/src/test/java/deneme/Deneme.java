package deneme;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deneme {

    Cookies cookies;

    @Test
    public void Auth(){
        RestAssured.baseURI = "https://test.campus.techno.study";

        Map<String, String> cred = new HashMap<String, String>(){{
            put("username", "daulet2030@gmail.com");
            put("password", "TechnoStudy123@");
            put("rememberMe", "true");

        }};


        cookies = given()
                .contentType(ContentType.JSON)
                .body(cred)
                .when()
                .post("/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response().getDetailedCookies();

    }

    @Test
    public void getCountries(){
        given()
                .cookies(cookies)
                .when()
                .log().body()
                .get("/school-service/api/countries")
                .then()
                .log().body()
                .statusCode(200);
    }

}
