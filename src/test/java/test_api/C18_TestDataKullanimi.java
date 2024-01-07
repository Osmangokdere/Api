package test_api;

import BaseUrl.jsonPlaceHolderBaseUrl;
import TestData.TestDataJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_TestDataKullanimi extends jsonPlaceHolderBaseUrl {
      /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"*/

    @Test
    public void get01(){
        //1- Url hazirla
    specJsonPlace.pathParams("pp1","posts","pp2",22);

    //2-Expected Data Hazirla
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject expDAta=testDataJsonPlaceHolder.expectedBodyOlustur();

        //3-Response Kaydet

        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        //4-Assertion

        JsonPath resJpath=response.jsonPath();
        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,
                response.getStatusCode());

    }
}
