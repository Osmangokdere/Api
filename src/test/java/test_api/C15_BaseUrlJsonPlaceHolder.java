package test_api;

import BaseUrl.jsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C15_BaseUrlJsonPlaceHolder extends jsonPlaceHolderBaseUrl {
    //  //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    //
    //    //3- https://jsonplaceholder.typicode.com/posts endpointine
    //    //   bir DELETE request gonderdigimizde donen response’un
    //    //   status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin

    @Test
    public void get01(){
        //1- Url hazirla
        specJsonPlace.pathParam("pp1", "posts");

        //2 expected data hazirla


        //3 response kaydet

        Response response=given().spec(specJsonPlace).when().get("/{pp1}");

        //4 Assertion

        response.then().assertThat().statusCode(200).body("title", hasSize(100));



    }
    @Test
    public void get02(){

    }
}
