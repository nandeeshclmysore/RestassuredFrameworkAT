package org.appu.endpoints;


import org.appu.utils.PropertyReader;

public class APIConstants {
    public static final String BASEURI = PropertyReader.getVakueForGivenKey("test_url");
    public static final String CREATEBOOKING_ENDPOINT = "/booking";
    public static final String AUTH_ENDPOINT = "/auth";
    public static final String PING_ENDPOINT = "https://restful-booker.herokuapp.com";
    public static final String UPDATEBOOKING_ENDPOINT = "/booking";
    public static final String GETBOOKING_ENDPOINT  ="/booking";
}
