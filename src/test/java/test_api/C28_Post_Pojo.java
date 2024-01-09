package test_api;

import BaseUrl.HerokuAppBaseUrl;
import org.junit.Test;
import pojos.PojoHerokuappBooking;
import pojos.PojoHerokuappBookingDates;

public class C28_Post_Pojo extends HerokuAppBaseUrl {


    @Test
    public void post01(){
        specHerokuapp.pathParam("pp1","booking");
        PojoHerokuappBooking reqBodyy= new PojoHerokuappBooking("Ahmet");
    }
}
