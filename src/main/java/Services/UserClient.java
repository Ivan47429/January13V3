package Services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.PostLoginUserRequestBody;
import model.PostUserRequestBody;
import model.UpdateUserRequestBody;
import util.Payload;

import java.net.URISyntaxException;

public class UserClient extends BaseClient {

    private static final String baseUri = "https://reqres.in/";

    public UserClient() throws URISyntaxException {
        super(baseUri);
    }

    public Response retrieveUser() {
        return RestAssured
                .given()
                .spec(requestSpecification()
                        .baseUri(baseUri))
                .get("/api/users/5");
    }

    public Response createUser(PostUserRequestBody requestBody) {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .baseUri(baseUri)
                .contentType("application/json")
                .body(requestBody)
                .post("api/users");
        //ne go prakja body-to ???????
    }

    public Response updateUser(UpdateUserRequestBody requestBody) {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .contentType("application/json")
                .body(requestBody)
                .baseUri(baseUri)
                .patch("api/users/2");
    }

    public Response deleteUser() {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .baseUri(baseUri)
                .delete("api/users/2");
    }


    public Response loginUser(PostLoginUserRequestBody requestBody) {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .contentType("application/json")
                .body(requestBody)
                .baseUri(baseUri)
                .post("api/login");
    }

    public Response unsuccessfulLoginUser(PostLoginUserRequestBody requestBody){
        return RestAssured
                .given()
                .spec(requestSpecification())
                .contentType("application/json")
                .body(requestBody)
                .baseUri(baseUri)
                .post("api/login");
    }

    public Response getListOfUsers(){
        return RestAssured
                .given()
                .spec(requestSpecification()).baseUri(baseUri)
                .queryParam("page",2)
                .get("api/users");
    }


}
