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
        @Test
        public void get02(){
          /*

        "https://restful-booker.herokuapp.com"/booking endpointine
        gerekli Query parametrelerini yazarak
            “firstname” degeri “Susan” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un
            status code’unun 200 oldugunu
            ve “Susan” ismine sahip 2 booking oldugunu test edin

         */
        specHerokuapp.pathParam("pp1", "booking").queryParam("firstname", "Susan");

        Response response=given().spec(specHerokuapp).get("/{pp1}");
        response.prettyPrint();

        //4- Assertions

            response.then().assertThat().statusCode(200).
                    body("bookingid",Matchers.hasSize(2));
        }
}
