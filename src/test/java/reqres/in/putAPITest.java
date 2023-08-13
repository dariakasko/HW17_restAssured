package reqres.in;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

public class putAPITest {
    @Test
    public void updateUser(){
        LocalDateTime datetime = LocalDateTime.now();

        Employee employee1 = new Employee("morpheus", "zion resident");

        given()
                .spec(RequestSpecificationClass.getRequestSpecification())
                .body(employee1)
                .when()
                .put("/api/users/2")
                .then()
                .spec(RequestSpecificationClass.getResponseSpec200())
                .body("updatedAt", Matchers.startsWith(String.valueOf(datetime.getYear())));
    }
}
