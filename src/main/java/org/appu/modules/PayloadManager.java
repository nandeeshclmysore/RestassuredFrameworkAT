package org.appu.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.appu.pojo.*;

public class PayloadManager {

    Faker faker = new Faker();
    Gson gson;

    //Convert java object [pojo class object] to json string
    //Creating JSON for serialization for create booki request
    public String payloadForCreateBooking() {
        BookingDatesPOJO bd = new BookingDatesPOJO();
        bd.setCheckin("2018-01-01");
        bd.setCheckout("2019-01-01");

        BookingInfoPOJO bi = new BookingInfoPOJO();
        //faker.name().firstName();
        bi.setFirstname("Appu");
        bi.setLastname(faker.name().lastName());
        bi.setTotalprice(faker.random().nextInt(200, 5000));
        bi.setDepositpaid(true);
        bi.setBookingdates(bd);
        bi.setAdditionalneeds("Dinner");

        gson = new Gson();
        String payload = gson.toJson(bi); //Converts Java Object to JSON

        return payload;

    }

    public BookingResponseDeserializationPOJO deserializationForCreateBooking(String responseAsString) {
        gson = new Gson();
        BookingResponseDeserializationPOJO bookingResponseDeserializationPOJO = gson.fromJson(responseAsString, BookingResponseDeserializationPOJO.class);
        return bookingResponseDeserializationPOJO;
    }

    public String payloadForGetToken() {
        GetTokenRequestPayloadMain getTokenRequestPayloadMain = new GetTokenRequestPayloadMain();
        getTokenRequestPayloadMain.setUsername("admin");
        getTokenRequestPayloadMain.setPassword("password123");

        gson = new Gson();
        String payload = gson.toJson(getTokenRequestPayloadMain); //Converts Java Object to JSON

        return payload;
    }

    public GetTokenResponsePayloadMain getTokenDeserializarionPOJO(String responseAsString) {
        gson = new Gson();
        GetTokenResponsePayloadMain getTokenResponsePayloadMain = gson.fromJson(responseAsString, GetTokenResponsePayloadMain.class);
        return getTokenResponsePayloadMain;
    }


    public String payloadForUpdateBooking() {
        BookingDatesPOJO bd = new BookingDatesPOJO();
        bd.setCheckin("2018-01-01");
        bd.setCheckout("2019-01-01");

        BookingInfoPOJO bi = new BookingInfoPOJO();
        bi.setFirstname("Appu "+faker.name().firstName());
        bi.setLastname(faker.name().lastName());
        bi.setTotalprice(faker.random().nextInt(200, 5000));
        bi.setDepositpaid(true);
        bi.setBookingdates(bd);
        bi.setAdditionalneeds("Dinner");

        gson = new Gson();
        String payload = gson.toJson(bi); //Converts Java Object to JSON

        return payload;

    }

    public BookingInfoPOJO deserializationForUpdateBooking(String responseAsString) {
        gson = new Gson();
        BookingInfoPOJO bookingInfoPOJO = gson.fromJson(responseAsString, BookingInfoPOJO.class);
        return bookingInfoPOJO;
    }

}
