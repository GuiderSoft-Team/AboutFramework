package mocjsonserver.store;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.JsonPath.from;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.Matchers.*;

public class Test1 extends BaseTestStore {


    @Test
    public void test11() {
        //  the titles of the books with a price less than 10 are "Sayings of the Century" and "Moby Dick"
        when()
                .get("/store")
                .then()
                .body("store.book.findAll { it.price < 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));
    }


    @Test
    public void test12() {
        // Get the response body as a String
        String response = get("/store").asString();

        // And get all books with price < 10 from the response. "from" is statically imported from the JsonPath class
        List<String> bookTitles = from(response).getList("book.findAll { it.price < 10 }.title");
        System.out.println(bookTitles);
    }

    @Test
    public void test13() {
        when()
                .get("/store")
                .then()
                .body("author.collect { it.length() }.sum()", greaterThan(50));

    }

    @Test
    public void test14() {
        when()
                .get("/store")
                .then()
                .body("book.author*.length().sum()", greaterThan(50));
    }

    @Test
    public void test15() {
        // Get the response body as a string
        String response = get("/store").asString();
        // Get the sum of all author length's as an int. "from" is again statically imported from the JsonPath class
        int sumOfAllAuthorLengths = from(response).getInt("store.book.author*.length().sum()");
        // We can also assert that the sum is equal to 53 as expected.
        Assert.assertEquals(sumOfAllAuthorLengths, is(53));
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
