package test_api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_apiSorgulama {
    @Test
    public void get01(){
        //1-gönderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Body hazirla

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Eger soruda bize verilmis ise expected data yi hazirla

        //3-Bize donen response Actual Data olarak kaydet
        Response response=given().when().get(url);
        response.prettyPrint();
        //4-Expected ile Actual in karsılastirilmasi kisacasi Assertion yapacagiz

        System.out.println("Status Code :"+ response.getStatusCode());
        System.out.println("Content Type :"+ response.getContentType());
        System.out.println("Server Header Degeri :"+ response.getHeader("Server"));
        System.out.println("Content Line :"+ response.getStatusLine());



    }
}
