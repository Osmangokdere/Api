package test_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTesti{
    @Test
    public void get01(){
           /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
        	status code'unun 200,
        	ve content type'inin Aplication.JSON,
        	ve response body'sinde bulunan userId'nin 5,
        	ve response body'sinde bulunan title'in "optio dolor molestias sit"
        	oldugunu test edin.

         */

        //1- URL hazirla
        String url="https://jsonplaceholder.typicode.com/posts/44";

    // 2 - soruda istenşyorsa Expected Data Hazirla

    // 3- Reponse i kaydet

        Response response=given().when().get(url);
        response.prettyPrint();

        //4- Assertions

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", Matchers.equalTo(5)).
                body("title", Matchers.equalTo("optio dolor molestias sit"));
}}