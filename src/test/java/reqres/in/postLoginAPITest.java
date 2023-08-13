package reqres.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojoClasses.LoginData;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class postLoginAPITest {
    @Test
    public void verifyLogin() throws IOException {
        File loginDataJSON = new File("src/test/java/resources/loginData.json");
        LoginData loginData = new ObjectMapper().readValue(loginDataJSON, LoginData.class);

        Response response = given()
                .spec(RequestSpecificationClass.getRequestSpecification())
                .body(loginData)
                .when()
                .post("/api/login")
                .then()
                .spec(RequestSpecificationClass.getResponseSpec200())
                .extract()
                .response();
        Assertions.assertEquals(200, response.getStatusCode());

    }
}
