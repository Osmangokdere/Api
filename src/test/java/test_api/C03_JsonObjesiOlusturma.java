package test_api;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
    @Test
    public void jsonObje01(){
        JSONObject ilkJsonObje=new JSONObject();
        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("UserId",1);

        System.out.println(ilkJsonObje);
    }

    @Test
    public void Json02(){

        JSONObject innerJsonObje=new JSONObject();
        innerJsonObje.put("checkin", "2018-11-20");
        innerJsonObje.put("checkout", "2018-11-26");

        JSONObject body=new JSONObject();
        body.put("firstname","Jim");
        body.put("additionalneeds","Breakfast");
        body.put("bookingdate",innerJsonObje);
        body.put("totalprice",111);
        body.put("depositpaid","true");
        body.put("lastname ","Brown");

        System.out.println(body);



    }


}
