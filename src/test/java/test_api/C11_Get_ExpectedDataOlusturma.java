package test_api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
     /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :

        {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void test01(){
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2-Expected data hazirla

        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        System.out.println(expBody);

        //3-Response kaydet

        Response response=given().when().get(url);

        // 4- Assertion

            /* Bugune kadar yaptigimiz yontemle de testimizi yapabiliriz
               Ancak framework'umuzu gelistirmeye devam etmeliyiz
             response
                    .then()
                    .assertThat()
                    .body("userId", equalTo(3),
                            "id",equalTo(22),
                            "title",equalTo("dolor sint quo a velit explicabo quia nam"));

             */
        JsonPath resJsonpath=response.jsonPath();
        Assert.assertEquals(expBody.get("userId"), resJsonpath.getInt("userId"));
        Assert.assertEquals(expBody.get("id"), resJsonpath.getInt("id"));
        Assert.assertEquals(expBody.get("title"), resJsonpath.getString("title"));
        Assert.assertEquals(expBody.get("body"), resJsonpath.getString("body"));



    }
}
