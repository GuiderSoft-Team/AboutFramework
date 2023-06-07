package mocjsonserver.title;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.math.BigDecimal;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.Matchers.*;

public class Test1 extends BaseTestTitle {


    @Test
    public void test11() {
        String nextTitleLink =
                given().
                        param("param_name", "param_value").
                        when().
                        get("/title").
                        then().
                        contentType(JSON).
                        body("title", equalTo("My Title")).
                        extract().
                        path("_links.next.href");

        get(nextTitleLink);
    }


    @Test
    public void test12() {
        Response response =
                given().
                        param("param_name", "param_value").
                        when().
                        get("/title").
                        then().
                        contentType(JSON).
                        body("title", equalTo("My Title")).
                        extract().
                        response();

        String nextTitleLink = response.path("_links.next.href");
        String headerValue = response.header("headerName");
    }

    @Test
    public void test13() {
;
    }

    @Test
    public void test14() {

    }

    @Test(description = "expect")
    public void test15() {

    }

    @Test
    public void test16() {

    }

    @Test
    public void test17() {

    }

    @Test
    public void test18() {

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
