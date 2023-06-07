package deneme;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BealdungCom {
    String url = "https://gorest.co.in";

    @Test
    public void getUsers(){
        given().get(url + "/public-api/users")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenCorrect() {
        given()
                .auth().oauth2("935e64ef3f48d1b4d2967f9cf4890885fd3a7cd7c3105d1aa541572da7c32903");

        get("/public-api/users")
                .then().assertThat()
                .log().body();
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
        get(url + "/public-api/users/2").then().statusCode(200).assertThat()
                .body("data.id", equalTo("2"))
                .body("data.gender", equalTo("Female"));
    }

}
