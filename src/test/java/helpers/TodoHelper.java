package helpers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Objects;

public class TodoHelper {
    public static boolean isGreaterThe50Percent(JSONArray todoJsonArray, JSONObject user) {
        int countTrue = 0;
        int countTotal = 0;
        for (int j = 0; j < todoJsonArray.size(); j++) {
            JSONObject jsonObject = (JSONObject) todoJsonArray.get(j);
            if (Objects.equals(jsonObject.get("userId"), user.get("id"))) {
                if (Objects.equals(jsonObject.get("completed").toString(), "true")) {
                    countTrue++;
                }
                countTotal++;
            }
        }
        return (countTotal == 0) ? false : ((countTrue * 100) / countTotal >= 50);
    }
}