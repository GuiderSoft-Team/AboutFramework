package proje1;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.Location;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ZippoTr2 {

    private ResponseSpecification responseSpecification;
    private RequestSpecification requestSpecification;

    @BeforeClass
    public void setup()
    {
        baseURI = "http://api.zippopotam.us";  // static REST Assured un kendi değişkeni

        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.URI)
                .setAccept(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();

    }

    @Test
    public void extractingJsonPathList()
    {
        List<PlaceTr> liste=
                given()
                        .when()
                        .get("/tr/01000")
                        .then()
                        //.log().body()
                        .contentType(ContentType.JSON)
                        .extract()
                        .response()
                        .jsonPath()
                        .getList("places", PlaceTr.class)
                ;
        System.out.println(liste);

    }


    @Test
    public void extractingJsonAsPojo()
    {
        Location location=
        given()
                .when()
                .get("/us/90210")
                .then()
                .log().body()
                .extract().as(Location.class)
                ;

        System.out.println(location);
        System.out.println(location.getCountry());
        System.out.println(location.getPlaces());
        System.out.println(location.getPlaces().get(0).getState());
    }



}








