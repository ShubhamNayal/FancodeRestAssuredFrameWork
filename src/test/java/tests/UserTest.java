package tests;


import api.APIClient;
import api.Endpoint;
import configuration.APIConfiguration;
import helpers.APITestRunner;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    @BeforeClass
    public void setUp() {
        APIConfiguration.setUp();
    }

    @Test
    public void testUserAndTodos() throws ParseException {

        Response userResponse = APIClient.getCall(Endpoint.USERS.getValue());
        Response todoResponse = APIClient.getCall(Endpoint.TODOS.getValue());
        boolean allGreaterThe50Percent = APITestRunner.runTests(userResponse, todoResponse);
        Assert.assertTrue(allGreaterThe50Percent);
    }
}