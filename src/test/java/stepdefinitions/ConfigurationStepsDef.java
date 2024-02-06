package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import reusableClass.RestResource;
import reusableClass.Routes;
import reusableClass.SpecBuilder;
import reusableClass.TokenGeneration;
import utils.PropertiesUtils;

import java.io.File;
import java.util.Properties;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static reusableClass.SpecBuilder.getRequestSpec;

public class ConfigurationStepsDef extends SpecBuilder {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    public Response response;
    public String reponseBody;
    Properties p;
    int code;
    File file ;

    @Given("configuration api")
    public void configuration_api() {
        given(getRequestSpec());
      }

    @When("send a post request with valid package code {string} {string}  request to server")
    public void send_a_post_request_with_valid_package_code_request_to_server(String entityId, String serviceId) {
       property = PropertiesUtils.loadProperties();
       file = new File(property.getProperty("configurationPayloadPath"));
       response =  RestResource.post(Routes.BASE_PATH_CONFIG+"merchants/" + entityId + "/services/" +serviceId + "/options/configuration", file);
       code=response.getStatusCode();

    }

    @Then("Configuration response code should be {int}")
    public void Configuration_response_code_should_be(Integer expectResponseCode) {

        assertThat(code, is(equalTo(expectResponseCode)));
        expect().contentType(ContentType.JSON);
        // assertThat(reponseBody("data.serviceOptions.serviceParameters.serviceParameterValues", equalTo("true"));
    }






    //GET API for Configuration
    @Given("configuration GET API")
    public void configuration_get_api() {
        given(getRequestSpec());

    }
    @When("User enters a valid {string} for an {string}")
    public void user_enters_a_valid_for_an(String entityID, String serviceID) {
    response = RestResource.get(Routes.BASE_PATH_CONFIG+"merchants/" + entityID + "/services/" +serviceID + "/options/configuration");
        //response  =  requestSpecification.when().get(Routes.BASE_PATH_CONFIG+"merchants/" + entityID + "/services/" +serviceID + "/options/configuration" ).getStatusCode()
        code=response.getStatusCode();
    }

    @Then("Configuration details are listed in JSON")
    public void configuration_details_are_listed_in_json()throws Exception {

        p=PropertiesUtils.loadProperties();
        File f=new File(p.getProperty("pathToFolder"));

        String bank=p.getProperty("Bank");
        String servname =p.getProperty("ServName");
        String o_name=p.getProperty("O_name");
        String o_id=p.getProperty("O_ID");
        String Optionkey_id=p.getProperty("OptionID");
        String Optionkey_name=p.getProperty("OptionName");
        String optionstatus=p.getProperty("O_Status");


        CommonMethod cs=new CommonMethod();
        cs.validateWithpoutArray(response,servname,bank);
        cs.validateforServiceOptions(response,Optionkey_id,o_id,1);
        cs.validateforServiceOptions(response,Optionkey_name,o_name,1);

    }

    @Then("Parameter Details are listed in Array")
    public void parameter_details_are_listed_in_array() throws Exception{
        p=PropertiesUtils.loadProperties();
        File f=new File(p.getProperty("pathToFolder"));

        String param_key=p.getProperty("Param_key");
        String param_value=p.getProperty("Param_value");
        String expec_Id=p.getProperty("Expect_Id");
        int Id=Integer.parseInt(expec_Id);

        String expec_value=p.getProperty("Expect_value");
        CommonMethod cs=new CommonMethod();
        //  cs.validateParameters(response,param_key,Id,1);
        cs.validateParameters(response,param_value,expec_value,1);
    }

//Configuration API for service parameters

    @Given("configuration Post API")
    public void configuration_post_api() {
        given(getRequestSpec());
 }


    @When("User enters valid {string} and {string} for post API")
    public void user_enters_valid_and_for_post_api(String entityId, String serviceId) {
        property = PropertiesUtils.loadProperties();
        file = new File(property.getProperty("configParamPayload"));
        response = RestResource.post(Routes.BASE_PATH_CONFIG+"merchants/" + entityId + "/services/" + serviceId + "/configuration" , file);
       // reponseBody  =  requestSpecification.when().post(Routes.BASE_PATH_CONFIG+"merchants/" + entityId + "/services/" + serviceId + "/configuration" ).asString();
        code=response.getStatusCode();
    }

//Configuration Parameter GET APi(Global)

    @Given("GET API for service parameters")
    public void get_api_for_service_parameters() {
        given(getRequestSpec());
       }


    @When("User enters valid {string}, {string} for service paramters")
    public void user_enters_valid_for_service_paramters(String entityId, String serviceId) {
    response = RestResource.get(Routes.BASE_PATH_CONFIG+"merchants/" + entityId + "/services/" + serviceId + "/configuration");
    code=response.getStatusCode();


    }

//SPECIFIC
//Service Options
//1. GEt

    @Given("GET API for specific service options")
    public void get_api_for_specific_service_options() {
        given(getRequestSpec());

    }
    @When("User enters valid {string}, {string}  and {string}")
    public void user_enters_valid_and(String entityId, String serviceId, String providerId) {
    response= RestResource.get(Routes.BASE_PATH_CONFIG+"merchants/" + entityId + "/services/" + serviceId +"/service-providers/"+providerId+ "/configuration");
    code=response.getStatusCode();


    }

    @Then("Specific Configurations are listed in JSOn")
    public void specific_configurations_are_listed_in_js_on()throws Exception {

        p=PropertiesUtils.loadProperties();
        File f=new File(p.getProperty("pathToFolder"));
        CommonMethod cs=new CommonMethod();
        String key_name=p.getProperty("Key_object");
        String key_attrib=p.getProperty("Key_attribute");
        String key_value=p.getProperty("Key_Value");
        String group_object=p.getProperty("Group_object");
        String value=p.getProperty("Value_key");
        String group_value=p.getProperty("value_group");

        cs.validateForConfigurations(response,key_name,key_attrib,1);
     //   cs.validateForConfigurations(response,key_value,value,1);
        cs.validateForConfigurations(response,group_object,group_value,1);



    }


//POST

    @Given("POST API for specific service options")
    public void post_api_for_specific_service_options() {
        given(getRequestSpec());

    }
    @When("User enters valid {string}, {string}  and {string} for POST Options")
    public void user_enters_valid_and_for_post_options(String entityId, String serviceId, String providerId) {
        property = PropertiesUtils.loadProperties();
        file = new File(property.getProperty("specificServiceOption"));
        response = RestResource.post(Routes.BASE_PATH_CONFIG+"merchants/" + entityId + "/services/" + serviceId +"/service-providers/"+providerId+ "/options/configuration"  , file);
        code=response.getStatusCode();

    }
}
