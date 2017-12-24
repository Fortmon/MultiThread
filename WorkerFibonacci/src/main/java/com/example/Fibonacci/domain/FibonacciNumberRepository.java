package com.example.Fibonacci.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciNumberRepository extends JpaRepository<FibonacciNumber, Integer> {
    @Query(value = "Select id, number, value From fibonacci_number Where id=1 for update", nativeQuery = true)
    FibonacciNumber getFibonacciNumber();
}
