package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reusableClass.RestResource;
import reusableClass.Routes;
import reusableClass.TokenGeneration;
import testData.SubscriptionPayload;
import utils.PropertiesUtils;

import java.io.File;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static reusableClass.SpecBuilder.getRequestSpec;

public class SubscriptionStepsDef {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    public Response  response;
    public String reponseBody;
    public File file ;
    public int code;
    Properties p;

    @Step
    @Given("GET API URL")
    public void get_api_url() {
        given(getRequestSpec());
        System.out.println("The request specificaiton is"+given(getRequestSpec()) );
      /*  requestSpecification = given().baseUri(Routes.BASE_URI).
                // auth().oauth2(TokenGeneration.getToken()).
                        header("Authorization", "Bearer " + TokenGeneration.getToken()).
                contentType("application/x-www-form-urlencoded; charset=utf-8");
        given(requestSpecification);*/

    }
    @Step
    @When("User enters valid {string}")
    public void user_enters_valid(String entityID) {
        System.out.println("API URL is"+ RestResource.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/subscribed-packages") );
        response = RestResource.get(Routes.BASE_PATH_SUBS+"merchants/" + entityID+"/subscribed-packages");
        code=response.getStatusCode();

        //response = RestAssured.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/subscribed-packages").getStatusCode();
        //response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/subscribed-packages").getStatusCode();



    }
    @Step
    @Then("Status code should be {int}")
    public void status_code_should_be(Integer expec_response_code) {
        assertThat(code, is(equalTo(expec_response_code)));
        expect().contentType(ContentType.JSON);
    }


    @Then("package details are to listed in JSON response")
    public void package_details_are_to_listed_in_json_response() throws Exception  {
        p= PropertiesUtils.loadProperties();
        File f=new File(p.getProperty("pathToFolder"));

        //Initialising CommonMethod class object
        CommonMethod cs=new CommonMethod();
        //Fetching property variables
        String pps= p.getProperty("PPS");
        String pps_id= p.getProperty("PPS_Id");
        String pname = p.getProperty("Pname");
        String pId= p.getProperty("PId");
        String pcs=p.getProperty("PCS");
        String[] expect={pcs,pps};
        //Validating the JSON response with key
        cs.validateAPIData(response,pname,expect,1);

    }

//LOcationBasedPackages locationID=fr/85d6c0c9-543e-4e8b-b5e0-1316fc426ddf(Country/region)

    @Step
    @When("User enters valid {string} and {string}")
    public void user_enters_valid_and(String entityID, String locationID) {
    response = RestResource.get(Routes.BASE_PATH_SUBS+"merchants/" + entityID+"/country/"+locationID+"/subscribed-packages");
    code=response.getStatusCode();
        System.out.println("The get api respons code is" +code+"      " );
        ResponseBody body = response.getBody();
        System.out.print("The response body is :"+body.asString());

    //   response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/country/"+locationID+"/subscribed-packages").getStatusCode();

    }


//POSTApi for packageSubScription
   /* @Step
    @Given("POST API URl & Request Body")
    public void post_api_u_rl_request_body() {
        given(getRequestSpec());
    }*/

   /* @Step
    @When("User enters valid {string} for the POST API")
    public void user_enters_valid_for_the_post_api(String entityID) {
                response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"merchants/" + entityID+"/subscribed-packages").getStatusCode();
    }*/


//GET API for activated services
    @Step
    @Given("GET API URl for activated services")
    public void get_api_u_rl_for_activated_services() {

        given(getRequestSpec());
    }
   /* @Step
    @When("User enters valid {string}  for activated services")
    public void user_enters_valid_for_activated_services(String entityID) {
        response =   RestResource.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/activated-services").getStatusCode();
       // response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/activated-services").getStatusCode();


    }*/

//POStAPI Activated services

   /* @Step
    @Given("POST API URl & Request Body for activated services")
    public void post_api_u_rl_request_body_for_activated_services() {
        file = new File("src/test/resources/datasets/configuration/active_services.json");
              requestSpecification = given().baseUri(Routes.BASE_URI).
                header("Authorization", "Bearer " + TokenGeneration.getToken()).
                             contentType(ContentType.JSON).
                body(file);
        given(requestSpecification);
    }*/

  /*  @Step
    @When("User enters valid {string} for the POST API services")
    public void user_enters_valid_for_the_post_api_services(String entityID) {
        response =   RestResource.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/activated-services").getStatusCode();

        //response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/activated-services").getStatusCode();

    }*/




//APPROVAL-REQUESTS

//1) CREATING REQUEST


//    @Given("POST API URl & Request Body for creating approval-request")
//    public void post_api_u_rl_request_body_for_creating_approval_request() {
//        given(getRequestSpec());
//
//    }
//
//
//    @When("User enters valid {string} for the POST API for approval request")
//    public void user_enters_valid_for_the_post_api_for_approval_request(String entityID) {
//
//        String payload = new SubscriptionPayload().subscriptionTD();
//      //  response = RestResource.postwithString(Routes.BASE_PATH_SUBS+"organizations/" +entityID+ "/approval-requests", payload).getStatusCode();
//
//    }


//2) GET approval-request


    /*@Given("GET API URL and inputs")
    public void get_api_url_and_inputs() {
        given(getRequestSpec()).header("request_type", "my-approval-request").
                contentType("application/x-www-form-urlencoded; charset=utf-8");

    }*/
 /*   @When("User enters valid {string} for the GET API for approval request")
    public void user_enters_valid_for_the_get_api_for_approval_request(String entityID) {
        response = RestResource.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/approval-requests").getStatusCode();
         }*/

//3) GEt request details for a selected request


  /*  @When("User enters valid {string} for the GET API for selected {string}")
    public void user_enters_valid_for_the_get_api_for_selected(String entityID, String requestID) {
        response = RestResource.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/approval-requests/"+requestID).getStatusCode();

      //  response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"organizations/" + entityID+"/approval-requests/"+requestID).getStatusCode();

    }
*/

//4) updating the status of the request

  /*  @Given("POST API URl and request body for updating the status")
    public void post_api_u_rl_and_request_body_for_updating_the_status() {
        file = new File("src/test/resources/datasets/configuration/updatereq.json");
        requestSpecification = given().baseUri(Routes.BASE_URI).
                header("Authorization", "Bearer " + TokenGeneration.getToken()).
                header("status", "cancelled").
                contentType(ContentType.JSON).
                body(file);
        given(requestSpecification);
    }*/
   /* @When("User enters valid {string} for the POST API for updation  {string}  for the entity.")
    public void user_enters_valid_for_the_post_api_for_updation_for_the_entity(String entityID, String reqID) {
        response = RestResource.get(Routes.BASE_PATH_SUBS+"organizations/" + entityID + "/approval-requests/" + reqID + "/status").getStatusCode();

     //   response = requestSpecification.when().get(Routes.BASE_PATH_SUBS+"organizations/" + entityID + "/approval-requests/" + reqID + "/status").getStatusCode();

    }*/



}
