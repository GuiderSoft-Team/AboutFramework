package mocjsonserver.db;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test1 extends BaseTestDb {


    @Test
    public void test1(){
        given()
                .when()
                .get("http://localhost:3000/profile")
                .then()
                .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name[0]", equalTo("Guidersoft 1"));
    }



}
