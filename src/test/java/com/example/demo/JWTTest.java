package com.example.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    /**
     * header =Base64Url=> eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
     * {
     *     "alg":"HS256",
     *     "typ":"JWT
     * }
     * payload =Base64Url=> eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ
     * {
     *     "sub":"1234567890",
     *     "name":"John Doe",
     *     "iat":1516239022 //Thu Jan 18 02:30:22 CET 2018
     * }
     * signature =HS256=> StaYQGgw8-HluVVvJ966c424bg1PKweHZDoDpJgD-_Q
     * HMACSHA256(
     *  base64UrlEncode(header) + "." +
     *  base64UrlEncode(payload),
     *  yukai //secret
     * )
     */
    public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.StaYQGgw8-HluVVvJ966c424bg1PKweHZDoDpJgD-_Q";

    /**
     * Initialize an instance of an Algorithm class with a secret key.
     * Use the HMAC256 (Hash-based Message Authentication Code) algorithm to sign JWT.
     *
     * A secret key is a piece of information used in cryptography to encrypt and decrypt data.
     * It is a unique and confidential value that is known only to the sender and recipient of the encrypted data.
     * The secret key is used to ensure the confidentiality and integrity of the encrypted information.
     */
    public Algorithm alg = Algorithm.HMAC256("yukai");

    @Test void createJWTWithSecretTest() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");

        Map<String, Object> payload = new HashMap<>();
        payload.put("sub", "1234567890");
        payload.put("name", "John Doe");
        payload.put("iat", 1516239022);

        try {
            String encodedJWT = JWT.create()
                    .withHeader(header)
                    .withPayload(payload)
                    .sign(alg);
            System.out.println(encodedJWT);
        } catch (JWTCreationException e) {
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }
}
