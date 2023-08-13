package reqres.in;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getAPITest {

    public List<Resources> resourcesList;
    @Test
    public void resourcesTest(){

        resourcesList = given()
                .spec(RequestSpecificationClass.getRequestSpecification())
                .when()
                .get("/api/unknown")
                .then()
                .spec(RequestSpecificationClass.getResponseSpec200())
                .extract()
                .jsonPath()
                .getList("data", Resources.class);
        Assertions.assertTrue(verifyNamesOfResourceList());
    }

    public boolean verifyNamesOfResourceList() {
        List<String> namesOfResources = Arrays.asList("cerulean", "fuchsia rose", "true red", "aqua sky", "tigerlily", "blue turquoise");
        for (int i = 0; i < resourcesList.size(); i++) {

            if (!resourcesList.get(i).getName().equals(namesOfResources.get(i))) {
                return false;
            }
        }
        return true;
    }
}
