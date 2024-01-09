package TestData;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceHolder {
   public int basariliStatusCode=200;
    public JSONObject expectedBodyOlustur(){
        JSONObject expBodyJson=new JSONObject();
        expBodyJson.put("userId",3);
        expBodyJson.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJson.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBodyJson;
    }
      /*  "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
}
     */

public static Map<String,Object> bodyOlusturMap(){
        Map<String,Object> bodyMap= new HashMap<>();
        bodyMap.put("title","Ahmet");
        bodyMap.put("body","Merhaba");
        bodyMap.put("userId",10.0);
        bodyMap.put("id",70.0);

        return bodyMap;


}}
