package com.inventory.invmgtsys.Schedular;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
public class SchedularTest {
    //
//    @Scheduled(fixedDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println("schedular");
////
////        System.out.println(
////                "Fixed delay task - " + System.currentTimeMillis() / 1000);
//        System.out.println("looping start");
//
//        for (int i=0;i<10;i++){
//            System.out.println("upper loop"+i);
//        }
//
//        for (int j=0;j<10;j++){
//            System.out.println("lower loop"+j);
//        }
//
//        System.out.println("looping ends");
//    }
//
//
//    //https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions
//    @Scheduled(cron = "0 0 12 * * ?")
//    @Scheduled(cron = "0 */1 * ? * *")  //every one minute
//    public void cronJobSch() {
//        System.out.println("crone job");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        Date now = new Date();
//        String strDate = sdf.format(now);
//        System.out.println("Java cron job expression:: " + strDate);
//    }



}