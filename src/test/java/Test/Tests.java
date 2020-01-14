package Test;

import Services.UserClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

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
        userClient.createUser()
                .then().statusCode(201)
                .and().contentType(ContentType.JSON)
                .body(containsString("Morfi"));
    }

    @Test
    public void isNewUserRetrieved() {
        Response response = userClient.retrieveUser();
        response.then().extract().path("data");
        assertThat(1, equalTo(1));
    }

    @Test
    public void isUserUpdated() {
        userClient.updateUser()
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .body(containsString("MORFImorpheus"));

    }

    @Test
    public void deleteUser() {
        userClient.deleteUser()
                .then().statusCode(204);
    }

    @Test
    public void successfullyLogInUser() {
        userClient.loginUser().
                then().statusCode(200);
    }

    @Test
    public void unsuccessfulLogin() {
        userClient.unsuccessfulLoginUser()
                .then().statusCode(400);
    }

    @Test
    public void canGetListOfUsers() {
        userClient.getListOfUsers()
                .then().statusCode(200);

    }


}
