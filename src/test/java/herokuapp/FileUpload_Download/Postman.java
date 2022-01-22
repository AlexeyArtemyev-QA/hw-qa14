package herokuapp.FileUpload_Download;

import org.testng.annotations.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Postman {

    @Test
    public void testOne() {
        given().
                header("Token", "3efed660932ac1a0dafdeeb2bbc487597aede3ed").
                header("content-type", "application/json").
                body("{\"title\": \"QA14\",\"code\":\"qqwwee4\"}").
                when().
                post("https://api.qase.io/v1/project").
                then().log().all().
                statusCode(200).
                body("status", equalTo(true),
                "result.code", equalTo("qqwwee4".toUpperCase(Locale.ROOT)));
    }


    // https://app.qase.io/project/QQWWEE4?view=2
    @Test
    public void getProgectTest() {
        String code = "QQWWEE4";
        given().
                header("Token", "3efed660932ac1a0dafdeeb2bbc487597aede3ed").
                header("content-type", "application/json").
                body("{\"title\": \"QA14\",\"code\":\"qqwwee4\"}").
                when().
                get("https://api.qase.io/v1/project" + code).
                then().log().all().
                statusCode(200).
                body("status", equalTo(true),
                        "result.code", equalTo("qqwwee4".toUpperCase(Locale.ROOT)));


    }
}


