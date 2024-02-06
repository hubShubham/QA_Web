package reusableClass;


import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;


public class TokenGeneration {

    private static String access_token;
    private static Instant expiry_time;


    public static String getToken() {
        try {
            if (access_token == null || Instant.now().isAfter(expiry_time)) {
               // System.out.println("Renewing token");
                Response response = tokenGen();
                access_token = response.path("access_token");
                int expiryDurationinSecs = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationinSecs);
            } else {
                System.out.println("Token is good to use");
            }

        } catch (Exception exception) {
            throw new RuntimeException("Abort! failed to get token");
        }
        return access_token;
    }


    private static Response tokenGen() {
        HashMap<String, String> formParam = new HashMap<String, String>();
        formParam.put("client_id", "admin-cli");
        // formParam.put("refresh_toeken" ,"2323");
        formParam.put("grant_type", "password");
        formParam.put("username", "admin");
        formParam.put("password", "@Admin12345");

        Response response = SpecBuilder.postAccount(formParam);

    /*  Response response= (Response) given().
              baseUri("https://keycloak.dev.ppaas.tech").
              contentType(ContentType.URLENC).
              formParams(formParam).
                when().post("/auth/realms/ppaas/protocol/openid-connect/token").
                then().spec(getResponseSpec()).extract().response();*/

        if (response.statusCode() != 200) {
            throw new RuntimeException("Abort!, renew token failed");
        }
        return response;
    }

}
