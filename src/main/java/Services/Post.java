package Services;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Post {

    @Test
    public void pOST() {
        System.out.println(

                given()
                        .contentType("application/json")
                        .body("{\n" +
                                "    \"email\": \"eve.holt@reqres.in\",\n" +
                                "    \"password\": \"cityslicka\"\n" +
                                "}")
                        .post("https://reqres.in/api/login")
                        .then().statusCode(200)
                        .extract().asString());
    }
}
