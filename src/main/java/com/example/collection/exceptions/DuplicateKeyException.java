package com.example.collection.exceptions;

public class DuplicateKeyException extends RuntimeException {

    public DuplicateKeyException(String key) {
        super("Duplicate keys are not allowed: \"" + key + "\".");
    }
}
