package com.apiTesting.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiTestHelper {

    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, 
            "Expected status code " + expectedStatusCode + " but got " + response.getStatusCode());
    }
    
    public static void assertResponseContains(Response response, String expectedKey, String expectedValue) {
        Assert.assertEquals(response.jsonPath().getString(expectedKey), expectedValue,
            "Expected " + expectedKey + " to be " + expectedValue + " but was " + response.jsonPath().getString(expectedKey));
    }
    
    public static void assertListNotEmpty(Response response, String jsonPathKey) {
        int size = response.jsonPath().getList(jsonPathKey).size();
        Assert.assertTrue(size > 0, "List under key '" + jsonPathKey + "' is empty!");
    }
}
