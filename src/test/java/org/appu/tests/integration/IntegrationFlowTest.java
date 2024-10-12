package org.appu.tests.integration;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.appu.base.BaseTest;
import org.appu.endpoints.APIConstants;
import org.appu.listeners.RetryAnalyzer;
import org.appu.pojo.BookingInfoPOJO;
import org.appu.pojo.BookingResponseDeserializationPOJO;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IntegrationFlowTest extends BaseTest {

    //String token;
    //Integer bookingID;

    @BeforeClass
    public void getTokenAndBookingID(ITestContext context)
    {
       context.setAttribute("token",createTokenAPI());
       context.setAttribute("bookingID",createBookingIDAPI());
    }

    @Description("This test is used to update existing Booking")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nandeesh C L")
    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void validateUpdateAPI()
    {
        response = RestAssured.given(requestSpecification).header("Cookie","token="+token).body(payloadManager.payloadForUpdateBooking())
                .when().log().all().put(APIConstants.UPDATEBOOKING_ENDPOINT+"/"+bookigID);

        String responseAsString = response.asString();
        BookingInfoPOJO bookingInfoPOJO = payloadManager.deserializationForUpdateBooking(responseAsString);
        String firstName =bookingInfoPOJO.getFirstname();
        System.out.println("Update FN is: "+firstName);
    }

    @Description("This test is used to get existing Booking")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nandeesh C L")
    @Test(retryAnalyzer= RetryAnalyzer.class)
    public void validateGetAPI()
    {
        response = RestAssured.given(requestSpecification)
                .when().log().all().get(APIConstants.GETBOOKING_ENDPOINT+"/"+bookigID);

        String responseAsString = response.asString();
        BookingInfoPOJO bookingInfoPOJO = payloadManager.deserializationForUpdateBooking(responseAsString);
        String firstName =bookingInfoPOJO.getFirstname();
        System.out.println("Get FN is: "+firstName);
    }


}
