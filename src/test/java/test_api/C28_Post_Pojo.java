package test_api;

import BaseUrl.HerokuAppBaseUrl;
import org.junit.Test;
import pojos.PojoHerokuappBooking;
import pojos.PojoHerokuappBookingDates;
import pojos.PojoHerokuappExpectedBody;

public class C28_Post_Pojo extends HerokuAppBaseUrl {


    @Test
    public void post01(){

        // 1 - URL ve Body hazirla

        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingDates bookingDates = new PojoHerokuappBookingDates("2021-06-01","2021-06-10");

    }
}
