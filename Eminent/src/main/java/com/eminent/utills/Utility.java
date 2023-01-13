package com.eminent.utills;

import java.util.Random;

public class Utility {
    private static Random rndm_method = new Random();
    public static String GenerateOtp(){
        String generator = "1357902468";
        String result = "";
        // Using random method

        for (int i = 0; i < 6; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            result  = result + generator.charAt(rndm_method.nextInt(generator.length()));
        }
        return result;
    }
}
