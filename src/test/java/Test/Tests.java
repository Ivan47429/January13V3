package Test;

import Services.ReusableMethods;
import Services.UserClient;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.*;
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
        PostUserResponseBody UserCreatedFilip = userClient.createUser(new PostUserRequestBody()
                .setName("Filip")
                .setJob("QA"))
                .then().statusCode(SC_CREATED)
                .and().body(containsString("Filip"))
                .and()
                .extract().as(PostUserResponseBody.class);

        assertThat(UserCreatedFilip.getName(),equalTo("Filip"));
        assertThat(UserCreatedFilip.getJob(),equalTo("QA"));
// old school kako sto ne treba        userClient.createUser()
//                .then().statusCode(201)
//                .and().contentType(ContentType.JSON)
//                .body(containsString("Morfi"));
    }

    @Test
    public void isNewUserRetrieved() {
        Response response = userClient.retrieveUser()
                .then().statusCode(SC_OK)
                .and()
                .extract().response();

        JsonPath a = ReusableMethods.responseAsJsonPath(response);

        assertThat(a.get("data.first_name"), equalTo("Charles"));
        assertThat(a.get("data.last_name"),equalTo("Morris"));
        assertThat(a.get("data.id"), equalTo(5));

    }

    @Test
    public void isUserUpdated() {
        UpdateUserResponseBody UserFilipII =
                 userClient.updateUser(new UpdateUserRequestBody()
                .setName("Filip II").setJob("Senior QA"))
                .then().statusCode(SC_OK)
                .and().contentType(ContentType.JSON)
                .body(containsString("Filip II"))
                .and()
                .extract().as(UpdateUserResponseBody.class);

                assertThat(UserFilipII.getJob(),equalTo("Senior QA"));
                assertThat(UserFilipII.getName(),containsString("Fil"));
    }

    @Test
    public void deleteUser() {
        userClient.deleteUser()
                .then().statusCode(SC_NO_CONTENT);
    }

    @Test
    public void successfullyLogInUser() {
         PostLoginUserResponse TokenObj = userClient.loginUser(new PostLoginUserRequestBody()
                .setEmail("eve.holt@reqres.in").setPassword("cityslicka")).
                then().statusCode(SC_OK)
                .and()
                .extract().as(PostLoginUserResponse.class);
         assertThat(TokenObj.getToken(),equalTo("QpwL5tke4Pnpja7X4"));


    }

    @Test
    public void unsuccessfulLogin() {
        userClient.unsuccessfulLoginUser(new PostLoginUserRequestBody() //I'm using the same object model as successfullyLogedInUser
                .setEmail("eve.holt@reqres.in"))
                .then().statusCode(SC_BAD_REQUEST);
    }

    @Test
    public void canGetListOfUsers() {
       Response res= userClient.getListOfUsers()
                .then().statusCode(SC_OK)
               .and().extract().response();
       JsonPath jsp =ReusableMethods.responseAsJsonPath(res);

       assertThat(jsp.get("data[0].first_name"),equalTo("Michael"));
       assertThat(jsp.get("data[4].id"),equalTo(11));
       assertThat(jsp.get("page"),equalTo(2));


    }



   
    //do all the reading required
    //Base client, constructor etc
    //create property files
    //Trello update
    //step by step what to do
    //make a git comands
    //recreate framework



}
