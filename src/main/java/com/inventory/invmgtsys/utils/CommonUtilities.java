package com.inventory.invmgtsys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtilities {
    public static String generateUniqueFileName() {
        String filename = "";
        long millis = System.currentTimeMillis();
        String datetime = new Date().toGMTString();
        datetime = datetime.replace(" ", "");
        datetime = datetime.replace(":", "");
        //String rndchars=UUID.randomUUID().toString().replace("-", "");
        //String rndchars = RandomStringUtils.randomAlphanumeric(16);

        Random rand = new Random();
        String randomNum = String.format("%04d", rand.nextInt(10000));
        filename = randomNum + "_" + datetime + "_" + millis;
        return filename;
    }

    public static String getCurrentDateTime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);

    }

}