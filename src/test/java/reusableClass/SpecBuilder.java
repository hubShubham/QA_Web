package reusableClass;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.PropertiesUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class SpecBuilder {

    public static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    public static Properties property = new Properties();
    public static File file;

    // Request specification using Spec builder method
    public static RequestSpecification getRequestSpec() {
        property = PropertiesUtils.loadProperties();
        RestAssured.baseURI = property.getProperty("base.uri");
        return new RequestSpecBuilder().
                  addHeader("Authorization", "Bearer " + TokenGeneration.getToken()).
                  addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();

         }


    //Response specification using Specbuilder
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
             //   log(LogDetail.ALL).
                build();
       }


    //Request specifation with dynamic base URI and Path
    public static RequestSpecification getRequestSpecParam(String BASE_URI, String basePath) {
        return new RequestSpecBuilder().
             //setBaseUri(Routes.BASE_URI).
                setBasePath(basePath).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
             //   log(LogDetail.ALL).
                build();
           }


   /* var prop = new Properties();
    var environment = System.getProperty("env");

        if (environment == null) {
        environment = "ppaas.dev";


    }

    var filePath = environment + ".properties";
        System.out.println("The file path is " + environment);*/

    public static Response postAccount(HashMap<String, String> formParam) {
        property = PropertiesUtils.loadProperties();
     //   RestAssured.baseURI = property.getProperty("keyclock.dev");
      // var token = System.getProperty("devtoken");
       // RestAssured.baseURI =  property.getProperty("token");
      // System.out.println("The value of token is " +  token);
        return given().
                baseUri(property.getProperty("token")).
             //   baseUri("https://keycloak.dev.ppaas.tech").
                contentType(ContentType.URLENC).
                formParams(formParam).
                when().post("/auth/realms/ppaas/protocol/openid-connect/token").
                then().spec(getResponseSpec()).extract().response();
    }


    public static RequestSpecification getRequestSpecification(String baseUrl, String basePath) {
        return new RequestSpecBuilder().
                setBaseUri(baseUrl).
                setBasePath(basePath).
                //addHeader("Authorization", "Bearer " + access_token).
                // setContentType("application/x-www-form-urlencoded; charset=utf-8").
                        setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
              //  log(LogDetail.ALL).
                build();
        // requestSpecification = requestSpecBuilder.build();

    }


}
