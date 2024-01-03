package test_api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {


    @Test
    public void post01(){
        /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2023-01-20"
            },
        "additionalneeds" : "wi-fi"
        }

        Expected Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2023-01-20"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */

        // 1- Endpoint ve request body olustur

        String url= "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin","2023-01-10");
        innerBody.put("checkout","2023-01-20");

        JSONObject reqbody =new JSONObject();
        reqbody.put( "firstname","Ahmet");
        reqbody.put( "lastname","Bulut");
        reqbody.put( "totalprice",500);
        reqbody.put( "depositpaid",true);
        reqbody.put( "bookingdates",innerBody);
        reqbody.put( "additionalneeds","wi-fi");

        // 2- expected data olustur

        JSONObject expectedData= new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",reqbody);

        // 3- request gonderip, donen response'i kaydet

        Response response= given().contentType(ContentType.JSON)
                .when().body(reqbody.toString())
                .post(url);

        // 4- Assertion

        JsonPath responseJsonPath= response.jsonPath();
        // ilk yazilan expected ====> olusturdugumuz JSonObject : expectedData
        // ikinci yazilan actual ===> response : responseJsonPath
       Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),
               responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responseJsonPath.get("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));

    }

}