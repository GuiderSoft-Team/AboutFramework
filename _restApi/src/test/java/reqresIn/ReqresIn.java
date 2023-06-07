package reqresIn;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;

///api/users?page=2
public class ReqresIn {

    @BeforeClass
    public void BeforeClass(){
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }


    @Test
    public void test_get(){
        given().
                when().
                get("/users?page=2").
                then().
                log().body().
                statusCode(200);


        int statusCode = given().
                when().
                get("/users?page=2").
                then().
                extract().statusCode();
        System.out.println(statusCode);
    }

    @Test
    public void test_equalTo(){
        given().when().
        get("/users?page=2").then().body("data.id[0]", equalTo(7));

    }

    @Test
    public void test_hasItems(){
        given().
                get("/users?page=2").
            then().
                body("data.findAll { it.first_name == 'Michael' }.last_name", hasItem("Lawson"));

    }

    @Test
    public void test_asList(){

        String response = given().get("/users?page=2").asString();
        List<String> names = from(response).getList("data.findAll { it.id < 10 }.first_name");
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test_collect(){
        when().
                get("/users?page=2").
        then().
                body("data.first_name.collect { it.length() }.sum()", greaterThan(10));
    }


}
