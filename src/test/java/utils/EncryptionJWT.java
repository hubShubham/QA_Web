package utils;

/*import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;*/

/**
 * @author Badredine BELHADEF #MZC
 */
public class EncryptionJWT {

   /* private static final String DEFAULT_KEY_ID = "defaultKeyId";
    private static final int DEFAULT_RSA_KEY_LENGTH = 2048;
    private static final RSAKeyGenerator DEFAULT_RSA_KEY_GENERATOR = new RSAKeyGenerator(DEFAULT_RSA_KEY_LENGTH);
    private static final JWSAlgorithm DEFAULT_JWS_ALGORITHM = JWSAlgorithm.RS256;
    private static final JWSHeader DEFAULT_JWS_HEADER =
            new JWSHeader.Builder(DEFAULT_JWS_ALGORITHM).keyID(DEFAULT_KEY_ID).build();
    private static final PlainHeader DEFAULT_PLAIN_HEADER = new PlainHeader.Builder().build();
    private static final String USER_DOMAIN_CLAIM_NAME = "user_domain";
    private static final String GROUPS_CLAIM_NAME = "groups";
    private static final String PERMISSIONS_CLAIM_NAME = "permissions";
    private static final List<String> DEFAULT_AUDIENCES = List.of("account");
    private static final String DEFAULT_ISSUER = "https://keycloak.dev.ppaas.tech/auth/realms/ppaas";
    private static final String DEFAULT_USER_DOMAIN = "ppaas";
    private static final List<String> DEFAULT_GROUPS = List.of("ppaas_service_payment");
    private static final List<String> PERMISSIONS_CLAIM_VALUE = List.of("pay.internalServicesFullAccess");
    private static final Date DEFAULT_EXPARY_DATE = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
    private static final JWTClaimsSet DEFAULT_VALID_CLAIMS = new JWTClaimsSet.Builder()
            .audience(DEFAULT_AUDIENCES)
            .issuer(DEFAULT_ISSUER)
            .claim(USER_DOMAIN_CLAIM_NAME, DEFAULT_USER_DOMAIN)
            .claim(GROUPS_CLAIM_NAME, DEFAULT_GROUPS)
            .claim(PERMISSIONS_CLAIM_NAME, PERMISSIONS_CLAIM_VALUE)
            .expirationTime(DEFAULT_EXPARY_DATE)
            .build();
    private static final JWTClaimsSet EXPIRED_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .expirationTime(Date.from(Instant.EPOCH))
            .build();
    private static final JWTClaimsSet BLANK_ISSUER_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .issuer("")
            .build();
    private static final JWTClaimsSet EMPTY_ISSUER_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .issuer(null)
            .build();
    private static final JWTClaimsSet WRONG_ISSUER_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .issuer("wrongIssuer")
            .build();
    private static final JWTClaimsSet BLANK_GROUPS_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .claim(GROUPS_CLAIM_NAME, List.of(""))
            .build();
    private static final JWTClaimsSet EMPTY_GROUPS_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .claim(GROUPS_CLAIM_NAME, null)
            .build();
    private static final JWTClaimsSet WRONG_GROUPS_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .claim(GROUPS_CLAIM_NAME, List.of("wrongGroup1", "wrongGroup2"))
            .build();
    private static final JWTClaimsSet BLANK_USER_DOMAIN_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .claim(USER_DOMAIN_CLAIM_NAME, "")
            .build();
    private static final JWTClaimsSet EMPTY_USER_DOMAIN_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .claim(USER_DOMAIN_CLAIM_NAME, null)
            .build();
    private static final JWTClaimsSet WRONG_USER_DOMAIN_CLAIM_SET = new JWTClaimsSet.Builder(DEFAULT_VALID_CLAIMS)
            .claim(USER_DOMAIN_CLAIM_NAME, "wrongUserDomain")
            .build();
    private static RSAKey RSA_KEY;
    private static RSASSASigner RSASSA_SIGNER;

    static {
        try {
            RSA_KEY = DEFAULT_RSA_KEY_GENERATOR.keyID(DEFAULT_KEY_ID).generate();
        } catch (JOSEException e) {
            e.printStackTrace();
        }

        try {
            RSASSA_SIGNER = new RSASSASigner(RSA_KEY);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }

    public static String createSignedJWT(JWSHeader jwsHeader, JWTClaimsSet jwtClaimsSet) throws JOSEException {
        SignedJWT signedJWT = new SignedJWT(jwsHeader, jwtClaimsSet);
        signedJWT.sign(RSASSA_SIGNER);

        return signedJWT.serialize();
    }

    public static PlainJWT createPlainJWT(PlainHeader plainHeader, JWTClaimsSet jwtClaimsSet) {
        PlainJWT plainJwt = new PlainJWT(plainHeader, jwtClaimsSet);
        return plainJwt;
    }

    public static String getDefaultKeyId() {
        return DEFAULT_KEY_ID;
    }

    public static int getDefaultRsaKeyLength() {
        return DEFAULT_RSA_KEY_LENGTH;
    }

    public static RSAKeyGenerator getDefaultRsaKeyGenerator() {
        return DEFAULT_RSA_KEY_GENERATOR;
    }

    public static RSAKey getRsaKey() {
        return RSA_KEY;
    }

    public static void setRsaKey(RSAKey rsaKey) {
        RSA_KEY = rsaKey;
    }

    public static RSASSASigner getRsassaSigner() {
        return RSASSA_SIGNER;
    }

    public static void setRsassaSigner(RSASSASigner rsassaSigner) {
        RSASSA_SIGNER = rsassaSigner;
    }

    public static JWSAlgorithm getDefaultJwsAlgorithm() {
        return DEFAULT_JWS_ALGORITHM;
    }

    public static JWSHeader getDefaultJwsHeader() {
        return DEFAULT_JWS_HEADER;
    }

    public static PlainHeader getDefaultPlainHeader() {
        return DEFAULT_PLAIN_HEADER;
    }

    public static String getUserDomainClaimName() {
        return USER_DOMAIN_CLAIM_NAME;
    }

    public static String getGroupsClaimName() {
        return GROUPS_CLAIM_NAME;
    }

    public static List<String> getDefaultAudiences() {
        return DEFAULT_AUDIENCES;
    }

    public static String getDefaultIssuer() {
        return DEFAULT_ISSUER;
    }

    public static String getDefaultUserDomain() {
        return DEFAULT_USER_DOMAIN;
    }

    public static List<String> getDefaultGroups() {
        return DEFAULT_GROUPS;
    }

    public static Date getDefaultExparyDate() {
        return DEFAULT_EXPARY_DATE;
    }

    public static JWTClaimsSet getDefaultValidClaims() {
        return DEFAULT_VALID_CLAIMS;
    }

    public static JWTClaimsSet getExpiredClaimSet() {
        return EXPIRED_CLAIM_SET;
    }

    public static JWTClaimsSet getBlankIssuerClaimSet() {
        return BLANK_ISSUER_CLAIM_SET;
    }

    public static JWTClaimsSet getEmptyIssuerClaimSet() {
        return EMPTY_ISSUER_CLAIM_SET;
    }

    public static JWTClaimsSet getWrongIssuerClaimSet() {
        return WRONG_ISSUER_CLAIM_SET;
    }

    public static JWTClaimsSet getBlankGroupsClaimSet() {
        return BLANK_GROUPS_CLAIM_SET;
    }

    public static JWTClaimsSet getEmptyGroupsClaimSet() {
        return EMPTY_GROUPS_CLAIM_SET;
    }

    public static JWTClaimsSet getWrongGroupsClaimSet() {
        return WRONG_GROUPS_CLAIM_SET;
    }

    public static JWTClaimsSet getBlankUserDomainClaimSet() {
        return BLANK_USER_DOMAIN_CLAIM_SET;
    }

    public static JWTClaimsSet getEmptyUserDomainClaimSet() {
        return EMPTY_USER_DOMAIN_CLAIM_SET;
    }

    public static JWTClaimsSet getWrongUserDomainClaimSet() {
        return WRONG_USER_DOMAIN_CLAIM_SET;
    }*/
}
