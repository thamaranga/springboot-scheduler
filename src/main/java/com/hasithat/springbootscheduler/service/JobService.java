package com.hasithat.springbootscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;

@Service
public class JobService {

    @Autowired
    private NotificationService service;

    //@Scheduled(fixedRate=60000)
    @Scheduled(cron = "${cron_interval}")
    public void processEmailSending(){
        try {
            System.out.println("Job execution started.....");
            String result=service.sendDailyReport();
            System.out.println("Email sending result|"+result);
            System.out.println("Job execution finished.....");
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
