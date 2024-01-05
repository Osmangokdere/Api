package test_api;

import BaseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {

    @Test
    public void get01(){

        // 1- Url hazirla
        specHerokuapp.pathParam("pp1", "booking");

        //2-Expected data hazirla
        //3- Response kaydet
        Response response=given().spec(specHerokuapp).when().get("/{pp1}");


        //4- Assertion
        response.then().assertThat().statusCode(200).
             body("bookingid", Matchers.hasItem(126));

    }
}
