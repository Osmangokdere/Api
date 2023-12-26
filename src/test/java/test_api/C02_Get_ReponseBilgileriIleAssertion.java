package test_api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ReponseBilgileriIleAssertion {

    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Eger soruda bize verilmis ise expected data yi hazirla

        //3-Bize donen response Actual Data olarak kaydet
        Response response=given().when().get(url);
        response.prettyPrint();

        //Aseertions

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").statusLine("HTTP/1.1 200 OK");

    }
}
