package com.kaique.crm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestHash {
    public static void main(String[] args) {
        var encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("Admin123!"));
    }
}