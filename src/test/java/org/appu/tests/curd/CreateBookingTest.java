package org.appu.tests.curd;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateBookingTest {


    @Description("This test is used to create new Booking")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nandeesh C L")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Test
    public void createNewBooking001() {
        System.out.println("Hello");
        Assert.assertTrue(true, "String message");
    }
}
