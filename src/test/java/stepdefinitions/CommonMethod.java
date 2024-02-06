package stepdefinitions;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import reusableClass.Routes;
import utils.PropertiesUtils;

import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonMethod {
    static Properties property = new Properties();

    public    Response Response;






    public String RandomSTring(String name)
    {
        Random r= new Random();
        int random=r.nextInt();
        String randomStr=name+random;
        return randomStr;
    }


    public  void    validateAPIData(Response response, String key, String[] expected,int n ) throws Exception {

        JSONArray array = new JSONArray(response.getBody().asString());

        for(int i=0; i<n;i++)
        {
            JSONObject obj = array.getJSONObject(i);
            System.out.println("value of the key"+":"+obj.get(key));
            assertThat( obj.get(key), is(Matchers.equalTo(expected[i] )));


        }

    }
    public void validateServiceArray(Response response, String key, String[] expected,int n)throws Exception
    {
        JSONArray array=new JSONArray(response.getBody().asString());

        for(int i=0; i<array.length();i++)
        {
            JSONObject obj = array.getJSONObject(i);
            JSONArray serv= obj.getJSONArray("services");
            for(int j=0; j<n;j++) {
                JSONObject obj2=serv.getJSONObject(j);
                System.out.println("value of the key" + ":" + obj2.get(key));

                assertThat(obj2.get(key), is(Matchers.equalTo(expected[j])));
            }

        }
    }
    public  void    validateWithSingleDetails(Response response, String key, String expected ) throws Exception {

        JSONArray array = new JSONArray(response.getBody().asString());

        for(int i=0; i<array.length();i++)
        {
            JSONObject obj = array.getJSONObject(i);
            System.out.println("value of the key"+":"+obj.get(key));
            assertThat( obj.get(key), is(Matchers.equalTo(expected )));

        }

    }

    public void validateServicedetails(Response r, String Key, String[] expected, int n ) throws Exception
    {

        JSONArray array=new JSONArray(r.getBody().asString());

        for(int i=0; i<array.length();i++)
        {
            JSONObject obj = array.getJSONObject(i);
            JSONArray serv= obj.getJSONArray("services");
            for(int j=0; j<n;j++) {
                JSONObject obj2=serv.getJSONObject(j);
                System.out.println("value of the key" + ":" + obj2.get(Key));

                assertThat(obj2.get(Key), is(Matchers.equalTo(expected[j])));
            }

        }


    }
public void validateServicedetailsForTenant(Response r, String Key, String[] expected, int n ) throws Exception
{
    JSONArray array = new JSONArray(r.getBody().asString());

    for(int i=0; i<n;i++)
    {
        JSONObject obj = array.getJSONObject(i);
        System.out.println("value of the key"+":"+obj.get(Key));
        assertThat( obj.get(Key), is(Matchers.equalTo(expected[i] )));


    }

}
public void validateWithpoutArray(Response response,String key, String expect)throws Exception
{


    JSONObject jObj=new JSONObject(response.getBody().asString());
    assertThat(   jObj.get(key), is(Matchers.equalTo(expect )));
}

public void validateforServiceOptions(Response response , String key, String expect, int n)throws Exception
{
    JSONObject jObj=new JSONObject(response.getBody().asString());
    JSONArray arr=jObj.getJSONArray("serviceOptions");
    for(int j=0; j<n;j++) {
        JSONObject obj2=arr.getJSONObject(j);
        System.out.println("value of the key" + ":" + obj2.get(key));

        assertThat(obj2.get(key), is(Matchers.equalTo(expect)));
    }


}
public void validateParameters(Response response, String key, String expec, int n)throws Exception
{
    JSONObject jObj=new JSONObject(response.getBody().asString());
    JSONArray arr=jObj.getJSONArray("serviceOptions");
    for(int j=0; j<n;j++) {
        JSONObject obj2 = arr.getJSONObject(j);
        JSONArray servParam=obj2.getJSONArray("serviceParameters");
        for(int k=0;k<n;k++)
        {
            JSONObject obj3 = servParam.getJSONObject(k);
            JSONArray servParamValues=obj3.getJSONArray("serviceParameterValues");
            for(int i=0;i<n;i++)
            {
                JSONObject obj4 = servParamValues.getJSONObject(i);
                System.out.println("value of the key" + ":" + obj4.get(key));
                assertThat(obj4.get(key), is(Matchers.equalTo(expec)));
            }
        }
    }

}
public void validateForConfigurations(Response response, String key, String Expect, int n)throws Exception
{
    JSONArray array = new JSONArray(response.getBody().asString());
    for(int i=0;i<n;i++)
    {
    JSONObject obj=array.getJSONObject(i);
    assertThat(obj.get(key), is(Matchers.equalTo(Expect)));
    }
}

       public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
             //   log(LogDetail.ALL).
                build();
        //responseSpecification = responseSpecBuilder.build();
    }

    public static Response postAccount(HashMap<String, String> formParam) {
        return given().
                baseUri(Routes.DEV_KEYCLOCK_URL).
                contentType(ContentType.URLENC).
                formParams(formParam).
                when().post(Routes.TOKEN_GEN_BASE_PATH).
                then().spec(getResponseSpec()).extract().response();
    }

}
