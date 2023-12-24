package test_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C06_Post_ResponseBodyTesti {
    @Test
    public void post01(){
    /*
                    https://jsonplaceholder.typicode.com/posts  url’ine
                    asagidaki body ile bir POST request gonderdigimizde
                        {
                        "title":"API",
                        "body":"API ogrenmek ne guzel",
                        "userId":10
                        }
                     donen Response’un,
                        status code’unun 201,
                        ve content type’inin application/json
                        ve Response Body'sindeki,"title"'in "API" oldugunu
                        "userId" degerinin 100'den kucuk oldugunu,
                        "body" nin "API" kelimesi icerdigini
                        test edin.*/
        // 1-URL ve Body hazirla

        String Url="https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody= new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body","API ogrenmek ne guzel");
        requestBody.put("userId",10);

        System.out.println(requestBody);

        // 2- Expected data hazirla

        //3- Response kaydet

        Response response=given().contentType(ContentType.JSON).
                when().body(requestBody.toString()).
                post(Url);

        // 4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", equalTo("API"),"userId",
                        lessThan(100),
                        "body",containsString("API"));

    }

}
