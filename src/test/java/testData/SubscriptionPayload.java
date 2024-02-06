package testData;

import java.util.UUID;

public class SubscriptionPayload {

    UUID entityID = UUID.randomUUID();
public String subscriptionTD(){
    System.out.println("The entityID id is" +  entityID);

    return "{    \n" +
             "  \"requestId\": \""+entityID+"\" ,\n" +
             "  \"requestType\": \"addpackage\",\n" +
             "  \"packages\": [\n" +
             "   {\n" +
             "    \"packageId\":\"b71953ea-9b67-4409-9c01-ccb486b0ecee\",\n" +
             "    \"packageName\": \"PPaaS Payment Services\"\n" +
             "  }\n" +
             "  ]\n" +
             "}\n";
}

}
