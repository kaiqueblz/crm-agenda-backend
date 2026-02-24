package com.kaique.crm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateBcryptHash {
    public static void main(String[] args) {
        var encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("Admin123!");
        System.out.println(hash);
        System.out.println("Tamanho: " + hash.length());
    }
}