package com.apiTesting.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.apiTesting.model.User;

import static io.restassured.RestAssured.given;

public class UserApi {
    
    private static final String BASE_URL = "https://reqres.in/api";
    
    public static Response getUsers(int page) {
        return given()
                .queryParam("page", page)
                .when()
                .get(BASE_URL + "/users");
    }
    
    
    public static Response getUserById(int userId) {
        return given()
                .when()
                .get(BASE_URL + "/users/" + userId);
    }
    
    public static Response createUser(User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(BASE_URL + "/users");
    }
    
    public static Response updateUser(int userId, User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .put(BASE_URL + "/users/" + userId);
    }
    
    public static Response deleteUser(int userId) {
        return given()
                .when()
                .delete(BASE_URL + "/users/" + userId);
    }
    
    public static Response loginUser(String email, String password) {
        return RestAssured.given()
                          .header("Content-Type", "application/json")
                          .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                          .when()
                          .post(BASE_URL + "/login");
    }

    public static Response loginUserInvalid(String email) {
        return RestAssured.given()
                          .header("Content-Type", "application/json")
                          .body("{\"email\": \"" + email + "\"}")
                          .when()
                          .post(BASE_URL + "/login");
    }

    public static Response getUsersWithDelay(int delayInSeconds) {
        return given()
                .queryParam("delay", delayInSeconds)
                .when()
                .get("/users")
                .then()
                .extract()
                .response();
    }
}
