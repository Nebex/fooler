package com.example.user.foolr;

/**
 * Created by user on 7/29/2015.
 */
public class CryptoException extends Throwable {
    public CryptoException() {
    }

    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
