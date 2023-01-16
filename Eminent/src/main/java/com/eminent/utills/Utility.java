package com.eminent.utills;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
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

    public static void sendOTP(String message , String number )
    {
        try
        {
            String apiKey="4Pqizk1Wvh8XwDQrYIj0oJRGBTVgfU3ps5ML26SxuZKl7AHcdmBQJWPskVHh3OpXjvAt146iUD0yrGEw";
            String sendId="Eminent";
            String language="english";
            String route="otp";
            message= URLEncoder.encode(message,"UTF-8");    //Important Step
            String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&variables_values="+message+"&sender_id="+sendId+"&language="+language+"&route="+route+"&numbers="+number;
            URL url=new URL(myUrl);
            HttpsURLConnection con= (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            // con.setRequestProperty("User-Agent","Mozilla/5.0");
            con.setRequestProperty("cache-control", "no-cache");

            // int responseCode=  con.getResponseCode();

            StringBuffer response=new StringBuffer();

            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));

            while(true)
            {
                String line=br.readLine();

                if(line==null)
                {
                    break;
                }

                response.append(line);
            }

        }
        catch(Exception e)
        {
//            PrintStackTrash(e);
//            printStackTrace(e);
            System.out.println(e);
        }
    }

}
