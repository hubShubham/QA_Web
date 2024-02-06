package stepdefinitions;

public class Commons {

    /*public static String authorizeBodyResponse;
    public final RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
    public final Properties properties = PropertiesUtils.loadProperties();
    public Response response;
    public ResponseBody<?> body;
    public ValidatableResponse vResponse;
    public RequestSpecification requestSpec;
    public boolean initialized;

    public static String getRandomNumber(int digCount) {
        var rnd = new Random();
        var sb = new StringBuilder(digCount);
        for (int i = 0; i < digCount; i++) {
            sb.append((char) ('0' + rnd.nextInt(10)));
        }
        return sb.toString();
    }

 *//*   public void addJWTtoHeader() throws JOSEException {
        JWTClaimsSet jwtClaimsSet;
        jwtClaimsSet = EncryptionJWT.getDefaultValidClaims();
        String token = EncryptionJWT.createSignedJWT(EncryptionJWT.getDefaultJwsHeader(), jwtClaimsSet);
        this.requestBuilder.addHeader("Authorization", "Bearer " + token);
    }*//*

    public void setHeaderService(String destService) {
        initialized = true;
        requestBuilder.addHeader("X-Destination-Service", destService);
    }

    public void setHeader(String key, String value) {
        requestBuilder.addHeader(key, value);
    }

    public void setPath(String path) {
        requestBuilder.setBasePath(path);
    }

	*//*public void setRequestBody(DataTable paramTable) {
		var requestParams = new JSONObject();
		paramTable.asLists().forEach(row -> requestParams.put(row.get(0), row.get(1)));
		requestBuilder.setBody(requestParams.toJSONString());
	}*//*

    public void parameters(DataTable paramTable) {
        var rows = paramTable.asLists();
        for (var row : rows) {
            requestBuilder.addParam(row.get(0), row.get(1));
            System.out.println(row.get(1));
        }
    }

    public void listDataTable(DataTable dataTable) {

        List<List<String>> list = dataTable.asLists(String.class);
        for (List<String> e : list) {
            System.out.println("Package codelist" + e);
        }
    }

    public void mapDataTable(DataTable dataTable) {
        List<Map<String, String>> dataTableList = dataTable.asMaps(String.class, String.class);
        //dataTableList.get(0).get("PkgID");
        for (Map<String, String> e : dataTableList) {
            e.get(0);
            System.out.println("The value of maps is" + e.get(0));
        }

    }

    public void get() {
        requestSpec = requestBuilder.build();
        System.out.println("the request specification is " + vResponse);
        vResponse = given().spec(requestSpec).when().get().then();
        System.out.println("the request response is " + vResponse);
    }

    //Functions is used to get the response of GEt API as String
    public String getResponseFromGetRequest() {
        requestSpec = requestBuilder.build();
        response = given().spec(requestSpec).when().get();
        body = response.getBody();
        // response.prettyPrint();
        //int statusCode = response.getStatusCode();
        return body.asString();
    }

    public int getSuccessRC() {
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    //Function to fetch JsonArray Data
    public int JsonArrayElements(String packages) {

        body = response.getBody();
        String resp = body.asString();
        JSONObject jsonObj = new JSONObject(resp);
        JSONArray jArray = jsonObj.getJSONObject("data").getJSONArray("packages");

        JSONObject item = jArray.getJSONObject(0);
        jArray = item.getJSONArray("services");
        System.out.println("Array size is: " + jArray.length());
        return jArray.length();


    }

    public int packageDetails(String entityType, String entityId) {
        body = response.getBody();
        String resp = body.asString();
        JSONObject jsonObj = new JSONObject(resp);
        JSONArray jArray = jsonObj.getJSONObject("data").getJSONArray("packages");

        JSONObject item = jArray.getJSONObject(0);
        jArray = item.getJSONArray("services");
        System.out.println("Array size is: " + jArray.length());
        return jArray.length();
    }

    public void postThenReturn() {
        requestSpec = requestBuilder.build();
        response = given().spec(requestSpec).when().post().thenReturn();
    }

    public Integer postAndGetStatus() {
        requestSpec = requestBuilder.build();
        return given().spec(requestSpec).when().post().thenReturn().statusCode();
    }

    public void put() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().put().then();
    }

    public void delete() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().delete().then();
    }


    public String getResponseFromPostRequest() {
        requestSpec = requestBuilder.build();
        response = given().spec(requestSpec).when().post();
        body = response.getBody();
        return body.asString();
    }

    public String generateRandomDigitValue(int length) {
        var random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return new String(digits);
    }

    public void buildRequestWithJsonFile(String dataJson, String urlEndPoint) {
        requestBuilder.setBasePath(urlEndPoint);
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.setBody(dataJson);
        requestSpec = requestBuilder.build();
    }

	*//*public String updateJsonValue(Map<String, ?> dataJson, String stringJson) {

		var configuration = Configuration.builder()
				.jsonProvider(new JacksonJsonNodeJsonProvider())
				.mappingProvider(new JacksonMappingProvider())
				.build();

		var json = JsonPath.using(configuration).parse(stringJson);

		for (var entry : dataJson.entrySet()) {
			json.set(entry.getKey(), entry.getValue());
		}

		return json.jsonString();
	}*//*

    public void pause(long timeInMilliSeconds) {
        var timestamp = System.currentTimeMillis();
        do {
        } while (System.currentTimeMillis() < timestamp + timeInMilliSeconds);
    }

    public boolean postAsStatus(Integer expected) {
        post();
        return (this.vResponse.extract().statusCode() == expected);
    }

    public void post() {
        requestSpec = requestBuilder.build();
        vResponse = given().spec(requestSpec).when().post().then();
    }

*/
}



