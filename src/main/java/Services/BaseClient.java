package Services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

public class BaseClient {
    private URI baseURi;

    public BaseClient(String baseUri) throws URISyntaxException {
        this.baseURi = new URI(baseUri);
    }

    public RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .build();
    }

}
