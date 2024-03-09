package helpers;

import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.util.ArrayList;
import java.util.List;

public class ResponseParser {
    public static List<JSONObject> parseUsersInRange(Response response) throws ParseException {
        List<JSONObject> usersInRange = new ArrayList<>();

        JSONArray jsonArray = (JSONArray) new JSONParser().parse(response.asString());
        for (Object obj : jsonArray) {
            JSONObject user = (JSONObject) obj;
            JSONObject address = (JSONObject) user.get("address");
            JSONObject geo = (JSONObject) address.get("geo");
            double lat = Double.parseDouble(geo.get("lat").toString());
            double lng = Double.parseDouble(geo.get("lng").toString());

            if (lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100) {
                usersInRange.add(user);
            }
        }
        return usersInRange;
    }
}