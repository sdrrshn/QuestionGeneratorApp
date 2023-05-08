package com.sdrrshn.questiongeneratorapp.configiration;

import net.bytebuddy.utility.RandomString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomConfig {

    @Bean
    public RandomString createRandom() {
        return new RandomString();
    }
}
