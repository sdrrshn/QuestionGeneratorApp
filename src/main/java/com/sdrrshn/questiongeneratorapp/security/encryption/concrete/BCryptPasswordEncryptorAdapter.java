package com.sdrrshn.questiongeneratorapp.security.encryption.concrete;

import com.sdrrshn.questiongeneratorapp.security.encryption.abstracts.IPasswordEncryptor;
import com.sdrrshn.questiongeneratorapp.security.encryption.bcrypt.BCryptPasswordEncryptor;

public class BCryptPasswordEncryptorAdapter implements IPasswordEncryptor {
    private final Integer logRounds;

    public BCryptPasswordEncryptorAdapter(Integer logRounds) {
        this.logRounds = logRounds;
    }

    @Override
    public String encrypt(String password) {
        return BCryptPasswordEncryptor.encrypt(password, this.logRounds);
    }

    @Override
    public boolean matches(String rawPassword, String hash) {
        return BCryptPasswordEncryptor.matches(rawPassword, hash);
    }

}
