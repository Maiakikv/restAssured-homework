package util;

import enums.EndPoint;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GeneratedToken {
    public static String generateToken() {
        RequestSpecification request = RestAssured.given();
        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        request.header("Content-Type", "application/json");
        Response responseFromGeneratedToken = request.body(payLoad).post(EndPoint.BASEURL +"/auth");
        String jsonString = responseFromGeneratedToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");
        return tokenGenerated;
    }
}
