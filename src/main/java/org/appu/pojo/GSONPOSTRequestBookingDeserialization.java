package org.appu.pojo;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GSONPOSTRequestBookingDeserialization {


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    int bookingID;

    @Description("This test is used to create new bookings")
    @Test
    public void testBooking() {
        String URL = "https://restful-booker.herokuapp.com";
        String URI = "/booking";

        BookingDatesPOJO bd = new BookingDatesPOJO();
        bd.setCheckin("2018-01-01");
        bd.setCheckout("2019-01-01");

        BookingInfoPOJO bi = new BookingInfoPOJO();
        bi.setFirstname("Appu");
        bi.setLastname("Raj");
        bi.setTotalprice(123);
        bi.setDepositpaid(true);
        bi.setBookingdates(bd);
        bi.setAdditionalneeds("Dinner");

        //GSON
        Gson gson = new Gson();
        String payload = gson.toJson(bi); //Converts Java Object to JSON

        requestSpecification = RestAssured.given();
        requestSpecification.log().all().
                baseUri(URL).contentType(ContentType.JSON)
                .body(payload)
                .basePath(URI);

        Response response = requestSpecification.when().post();

        String responseAsString=response.asString();
        BookingResponseDeserializationPOJO brdp= gson.fromJson(responseAsString,BookingResponseDeserializationPOJO.class);

        System.out.println("BOOKING ID: "+ brdp.getBookingid());
        System.out.println("FIRST NAME: "+brdp.getBooking().getFirstname());
    }
}
