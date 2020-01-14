package Services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

public class BaseClient {
    private URI baseURi;

    public BaseClient(String baseUri) throws URISyntaxException {
        this.baseURi = new URI(baseUri);
    }

    public RequestSpecification requestSpecification(){
        return  new RequestSpecBuilder().build();
    }

}
