package stepdefinitions;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.deps.com.thoughtworks.xstream.core.util.PresortedMap;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.json.JSONArray;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.json.Json;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CommonStepDef {

    
    /*public final RequestSpecBuilder requestBuilder = new RequestSpecBuilder();

    public ValidatableResponse vResponse;
    public RequestSpecification requestSpec;

    @Given("^The header \"([^\"]*)\"=\"([^\"]*)\"$")
    public void setHeader(String key, String value) {
        requestBuilder.addHeader(key, value);
    }

    @Given("^The path \"([^\"]*)\"$")
    public void setPath(String path) {
        requestBuilder.setBasePath(path);
    }

   *//* @When("^I set the request body:$")
    public void setRequestBody(DataTable paramTable) {
        JSONObject requestParams = new JSONObject();
        paramTable.asLists().forEach(row -> requestParams.put(row.get(0), row.get(1)));
        requestBuilder.setBody(requestParams.toJSONString());
    }*//*

    @When("^I pass in the parameters:$")
    public void parameters(DataTable paramTable) {
        List<List<String>> data = paramTable.asLists();
        for (List<String> row : data) {
            requestBuilder.addParam(row.get(0), row.get(1));
        }
    }

    @When("^I send a get request$")
    public void get() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().get().then();
    }

    @When("^I send a post request$")
    public void post() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().post().then();
    }

    @When("^I send a put request$")
    public void put() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().put().then();
    }

    @When("^I send a delete request$")
    public void delete() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().delete().then();
    }

    @Then("^The body contains the values:$")
    public void bodyContainsKeyAndValue(DataTable valueTable) {
        List<List<String>> data = valueTable.asLists();
        for (List<String> row : data) {
            var extractedValue = vResponse.extract().path(row.get(0));
            assertEquals(row.get(1), extractedValue);
        }


    }*/
}
