package test_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C08_Post_ResponseBodyTesti {

           /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"},
            "additionalneeds" : "wi-fi"
            }

         donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ahmet",
                ve "lastname“in, "Bulut",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2023-01-10
                ve "checkout" tarihinin 2023-01-20
                ve "additionalneeds“in,"wi-fi"
             oldugunu test edin

         */
           @Test
           public void post01(){
        // 1- endpoint ve request body olustur

        String url="https://restful-booker.herokuapp.com/booking ";

        // 2 - end posint ve body hazirla

        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin", "2023-01-10");
        innerBody.put("checkout" , "2023-01-20 ");

        JSONObject reqbody =new JSONObject();
        reqbody.put( "firstname","Ahmet");
        reqbody.put( "lastname","Bulut");
        reqbody.put( "totalprice",500);
        reqbody.put( "depositpaid",true);
        reqbody.put( "bookingdates",innerBody);
        reqbody.put( "additionalneeds","wi-fi");

        //2- expected datayi hazirla
        //3- Response kaydet

        Response response=given().contentType(ContentType.JSON).
                when().body(reqbody.toString()).post(url);
        response.prettyPrint();

        //4-Assertion
               response.then().assertThat().
                       statusCode(200).contentType(ContentType.JSON).
                       body("booking.firstname", Matchers.equalTo("Ahmet"),
                               "booking.lastname", equalTo("Bulut"),
                               "booking.totalprice", equalTo(500),
                               "booking.depositpaid", equalTo(true),
                               "booking.bookingdates.checkin", equalTo("2023-01-10"),
                               "booking.bookingdates.checkout", equalTo("2023-01-20"),
                               "booking.additionalneeds", equalTo("wi-fi"));


    }

}
