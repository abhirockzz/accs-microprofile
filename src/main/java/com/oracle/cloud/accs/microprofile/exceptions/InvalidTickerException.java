package com.oracle.cloud.accs.microprofile.exceptions;

public class InvalidTickerException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Ticker cannot be null!";
    }
    
}
