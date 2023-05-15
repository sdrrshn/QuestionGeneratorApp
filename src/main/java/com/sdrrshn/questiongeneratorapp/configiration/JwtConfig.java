package com.sdrrshn.questiongeneratorapp.configiration;

import com.sdrrshn.questiongeneratorapp.service.abstracts.IJwtUtil;
import com.sdrrshn.questiongeneratorapp.service.concretes.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public IJwtUtil getJwt() {
        return new JwtUtil("sdafvgbhbgvfcdfvghbnjnhbg", (Long) (1000L * 24 * 60 * 60 * 30));
    }
}
