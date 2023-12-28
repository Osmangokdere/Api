package test_api;

import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C09_JsonPathKullanimi {
    @Test
    public void test01(){
        JSONObject kisiBilgisi=new JSONObject();
        JSONObject adresBilgisi=new JSONObject();
        JSONArray telefonBilgileri=new JSONArray();
        JSONObject evTel=new JSONObject();
        JSONObject cepBilgisi=new JSONObject();

        cepBilgisi.put("Type","iphone");
        cepBilgisi.put("number", 0123-456);
        evTel.put("Type", "home");
        evTel.put("number", 0123-444);
        telefonBilgileri.put(evTel);
        telefonBilgileri.put(cepBilgisi);

        adresBilgisi.put("streetAddress", "naist street");
        adresBilgisi.put("city", "Nara");
        adresBilgisi.put("postalCode", "630-231");



      kisiBilgisi.put("firstname", "osman");
      kisiBilgisi.put("lastname", "gokdere");
      kisiBilgisi.put("age",26 );
      kisiBilgisi.put("adresBilgisi", adresBilgisi);
      kisiBilgisi.put("telefonBilgisi", telefonBilgileri);
        System.out.println(kisiBilgisi);
    }

}
