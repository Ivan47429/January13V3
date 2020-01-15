package Services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

    public static JsonPath responseAsJsonPath(Response response){

        String responseAsString = response.asString();
        JsonPath jsp = new JsonPath(responseAsString);
        return jsp;
    }
}
