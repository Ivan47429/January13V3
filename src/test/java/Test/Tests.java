package Test;

import Services.UserClient;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostLoginUserRequestBody;
import model.PostUserRequestBody;
import model.UpdateUserRequestBody;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
    private static RequestSpecification requestSpec;
    private UserClient userClient;

    @BeforeClass
    public void beforeTest() {

        {
            try {
                userClient = new UserClient();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void isNewUserSuccessfullyCreated() {
        userClient.createUser(new PostUserRequestBody()
                .setName("Filip")
                .setJob("QA"))
                .then().statusCode(SC_CREATED)
                .and().body(containsString("Filip"));
// old school kako sto ne treba        userClient.createUser()
//                .then().statusCode(201)
//                .and().contentType(ContentType.JSON)
//                .body(containsString("Morfi"));
    }

    @Test
    public void isNewUserRetrieved() {
        Response response = userClient.retrieveUser();
        String responseAsString = response.then().extract().asString();
        JsonPath jsp = new JsonPath(responseAsString);
        assertThat(jsp.get("first_name"), equalTo("Charles"));

    }

    @Test
    public void isUserUpdated() {
        userClient.updateUser(new UpdateUserRequestBody()
                .setName("Filip II").setJob("Senior QA"))
                .then().statusCode(SC_OK)
                .and().contentType(ContentType.JSON)
                .body(containsString("Filip II"));

    }

    @Test
    public void deleteUser() {
        userClient.deleteUser()
                .then().statusCode(SC_NO_CONTENT);
    }

    @Test
    public void successfullyLogInUser() {
        userClient.loginUser(new PostLoginUserRequestBody()
                .setEmail("eve.holt@reqres.in").setPassword("cityslicka")).
                then().statusCode(SC_OK);


    }

    @Test
    public void unsuccessfulLogin() {
        userClient.unsuccessfulLoginUser(new PostLoginUserRequestBody() //I'm using the same object model as successfullyLogedInUser
                .setEmail("eve.holt@reqres.in"))
                .then().statusCode(SC_BAD_REQUEST);
    }

    @Test
    public void canGetListOfUsers() {
        userClient.getListOfUsers()
                .then().statusCode(SC_OK);

    }

    //Tasks: create xml file to run all the tests at once, deserialize all the JSON response and put assertions on them
    //do all the reading required


}
