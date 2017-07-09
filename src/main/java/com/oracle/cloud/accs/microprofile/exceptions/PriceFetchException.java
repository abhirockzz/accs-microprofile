package com.oracle.cloud.accs.microprofile.exceptions;

public class PriceFetchException extends RuntimeException{
    private String ticker;
    
    public PriceFetchException(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String getMessage() {
        return "Could not fetch price for "+ ticker;
    }
}
