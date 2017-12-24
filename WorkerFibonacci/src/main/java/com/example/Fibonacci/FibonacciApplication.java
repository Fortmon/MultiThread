package com.example.Fibonacci;

import com.example.Fibonacci.domain.FibonacciNumber;
import com.example.Fibonacci.domain.FibonacciNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FibonacciApplication {

	@Autowired
	private FibonacciNumberRepository fibonacciNumberRepository;

	public static void main(String[] args) {
		SpringApplication.run(FibonacciApplication.class, args);
	}
}
