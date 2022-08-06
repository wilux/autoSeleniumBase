package TestCase;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class ApiRestTest {


    public static String getJsonPath(Response response, String key) {
        String complete = response.asString();
        JsonPath js = new JsonPath(complete);
        return js.get(key).toString();
    }

    @Test
    public void fileUploadTest() {
        Response res = given()
                .multiPart("file", new File("audio/audio.mp3"))
                .when()
                .post("http://localhost:8080/getText")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT).extract().response();
        String value = getJsonPath(res, "text");
        System.out.println(value);
    }

}
