package com.example.userservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class Utils {

    public static void main(String[] args) {
        log.info("password: {}", new BCryptPasswordEncoder().encode("password"));
    }

}
