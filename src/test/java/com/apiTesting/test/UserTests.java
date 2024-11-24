package com.apiTesting.test;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.apiTesting.api.UserApi;
import com.apiTesting.model.User;
import com.apiTesting.utils.ApiTestHelper;
import com.apiTesting.data.TestDataProvider;


public class UserTests {

    @Test
    public void testGetUsers() {
        Response response = UserApi.getUsers(2); 
        ApiTestHelper.assertStatusCode(response, 200);
    }

    @Test(dataProvider = "userCreationData", dataProviderClass = TestDataProvider.class)
    public void testCreateUser(User user) {
        Response response = UserApi.createUser(user);
        ApiTestHelper.assertStatusCode(response, 201); 
    }

    @Test
    public void testUpdateUser() {
        User updatedUser = new User("Bisam", "Software Engineer");
        Response response = UserApi.updateUser(2, updatedUser);
        ApiTestHelper.assertStatusCode(response, 200);
        ApiTestHelper.assertResponseContains(response, "name", "Bisam");
    }

    @Test
    public void testDeleteUser() {
        Response response = UserApi.deleteUser(2);
        ApiTestHelper.assertStatusCode(response, 204); 
    }
    @Test
    public void testLoginUserValid() {
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";

        Response response = UserApi.loginUser(email, password);
        ApiTestHelper.assertStatusCode(response, 200); 
        ApiTestHelper.assertResponseContains(response, "token", response.jsonPath().getString("token"));

        System.out.println("Response for Successful Login: " + response.asString());
    }
    
    @Test
    public void testLoginUserInvalid() {
        String email = "eve.holt@reqres.in";

        Response response = UserApi.loginUserInvalid(email);
        ApiTestHelper.assertStatusCode(response, 400); 
        ApiTestHelper.assertResponseContains(response, "error", "Missing password");

        System.out.println("Response for Unsuccessful Login: " + response.asString());
    }
   
}
