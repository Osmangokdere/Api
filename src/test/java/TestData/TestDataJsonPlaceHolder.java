package TestData;

import netscape.javascript.JSObject;
import org.json.JSONObject;

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


}
