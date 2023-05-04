package com.sdrrshn.questiongeneratorapp.core.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @PostConstruct
    public void deneme(){
        sendSimpleMail("sidarsahin817@yandex.com","sidarsahin817@gmail.com","sannae");
    }
    public void sendSimpleMail(String from, String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setText(text);
        mailSender.send(message);
    }
}
