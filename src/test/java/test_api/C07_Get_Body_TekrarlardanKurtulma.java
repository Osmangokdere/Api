package test_api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C07_Get_Body_TekrarlardanKurtulma {
      /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
 	        status code’unun 200,
	        ve content type’inin application-json,
	        ve response body’sindeki
            "firstname“in,"Susan",
            ve "lastname“in, "Jackson",
            ve "totalprice“in,1000'den kucuk oldugu,
            ve "depositpaid“in,false,
            ve "additionalneeds“in,bos biralkilmadigini
            oldugunu test edin
         */
    @Test
    public void get(){

        // 1- endpoint ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected data olustur
        // 3- request gonderip, donen response'i kaydet

        Response response=given().when().get(url);

        //4-Assertion
        /*
        * status code’unun 200,
	        ve content type’inin application-json,
	        ve response body’sindeki
            "firstname“in,"Susan",
            ve "lastname“in, "Jackson",
            ve "totalprice“in,1000'den kucuk oldugu,
            ve "depositpaid“in,false,
            ve "additionalneeds“in,bos biralkilmadigini*/

        //esponse
        //       .then()
        //       .assertThat()
        //       .statusCode(200)
        //       .contentType(ContentType.JSON)
        //       .body("firstname", Matchers.equalTo("Susan"))
        //       .body("lastname",Matchers.equalTo("Jackson"))
        //       .body("totalprice",Matchers.lessThan(1000))
        //       .body("depositpaid",Matchers.equalTo(false))
        //       .body("additionalneeds",Matchers.notNullValue());

        ///////////////////KISA YOLU ///////////////

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Susan"),
                        "lastname",equalTo("Jackson"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds",notNullValue());


        }
}


