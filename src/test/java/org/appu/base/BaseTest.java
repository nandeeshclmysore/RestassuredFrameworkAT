package org.appu.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.appu.asserts.AssertActions;
import org.appu.endpoints.APIConstants;
import org.appu.modules.PayloadManager;
import org.appu.pojo.BookingResponseDeserializationPOJO;
import org.appu.pojo.GetTokenResponsePayloadMain;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;

    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public AssertActions assertActions;
    public String token;
    public int bookigID;

    @BeforeTest
    public void setup() {
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASEURI).setContentType(ContentType.JSON).
                build().log().all();
    }

    //Method to create and return token
    public String createTokenAPI() {
        response = RestAssured.given(requestSpecification).body(payloadManager.payloadForGetToken())
                .when().log().all().post(APIConstants.AUTH_ENDPOINT);

        String responseAsString = response.asString();
        GetTokenResponsePayloadMain getTokenResponsePayloadMain = payloadManager.getTokenDeserializarionPOJO(responseAsString);
        token = getTokenResponsePayloadMain.getToken();
        return token;
    }

    //Method to create and return booking ID
    public Integer createBookingIDAPI() {
        response = RestAssured.given(requestSpecification).body(payloadManager.payloadForCreateBooking())
                .when().log().all().post(APIConstants.CREATEBOOKING_ENDPOINT);

        String responseAsString = response.asString();
        BookingResponseDeserializationPOJO bookingResponseDeserializationPOJO = payloadManager.deserializationForCreateBooking(responseAsString);
        bookigID =bookingResponseDeserializationPOJO.getBookingid();
        return bookigID;
    }
}
