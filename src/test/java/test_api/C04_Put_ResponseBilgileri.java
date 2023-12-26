package test_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileri {
        /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine
        asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK

         */


    @Test
    public void put01() {


        // 1- end point ve request body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        //body i hazirla;

              /*  {
            "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
        }*/
        JSONObject reqbody = new JSONObject();
        reqbody.put("title", "Ahmet");
        reqbody.put("body", "Merhaba");
        reqbody.put("userId", 10);
        reqbody.put("id", 70);

        //2-Soruda istendiyse Excepted Data hazirla

        // 3- Response i kaydet

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqbody.toString()).put(url);
        //4- Assertion
        /*
        donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve Server isimli Header’in degerinin cloudflare,
                ve status Line’in HTTP/1.1 200 OK

                */

        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server", "cloudflare").
                statusLine("HTTP/1.1 200 OK");


        System.out.println("-----------------------------------------------------------------");
    }

        @Test
                public void get01(){

                   // https://restful-booker.herokuapp.com/booking/10 url’ine
            // bir GET request gonderdigimizde donen Response’u yazdirin.

            // 1- Request body ve end-point hazirlama

            String url="https://restful-booker.herokuapp.com/booking/10";

            // 2- Expected data hazirlama

            // 3- Request gonderip, donen response'i kaydetme

            Response response = given().when().get(url);
            // 4- Assertion



    }

}
