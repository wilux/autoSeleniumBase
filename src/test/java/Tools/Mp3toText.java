package Tools;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Mp3toText {

    public static String getJsonPath(Response response, String key) {
        String complete = response.asString();
        JsonPath js = new JsonPath(complete);
        return js.get(key).toString();
    }


    public String fileUploadTest(String filePath) {
        Response res = given()
                .multiPart("file", new File(filePath))
                .when()
                .post("http://localhost:8080/getText")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT).extract().response();
        String value = getJsonPath(res, "text");
        return value;
    }

}

