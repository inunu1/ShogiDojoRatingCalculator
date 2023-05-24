package com.Inunu1.ShogiDojoRatingCalculator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LocalTest {
    public static void main(String[] args){
        BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
        System.out.println(encorder.encode("yohin"));
    }
}
