package org.appu.tests.curd;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.appu.base.BaseTest;
import org.appu.endpoints.APIConstants;
import org.appu.listeners.RetryAnalyzer;
import org.appu.pojo.BookingResponseDeserializationPOJO;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class CreateBookingTest extends BaseTest {
    @Description("This test is used to create new Booking")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nandeesh C L")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Test(retryAnalyzer=RetryAnalyzer.class)
    public void validateCreateBookingFunctionality001() {
        //Given and When
        response = RestAssured.given(requestSpecification).body(payloadManager.payloadForCreateBooking())
                .when().post(APIConstants.CREATEBOOKING_ENDPOINT);

        validatableResponse = response.then().log().all();

        //Normal Rest assured validations
        validatableResponse.statusCode(201);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Appu"));

        //Deserialization validation
        String responseAsString = response.asString();
        BookingResponseDeserializationPOJO bookingResponseDeserializationPOJO = payloadManager.deserializationForCreateBooking(responseAsString);
        //Test NG Assertion
        Assert.assertNotNull(bookingResponseDeserializationPOJO.getBookingid());
        //Assert J assertion
        assertThat(bookingResponseDeserializationPOJO.getBookingid()).isNotNull();
        assertThat(bookingResponseDeserializationPOJO.getBooking().getFirstname()).isNotEmpty();











    }
}
