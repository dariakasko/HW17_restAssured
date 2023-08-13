package reqres.in;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class deleteAPITest {
    @Test
    public void deleteUser(){
        Response response = given()
                .spec(RequestSpecificationClass.getRequestSpecification())
                .when()
                .delete("/api/users/2")
                .then()
                .spec(RequestSpecificationClass.getResponseSpec204())
                .extract()
                .response();
        Assertions.assertEquals(204, response.getStatusCode());
    }
}
