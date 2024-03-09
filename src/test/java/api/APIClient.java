package api;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class APIClient {

    public static Response getCall(String basePath) {
        return given().log().all().when().get(basePath).then().extract().response();
    }

}