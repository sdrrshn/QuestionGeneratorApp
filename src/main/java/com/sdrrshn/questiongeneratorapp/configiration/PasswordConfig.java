package com.sdrrshn.questiongeneratorapp.configiration;

import com.sdrrshn.questiongeneratorapp.security.encryption.abstracts.IPasswordEncryptor;
import com.sdrrshn.questiongeneratorapp.security.encryption.concrete.BCryptPasswordEncryptorAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordConfig {
    @Bean
    IPasswordEncryptor getPasswordEncryptor() {
        return new BCryptPasswordEncryptorAdapter(11);
    }

}