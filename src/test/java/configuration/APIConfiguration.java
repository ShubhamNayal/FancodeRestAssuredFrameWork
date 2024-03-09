package configuration;

import io.restassured.RestAssured;

public class APIConfiguration {
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
}