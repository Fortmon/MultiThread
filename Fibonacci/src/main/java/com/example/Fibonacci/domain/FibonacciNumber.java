package com.example.Fibonacci.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name="fibonacci_number")
public class FibonacciNumber {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    @Id
    private int id;
    private int number;
    private BigInteger value;

    public FibonacciNumber() {

    }

    public FibonacciNumber(int id, int number, BigInteger value) {
        this.id = id;
        this.number = number;
        this.value = value;
    }
}
