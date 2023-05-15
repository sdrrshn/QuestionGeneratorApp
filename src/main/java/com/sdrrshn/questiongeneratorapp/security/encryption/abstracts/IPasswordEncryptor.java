package com.sdrrshn.questiongeneratorapp.security.encryption.abstracts;

public interface IPasswordEncryptor {
    String encrypt(String password);

    boolean matches(String rawPassword, String hash);
}
