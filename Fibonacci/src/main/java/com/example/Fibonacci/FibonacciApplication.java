package com.example.Fibonacci;

import com.example.Fibonacci.domain.FibonacciNumber;
import com.example.Fibonacci.domain.FibonacciNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@SpringBootApplication
public class FibonacciApplication {

	@Autowired
	private FibonacciNumberRepository fibonacciNumberRepository;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner cmr(){
		return (args) -> {
			FibonacciNumber first = new FibonacciNumber(1, 1, BigInteger.valueOf(1));
			fibonacciNumberRepository.save(first);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(FibonacciApplication.class, args);
	}
}
