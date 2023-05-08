package com.sdrrshn.questiongeneratorapp.configiration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender createJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("questionappform@gmail.com");
        javaMailSender.setPassword("nxofeiopfloikvnp");

        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.quitwait", "false");

        return javaMailSender;

    }
}
//spring.mail.host=smtp.yandex.com
//        spring.mail.port=587
//        spring.mail.username=sidarsahin817@yandex.com
//spring.mail.password=idjogqzhzmpvxhpy
//        spring.mail.properties.mail.smtp.auth=true
//        spring.mail.properties.mail.smtp.starttls.enable=true