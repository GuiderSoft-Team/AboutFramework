package mocjsonserver.lotto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mocjsonserver.db.BaseTestDb;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.math.BigDecimal;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.Matchers.*;

public class Test1 extends BaseTestLotto {


    @Test
    public void test11() {
        given()
                .get("/lotto")
                .then()
                .log().body()
                .body("lottoId", equalTo(5));
    }


    @Test
    public void test12() {
        given()
                .get("/lotto")
                .then()
                .log().body()
                .body("winners.winnerId", hasItems(23, 54));
    }

    @Test(description = "Returning floats and doubles as BigDecimal")
    public void test13() {
        given()
                .get("/price")
                .then()
                .body("price", is(12.12f));
    }

    @Test(description = "configure REST Assured to use a JsonConfig that returns all Json numbers as BigDecimal")
    public void test14() {
        given().
                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
                when().
                get("/price").
                then().
                body("price", is(new BigDecimal(12.12)));
    }

    @Test(description = "expect")
    public void test15() {
        given().
                param("x", "y").
                expect().
                body("lottoId", equalTo(5)).
                when().
                get("/lotto");
    }

    @Test
    public void test16() {
        given().
                param("x", "y").
                expect().
                statusCode(400).
                body("lottoId", equalTo(6)).
                when().
                get("/lotto");
    }

    @Test
    public void test17() {
        given().
                param("x", "y").
                when().
                get("/lotto").
                then().
                statusCode(400).
                body("lotto.lottoId", equalTo(6));
    }

    @Test
    public void test18() {
        InputStream stream = get("/lotto").asInputStream(); // Don't forget to close this one when you're done
        byte[] byteArray = get("/lotto").asByteArray();
        String json = get("/lotto").asString();
        System.out.println(json);
    }

    @Test
    public void test19() {
    }

    @Test
    public void test20() {
    }

    @Test
    public void test21() {
    }

    @Test
    public void test22() {
    }

    @Test
    public void test23() {
    }

    @Test
    public void test24() {
    }

    @Test
    public void test25() {
    }

    @Test
    public void test26() {
    }

    @Test
    public void test27() {
    }


}
