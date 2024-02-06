package reusableClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestResource extends SpecBuilder {


    //Code for get request
  /*  public static Response get(String path, String token) {
        return given(getRequestSpec()).
                header("Authorization", "Bearer" + token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }*/


    //code for update request
    public static Response update(String path, String token, Object requestParameter) {
        return given(getRequestSpec()).
                body(requestParameter).
                header("Authorization", "Bearer" + token).
                when().post(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }


    public static Response get(String basePath) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + TokenGeneration.getToken()).
                when().get(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();

    }

    //Code for post request
    public static Response post(String path, String token, Object requestParameter) {
        return given(getRequestSpec()).
                body(requestParameter).
                header("Authorization", "Bearer " + TokenGeneration.getToken()).
                when().post(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response post(String basePath, File requestParameter) {
        return given(getRequestSpec()).
                body(requestParameter).
                contentType(ContentType.JSON).
                //header("Authorization", "Bearer " + TokenGeneration.getToken()).
                        when().post(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();
    }


    public static Response postwithString(String basePath, String payloadString) {
        return given(getRequestSpec()).
                body(payloadString).
                contentType(ContentType.JSON).
                //header("Authorization", "Bearer " + TokenGeneration.getToken()).
                        when().post(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}
