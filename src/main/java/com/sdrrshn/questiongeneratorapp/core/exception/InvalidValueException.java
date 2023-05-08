package com.sdrrshn.questiongeneratorapp.core.exception;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(){
        super("Available in the system");
    }
    public InvalidValueException(String errorMessage) {
        super(errorMessage);
    }
}
