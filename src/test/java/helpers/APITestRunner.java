package helpers;

import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

public class APITestRunner {
    public static boolean runTests(Response userResponse, Response todoResponse) throws ParseException {
        List<JSONObject> usersInRange = ResponseParser.parseUsersInRange(userResponse);
        JSONArray todoJsonArray = (JSONArray) new JSONParser().parse(todoResponse.asString());

        boolean allGreaterThe50Percent = true;
        for (JSONObject user : usersInRange) {
            boolean isGreaterThe50Percent = TodoHelper.isGreaterThe50Percent(todoJsonArray, user);
            allGreaterThe50Percent = isGreaterThe50Percent && allGreaterThe50Percent;
        }

        return allGreaterThe50Percent;
    }
}