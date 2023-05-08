package com.sdrrshn.questiongeneratorapp.core.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MailService {

    @Value("${email.from}")
    private String fromEmail;
    @Autowired
    private JavaMailSender mailSender;




    public void sendSımpleMessage(String to, String text) {
        sendSımpleMessage(fromEmail, to, text);
    }

    public void sendSımpleMessage(String from, String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(text);
        message.setFrom(from);
        message.setTo(to);
        mailSender.send(message);
    }
}
