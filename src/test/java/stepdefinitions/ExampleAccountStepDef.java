package stepdefinitions;

public class ExampleAccountStepDef extends Commons {

/*

    public ExampleAccountStepDef() throws JOSEException {
        this.addJWTtoHeader();
    }


    @Given("^InDx receives the payment card information \"([^\"]*)\"$")
    public void prepareRequest(String cardPan) throws IOException {

        var now = OffsetDateTime.now(Clock.systemUTC());

        if (!this.initialized) {
            this.setHeaderService("ah-bambora-ga-online-service");
        }

        var url = properties.getProperty("account.check");

        var dataJson = new String(Files.readAllBytes(Paths.get(properties.getProperty("datasets.folder") + "account/exampleCardholderAccount.json")));

        var requestValues = new HashMap<String, Object>();

        var requestId = UUID.randomUUID().toString();
        var transactionId = UUID.randomUUID().toString();
        var transactionRef = String.valueOf(this.generateRandomDigitValue(12));
        var acceptorRef = String.valueOf(this.generateRandomDigitValue(12));

        requestValues.put("header.requestId", requestId);
        requestValues.put("header.references.transactionId", transactionId);
        requestValues.put("transaction.transactionRef", transactionRef);
        requestValues.put("transaction.acceptorReference", acceptorRef);
        requestValues.put("transaction.transTime", now.toString());
        requestValues.put("transaction.localDateTime", now.toString());
        requestValues.put("card.pan", cardPan);

        //dataJson = this.updateJsonValue(requestValues, dataJson);

        this.buildRequestWithJsonFile(dataJson, url);
    }

    @When("InDx sends a validity check of	 the card holder account request to AH")
    public void sendAccountCheckRequest() {
        this.post();
    }

    */
/*
        @Then("Check status code is {string}")
        public void checkStatusCode(String code) {
        this.vResponse.statusCode(Integer.parseInt(code));


        }
    *//*

    @Then("^Ahub errorCode \"([^\"]*)\" is sent back$")
    public void checkErrorCode(String errorCode) {
        this.vResponse.assertThat().body("result.errorCode", Is.is(errorCode));
    }
*/

}
