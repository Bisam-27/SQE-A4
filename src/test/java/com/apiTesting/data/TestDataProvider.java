package com.apiTesting.data;

import org.testng.annotations.DataProvider;

import com.apiTesting.model.Resource;
import com.apiTesting.model.User;

public class TestDataProvider {

    @DataProvider(name = "userCreationData")
    public Object[][] userCreationData() {
        return new Object[][] {
            { new User("Bisam", "Software Engineer") },
            { new User("Ahmad", "HR Manager") },
            { new User("Iman", "Software Analyst") }
        };
    }

    @DataProvider(name = "invalidUserData")
    public Object[][] invalidUserData() {
        return new Object[][] {
            { new User("", "Softwre Engineer") },       
            { new User("Bisam", "") },          
            { new User("Iman", null) }          
        };
    }
    @DataProvider(name = "resourceCreationData")
    public Object[][] resourceCreationData() {
        return new Object[][] {
            { new Resource("Resource A", "Software Developer") },
            { new Resource("Resource B", "HR Manager") },
            { new Resource("Resource C", "Software Analyst") }
        };
    }
    @DataProvider(name = "invalidResourceData")
    public Object[][] invalidResourceData() {
        return new Object[][] {
            { new Resource("", "Software Developer") },       
            { new Resource("Resource A", "") },     
            { new Resource("Resource B", null) }     
        };
    }
}
