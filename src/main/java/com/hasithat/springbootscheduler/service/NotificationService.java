package com.hasithat.springbootscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class NotificationService {

    @Autowired
    private ReportService reportService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${report.send.toemail.list}")
    private String toEmails;

    public String sendDailyReport() throws MessagingException, IOException {


            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(toEmails.split(","));
            mimeMessageHelper.setSubject("List_Of_orders_"+(new Date().getTime()));
            mimeMessageHelper.setText("Hi  refer attached excel file");
            byte[] bytes = reportService.generateReport();
            ByteArrayResource content=new ByteArrayResource(bytes);
            mimeMessageHelper.addAttachment("orders.xlsx", content);
            javaMailSender.send(mimeMessage);
            return "email sent successfully";

        }


    }


