package utils;

public class SslConfigUtils {

    /*private SslConfigUtils() {
        throw new IllegalStateException("Use of default constructor is forbidden");
    }

    public static void initConfig(Properties properties) {

        if (properties.getProperty("env").equals("")) {

            var keystorePassword = System.getenv("keystore_pwd");
            var truststorePassword = System.getenv("truststore_pwd");

            var pathToKeystore = "src/test/resources/example.keystore.p12";
            var pathToTruststore = "src/test/resources/example.truststore.p12";

            var sslConfig = new SSLConfig()
                    .keystoreType("PKCS12")
                    .keyStore(pathToKeystore, keystorePassword)
                    .trustStoreType("PKCS12")
                    .trustStore(pathToTruststore, truststorePassword);

            RestAssured.config = RestAssuredConfig.newConfig().sslConfig(sslConfig);
        }
    }*/
}
