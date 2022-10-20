package com.example.www.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {
 
    private JavaMailSender mailSender;
 
    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
 
    public void prepareAndSend(String recipient, String message) {
       MimeMessagePreparator messagePreparator = mimeMessage -> {
             MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
             messageHelper.setFrom("Flirtatious");
             messageHelper.setTo(recipient);
             messageHelper.setSubject("登入信息");
             messageHelper.setText("您已成功登入Flirtatious購物網");
         };
         try {
             mailSender.send(messagePreparator);
             //System.out.println("sent");
         } catch (MailException e) {
             //System.out.println(e);
             // runtime exception; compiler will not force you to handle it
         }
    }
    public void comments(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
              MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
              messageHelper.setFrom("Flirtatious");
              messageHelper.setTo(recipient);
              messageHelper.setSubject("謝謝您的指教!");
              messageHelper.setText("感謝您對本購物網的支持，您的一切問題都是我們進步的最大動力!歡迎再次光臨，我們隨時服務!");
          };
          try {
              mailSender.send(messagePreparator);
              //System.out.println("sent");
          } catch (MailException e) {
              //System.out.println(e);
              // runtime exception; compiler will not force you to handle it
          }
     }
    public void discount(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
              MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
              messageHelper.setFrom("Flirtatious");
              messageHelper.setTo(recipient);
              messageHelper.setSubject("專屬優惠碼");
              messageHelper.setText("flirtatious888");
          };
          try {
              mailSender.send(messagePreparator);
              //System.out.println("sent");
          } catch (MailException e) {
              //System.out.println(e);
              // runtime exception; compiler will not force you to handle it
          }
     }
    public void forgetaccount(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
              MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
              messageHelper.setFrom("Flirtatious");
              messageHelper.setTo(recipient);
              messageHelper.setSubject("重設密碼");
              messageHelper.setText("請到下列網站重新設定密碼------>"+"http://localhost:8080/forgetpassword.html");
          };
          try {
              mailSender.send(messagePreparator);
              //System.out.println("sent");
          } catch (MailException e) {
              //System.out.println(e);
              // runtime exception; compiler will not force you to handle it
          }
     }
}