package reqres.in;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojoClasses.Employee;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

public class postAPITest {
    @Test
    public void createUserTest() {
        LocalDateTime datetime = LocalDateTime.now();
        datetime.getYear();
        datetime.toString();

        Employee employee1 = new Employee("morpheus","leader");

        Response response = given()
                .spec(RequestSpecificationClass.getRequestSpecification())
                .body(employee1)
                .when()
                .post("/api/users")
                .then()
                .spec(RequestSpecificationClass.getResponseSpec201())
                .extract()
                .response();
        Assertions.assertEquals(201, response.getStatusCode());
    }
}
