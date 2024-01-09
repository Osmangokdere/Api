package test_api;

import BaseUrl.jsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJOJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C27_Put_Pojo extends jsonPlaceHolderBaseUrl {


    @Test
    public void put(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        POJOJsonPlaceHolder reqBody= new POJOJsonPlaceHolder("Ahmet","Merhaba",70,10);
        System.out.println(reqBody);
        //2- Expected data hazirla

        POJOJsonPlaceHolder expData= new POJOJsonPlaceHolder("Ahmet","Merhaba",70,10);

        //3- Response

        Response response =given().spec(specJsonPlace).
                contentType(ContentType.JSON).
                when().
                body(reqBody).put("/{pp1}/{pp2}");
            response.prettyPrint();
            //4- Assert

        POJOJsonPlaceHolder resPojo=response.as(POJOJsonPlaceHolder.class);
        Assert.assertEquals(expData.getBody(), resPojo.getBody());
        Assert.assertEquals(expData.getId(), resPojo.getId());
        Assert.assertEquals(expData.getUserId(), resPojo.getUserId());
        Assert.assertEquals(expData.getTitle(), resPojo.getTitle());
    }
}
