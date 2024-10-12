package org.appu.pojo;

/*
{
    "bookingid": 2655,
    "booking": {
        "firstname": "Pramod1",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}

 */

public class BookingResponseDeserializationPOJO {

    private int bookingid;
    private BookingInfoPOJO booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingInfoPOJO getBooking() {
        return booking;
    }

    public void setBooking(BookingInfoPOJO booking) {
        this.booking = booking;
    }


}
