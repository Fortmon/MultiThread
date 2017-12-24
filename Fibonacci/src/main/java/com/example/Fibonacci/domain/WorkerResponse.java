package com.example.Fibonacci.domain;

import java.math.BigInteger;

public class WorkerResponse {
    private boolean success;
    private String host;
    private BigInteger value;
    private int number;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public WorkerResponse(){

    }

    public WorkerResponse(boolean success, String host, int number, BigInteger value){
        this.success = success;
        this.host = host;
        this.number = number;
        this.value = value;
    }
}
