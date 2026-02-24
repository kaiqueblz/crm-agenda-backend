package com.kaique.crm;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

public class GenJwtSecret {
    public static void main(String[] args) {
        var key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 256 bits
        String b64 = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(b64);
        System.out.println("bytes=" + key.getEncoded().length);
    }
}