package test_api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_C15_Get_SoftAssertIleExpectedDataTesti {

    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
            Response Body
            {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."

     */

        // 1- end point ve request body olustur

        String url=" http://dummy.restapiexample.com/api/v1/employee/3";


        //2- expected body i hazirla

        JSONObject innerbody=new JSONObject();
        innerbody.put("id",3);
        innerbody.put("employee_name","Ashton Cox");
        innerbody.put("employee_salary",86000);
        innerbody.put("employee_age",66);
        innerbody.put("profile_image","");

        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",innerbody);
        expBody.put("message","Successfully! Record has been fetched.");

        //3- response,,

        Response response=given().when().get(url);

        //4-Assertion
        JsonPath jpath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(jpath.get("status"),expBody.get("status"));
        softAssert.assertEquals(jpath.get("message"),expBody.get("message"));
        softAssert.assertEquals(jpath.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(jpath.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(jpath.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(jpath.get("data.profile_image"),expBody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();

    }}
